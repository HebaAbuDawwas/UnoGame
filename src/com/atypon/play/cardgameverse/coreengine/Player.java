package com.atypon.play.cardgameverse.coreengine;

import com.atypon.play.cardgameverse.coreengine.observerpattern.Observer;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.Card;

import java.util.ArrayList;
import java.util.List;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.WINNER_MESSAGE;

public class Player implements Observer {
    private final String name;

    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void showHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i) + " - " + hand.get(i));
        }
    }

    public void addCardToHand(Card unoCard) {
        hand.add(unoCard);
    }

    public void removeCardFromHand(Card unoCard) {
        hand.remove(unoCard);
    }

    public boolean hasWon() {
        if (hand.isEmpty()) {
            System.out.println(getName() + WINNER_MESSAGE);
            return true;
        }
        return false;
    }

    public void update(Card currentCard, int cardsToDrawNumber) {
        System.out.println(name);
        System.out.println("Your Cards : ");
        showHand();
        System.out.println("Current Card : " + currentCard.toString());
        if (cardsToDrawNumber > 0) System.out.println("Number of cards you need to draw : " + cardsToDrawNumber);
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + '}';
    }

}
