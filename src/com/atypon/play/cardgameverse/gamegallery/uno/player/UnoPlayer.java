package com.atypon.play.cardgameverse.gamegallery.uno.player;

import com.atypon.play.cardgameverse.coreengine.Player;

import static com.atypon.play.cardgameverse.gamegallery.uno.constants.Constants.WINNER_MESSAGE;

public class UnoPlayer extends Player {
    public UnoPlayer(String name) {
        super(name);
    }

    @Override
    public boolean hasWon()  {
        if (this.getHand().isEmpty()) {
            System.out.println(getName() + WINNER_MESSAGE);
            return true;
        }
        return false;
    }

}
