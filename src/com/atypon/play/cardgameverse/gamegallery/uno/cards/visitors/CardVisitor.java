package com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.ActionCard;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.NumberCard;

public interface CardVisitor {
    void visit(NumberCard card);

    void visit(ActionCard card);
}
