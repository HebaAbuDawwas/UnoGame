package com.atypon.play.cardgameverse.gamegallery.uno.utils;

import com.atypon.play.cardgameverse.coreengine.Card;
import com.atypon.play.cardgameverse.coreengine.CardSet;
import com.atypon.play.cardgameverse.coreengine.Player;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.*;

public class CardsUtils {

    public static void dealCards(int noOfCardsToDeal, List<Player> players, CardSet cardSet) {
        List<Card> deck = cardSet.getCards();
        Collections.shuffle(deck);
        for (Player player : players) {
            List<Card> playerHand = new ArrayList<>();
            for (int i = 0; i < noOfCardsToDeal; i++) {
                Card unoCard = deck.remove(0);
                playerHand.add(unoCard);
            }
            player.setHand(playerHand);
        }
    }

    public static CardColor readNewWildCardColor() {
        Scanner scanner = new Scanner(System.in);
        CardColor color = null;

        while (color == null || color == CardColor.WILD) {
            System.out.print(ENTER_COLOR);
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                color = CardColor.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_COLOR);
            }
        }

        return color;
    }

    public static int readMoveCardIndex(int playerHandSize) {
        System.out.println(ENTER_CARD_INDEX);
        Scanner scanner = new Scanner(System.in);
        int cardIndex = scanner.nextInt();
        if (cardIndex < -1 || cardIndex >= playerHandSize)
            throw new IndexOutOfBoundsException(INVALID_TO_CARD_TO_PLAY_INDEX);
        return cardIndex;

    }

}
