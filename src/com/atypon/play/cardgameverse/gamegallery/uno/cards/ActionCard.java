package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.ActionCardType;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors.CardVisitor;

public class ActionCard extends UnoCard {
    private final ActionCardType actionCardType;

    public ActionCard(ActionCardType actionCardType, CardColor color) {
        super(color);
        this.actionCardType = actionCardType;
    }

    public ActionCardType getActionType() {
        return actionCardType;
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        return "- color : " + this.getColor() + " - * action : " + this.actionCardType + "\n";
    }
}
