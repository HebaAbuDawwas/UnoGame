package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.ActionCardType;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardNumber;

import java.util.List;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.*;

public class UnoCardsFactory {
    private final List<Card> cardSet;

    public UnoCardsFactory(List<Card> cardSet) {
        this.cardSet = cardSet;
    }

    public void addCards(String type) {
        if (type.equalsIgnoreCase(NUMBER)) {
            for (CardColor color : CardColor.values()) {
                if (color != CardColor.WILD) {
                    for (CardNumber number : CardNumber.values()) {
                        cardSet.add(new NumberCard(number, color));
                        if (number != CardNumber.ZERO) cardSet.add(new NumberCard(number, color));

                    }
                }
            }
        } else if (type.equalsIgnoreCase(ACTION)) {
            for (int i = 0; i < 2; i++) {
                for (CardColor color : CardColor.values()) {
                    if (color != CardColor.WILD) {
                        cardSet.add(new ActionCard(ActionCardType.SKIP, color));
                        cardSet.add(new ActionCard(ActionCardType.REVERSE, color));
                        cardSet.add(new ActionCard(ActionCardType.DRAW_TWO, color));
                    }
                }
            }

        } else if (type.equalsIgnoreCase(WILD)) {
            for (int i = 0; i < 4; i++) {
                cardSet.add(new ActionCard(ActionCardType.WILD_CHANGE_COLOR, CardColor.WILD));
                cardSet.add(new ActionCard(ActionCardType.WILD_DRAW_FOUR, CardColor.WILD));
            }

        } else {
            throw new IllegalArgumentException(INVALID_CARD_TYPE_TO_CREATE);
        }
    }
}
