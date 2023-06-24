package com.atypon.play.cardgameverse.gamegallery.uno.game;


import com.atypon.play.cardgameverse.coreengine.Game;
import com.atypon.play.cardgameverse.coreengine.Player;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.Card;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.NumberCard;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.UnoCardSet;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.CardPlayVisitor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.ValidCardToPlayVisitor;

import java.util.List;
import java.util.Scanner;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.*;
import static com.atypon.play.cardgameverse.gamegallery.uno.utils.CardsUtils.dealCards;

public class UnoGame extends Game {
    private final UnoGameStatus gameStatus;

    private UnoGame(List<Player> players) {
        super(new UnoCardSet());
        this.players = players;
        gameStatus = new UnoGameStatus(players.size());
    }

    public static UnoGame createNewUnoGame(List<Player> players) {
        if (players.size() > TEN || players.size() < TWO) {
            throw new IllegalArgumentException(NUMBER_OF_PLAYERS_OUT_OF_POUND);
        }
        return new UnoGame(players);
    }

    private static int readMoveCardIndex(int playerHandSize) {
        System.out.println(ENTER_CARD_INDEX);
        Scanner scanner = new Scanner(System.in);
        int cardIndex = scanner.nextInt();
        if (cardIndex < -1 || cardIndex >= playerHandSize)
            throw new IndexOutOfBoundsException(INVALID_TO_CARD_TO_PLAY_INDEX);
        return cardIndex;
    }

    @Override
    public void play() {
        setUp();
        while (!gameStatus.getIsGameFinished()) {
            notifyObservers();
            Player player = CurrentPlayerTurn();
            int moveCardIndex;

            try {
                moveCardIndex = readMoveCardIndex(player.getHand().size());
            } catch (IndexOutOfBoundsException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
            if (moveCardIndex == DRAW_CARDS_INDEX) {
                if (gameStatus.getCardsToDrawNumber() == ZERO) gameStatus.increaseCardsToDrawNumber(ONE);
                drawCards(player);
            } else {
                Card moveCard = player.getHand().get(moveCardIndex);
                try {
                    ValidCardToPlayVisitor validCardToPlayVisitor = new ValidCardToPlayVisitor(gameStatus);
                    moveCard.accept(validCardToPlayVisitor);

                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                    continue;
                }
                CardPlayVisitor cardPlayVisitor = new CardPlayVisitor(gameStatus);
                moveCard.accept(cardPlayVisitor);
                gameStatus.setCurrentCard(moveCard);
                player.removeCardFromHand(moveCard);
            }
            if (player.hasWon()) {
                gameStatus.setGameFinished(true);
                continue;
            }
            moveToNextPlayer();
        }
    }

    private void moveToNextPlayer() {
        if (!gameStatus.getIsClockWise()) {
            if (gameStatus.getCurrentPlayerIndex() > ZERO) gameStatus.decreaseCurrentPlayerIndex();
            else gameStatus.setCurrentPlayerIndex(players.size() - 1);
        } else {
            if (gameStatus.getCurrentPlayerIndex() < players.size() - 1) gameStatus.increaseCurrentPlayerIndex();
            else gameStatus.setCurrentPlayerIndex(ZERO);
        }
    }

    private Player CurrentPlayerTurn() {
        Player player = this.players.get(gameStatus.getCurrentPlayerIndex());
        System.out.println(player.getName().toUpperCase() + YOUR_TURN);
        return player;
    }

    private void drawCards(Player player) {
        Card deckCard = deck.getCards().remove(0);
        for (int i = 0; i < gameStatus.getCardsToDrawNumber(); i++) {
            player.addCardToHand(deckCard);
        }
        gameStatus.setCardsToDrawNumber(ZERO);
    }

    private void setUp() {
        dealCards(7, players, deck);
        setInitialCard();
    }

    private void setInitialCard() {
        for (int i = deck.getCards().size() - 1; i > 0; i--) {
            Card card = deck.getCards().get(i);
            if (card instanceof NumberCard) {
                gameStatus.setCurrentCard(card);
                break;
            }
        }
    }


    @Override
    public void notifyObservers() {
        for (Player player : players) {
            player.update(gameStatus.getCurrentCard(), gameStatus.getCardsToDrawNumber());
        }
    }
}
