package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.coreengine.Card;
import com.atypon.play.cardgameverse.coreengine.CardSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.*;

public class UnoCardSet implements CardSet {
    protected List<Card> cardSet;

    public UnoCardSet() {
        initializeCardSet();
    }

    @Override
    public void initializeCardSet() {
        cardSet = new ArrayList<>();
        UnoCardsFactory unoCardsFactory = new UnoCardsFactory(cardSet);
        unoCardsFactory.addCards(NUMBER);
        unoCardsFactory.addCards(ACTION);
        unoCardsFactory.addCards(WILD);
        Collections.shuffle(cardSet);
    }

    public List<Card> getCards() {
        return cardSet;
    }

}