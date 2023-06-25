package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.coreengine.Card;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.CardVisitor;

public abstract class UnoCard implements Card {
    private CardColor color;

    protected UnoCard(CardColor color) {
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public abstract void accept(CardVisitor visitor);

    public abstract String toString();


}
