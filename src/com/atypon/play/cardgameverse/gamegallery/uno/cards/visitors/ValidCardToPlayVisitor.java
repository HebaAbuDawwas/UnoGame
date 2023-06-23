package com.atypon.play.cardgameverse.gamegallery.uno.cards.visitors;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.ActionCard;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.NumberCard;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.ActionCardType;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.game.UnoGameStatus;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.INVALID_TO_CARD_TO_PLAY;
import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.ZERO;

public class ValidCardToPlayVisitor implements CardVisitor {
    UnoGameStatus gameStatus;

    public ValidCardToPlayVisitor(UnoGameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void visit(NumberCard card) {
        boolean isValidMove = gameStatus.getCurrentCard() instanceof NumberCard && card.getNumber() == ((NumberCard) gameStatus.getCurrentCard()).getNumber();
        if (card.getColor() == gameStatus.getCurrentCard().getColor() && gameStatus.getCardsToDrawNumber() == ZERO)
            isValidMove = true;

        if (!isValidMove)
            throw new IllegalArgumentException(INVALID_TO_CARD_TO_PLAY);
    }

    @Override
    public void visit(ActionCard card) {
        boolean isValidMove = false;
        if (gameStatus.getCurrentCard() instanceof NumberCard)
            isValidMove = gameStatus.getCurrentCard().getColor() == card.getColor() || card.getColor() == CardColor.WILD;
        else {
            switch (card.getActionType()) {
                case SKIP:
                    isValidMove = (gameStatus.getCardsToDrawNumber() == ZERO && card.getColor() == gameStatus.getCurrentCard().getColor()) ||
                            ((ActionCard) gameStatus.getCurrentCard()).getActionType() == ActionCardType.SKIP;
                    break;
                case REVERSE:
                    isValidMove = (gameStatus.getCardsToDrawNumber() == ZERO && card.getColor() == gameStatus.getCurrentCard().getColor()) ||
                            ((ActionCard) gameStatus.getCurrentCard()).getActionType() == ActionCardType.REVERSE;
                    break;
                case WILD_CHANGE_COLOR:
                    isValidMove = gameStatus.getCardsToDrawNumber() == ZERO;
                    break;

                case DRAW_TWO:
                    isValidMove = ((ActionCard) gameStatus.getCurrentCard()).getActionType() != ActionCardType.WILD_DRAW_FOUR &&
                            (card.getColor() == gameStatus.getCurrentCard().getColor() || card.getActionType() == ActionCardType.DRAW_TWO);
                    break;

                case WILD_DRAW_FOUR:
                    isValidMove = true;
                    break;
            }
        }
        if (!isValidMove)
            throw new IllegalArgumentException(INVALID_TO_CARD_TO_PLAY);

    }

}
