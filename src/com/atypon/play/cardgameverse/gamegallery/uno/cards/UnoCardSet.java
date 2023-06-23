package com.atypon.play.cardgameverse.gamegallery.uno.cards;

import com.atypon.play.cardgameverse.coreengine.CardSet;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.ActionCardType;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardColor;
import com.atypon.play.cardgameverse.gamegallery.uno.cards.enums.CardNumber;

import java.util.Collections;

public class UnoCardSet extends CardSet {
    public UnoCardSet() {
        super();
    }


    @Override
    protected void initializeCardSet() {
        addNumberCards();
        addActionCards();
        addWildCards();
        Collections.shuffle(cardSet);
    }

    private void addNumberCards() {
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.WILD) {
                for (CardNumber number : CardNumber.values()) {
                    cardSet.add(new NumberCard(number, color));
                    if (number != CardNumber.ZERO) cardSet.add(new NumberCard(number, color));

                }
            }
        }
    }

    private void addActionCards() {
        for (int i = 0; i < 2; i++) {
            for (CardColor color : CardColor.values()) {
                if (color != CardColor.WILD) {
                    cardSet.add(new ActionCard(ActionCardType.SKIP, color));
                    cardSet.add(new ActionCard(ActionCardType.REVERSE, color));
                    cardSet.add(new ActionCard(ActionCardType.DRAW_TWO, color));
                }
            }
        }
    }

    private void addWildCards() {
        for (int i = 0; i < 4; i++) {
            cardSet.add(new ActionCard(ActionCardType.WILD_CHANGE_COLOR, CardColor.WILD));
            cardSet.add(new ActionCard(ActionCardType.WILD_DRAW_FOUR, CardColor.WILD));
        }
    }

}