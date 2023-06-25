package com.atypon.play.cardgameverse.coreengine;

import com.atypon.play.cardgameverse.coreengine.observerpattern.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Observer {
    private final String name;

    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
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

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public abstract boolean hasWon();

    public void update(GameStatus gameStatus) {
        System.out.println(name);
        System.out.println("Your Cards : ");
        showHand();
        System.out.println(gameStatus.toString());
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + '}';
    }

}
