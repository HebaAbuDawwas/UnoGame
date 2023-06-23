package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardNumber;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.CardVisitor;

public class NumberCard extends Card {
    private final CardNumber number;

    public NumberCard(CardNumber number, CardColor color) {
        super(color);
        this.number = number;
    }

    public CardNumber getNumber() {
        return number;
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        return "-  color : " + this.getColor() + " - number : " + this.getNumber() + "\n";
    }
}
