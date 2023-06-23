package com.atypon.play.cardgameverse.gamegallery.uno.game;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.Card;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.ONE;
import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.ZERO;

public class UnoGameStatus {
    private final int playersCount;
    private boolean isGameFinished;
    private int cardsToDrawNumber;
    private boolean isClockWise;
    private int currentPlayerIndex;
    private Card currentCard;

    public UnoGameStatus(int playersCount) {
        isGameFinished = false;
        cardsToDrawNumber = 0;
        isClockWise = true;
        currentPlayerIndex = 0;
        this.playersCount = playersCount;
    }

    public void reversePlayDirection() {
        isClockWise = !isClockWise;
        if (isClockWise) skipPlayerBack();
        else skipPlayer();
    }

    public void increaseCardsToDrawNumber(int n) {
        cardsToDrawNumber += n;
    }

    public void skipPlayer() {
        if (isClockWise) {
            if (currentPlayerIndex == playersCount - ONE)
                currentPlayerIndex = ZERO;
            else
                currentPlayerIndex++;
        } else {
            if (currentPlayerIndex == 0)
                currentPlayerIndex = playersCount - 1;
            else
                currentPlayerIndex--;
        }
    }

    public void skipPlayerBack() {
        if (isClockWise) {
            if (currentPlayerIndex > 0)
                currentPlayerIndex--;
            else currentPlayerIndex = playersCount - ONE;
        } else {
            if (currentPlayerIndex < playersCount - ONE)
                currentPlayerIndex++;
            else
                currentPlayerIndex = 0;

        }
    }

    public boolean getIsGameFinished() {
        return isGameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    public int getCardsToDrawNumber() {
        return cardsToDrawNumber;
    }

    public void setCardsToDrawNumber(int cardsToDrawNumber) {
        this.cardsToDrawNumber = cardsToDrawNumber;
    }

    public boolean getIsClockWise() {
        return isClockWise;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void decreaseCurrentPlayerIndex() {
        this.currentPlayerIndex--;
    }

    public void increaseCurrentPlayerIndex() {
        this.currentPlayerIndex++;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
}
