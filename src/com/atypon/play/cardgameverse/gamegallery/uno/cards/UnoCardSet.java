package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.coreengine.CardSet;

import java.util.Collections;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.*;

public class UnoCardSet extends CardSet {
    public UnoCardSet() {
        super();
    }

    @Override
    protected void initializeCardSet() {
        UnoCardsFactory unoCardsFactory = new UnoCardsFactory(cardSet);
        unoCardsFactory.addCards(NUMBER);
        unoCardsFactory.addCards(ACTION);
        unoCardsFactory.addCards(WILD);
        Collections.shuffle(cardSet);
    }


}