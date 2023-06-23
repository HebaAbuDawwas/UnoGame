package com.atypon.play.cardgameverse.coreengine;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CardSet {


    protected List<Card> cardSet;

    protected CardSet() {
        cardSet = new ArrayList<>();
        initializeCardSet();
    }

    protected abstract void initializeCardSet();

    public List<Card> getCards() {
        return cardSet;
    }

}
