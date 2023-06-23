package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.CardVisitor;

public abstract class Card {
    private CardColor color;

    protected Card(CardColor color) {
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
