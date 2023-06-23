package com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.ActionCard;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.NumberCard;
import com.atypon.play.cardgameverse.gamegallery.uno.game.UnoGameStatus;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.FOUR;
import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.TWO;
import static com.atypon.play.cardgameverse.gamegallery.uno.utils.CardsUtils.readNewWildCardColor;

public class CardPlayVisitor implements CardVisitor {
    UnoGameStatus gameStatus;

    public CardPlayVisitor(UnoGameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void visit(NumberCard card) {
    }

    @Override
    public void visit(ActionCard card) {
        switch (card.getActionType()) {
            case REVERSE:
                gameStatus.reversePlayDirection();
                break;
            case DRAW_TWO:
                gameStatus.increaseCardsToDrawNumber(TWO);
                break;
            case WILD_DRAW_FOUR:
                gameStatus.increaseCardsToDrawNumber(FOUR);
                card.setColor(readNewWildCardColor());
                break;
            case SKIP:
                gameStatus.skipPlayer();
                break;
            case WILD_CHANGE_COLOR:
                card.setColor(readNewWildCardColor());
                break;
        }
    }


}
