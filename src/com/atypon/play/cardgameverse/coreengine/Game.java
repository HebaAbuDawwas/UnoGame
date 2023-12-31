package com.atypon.play.cardgameverse.coreengine;

import com.atypon.play.cardgameverse.coreengine.observerpattern.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Subject {


    protected CardSet deck;
    protected List<Player> players;

    protected Game(CardSet cardSet) {
        this.deck = cardSet;
        players = new ArrayList<>();
    }


    public abstract void play();

}
