package com.atypon.play.cardgameverse.coreengine.observerpattern;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.Card;

public interface Observer {
    void update(Card CurrentCard, int CardsToDrawNumber);
}