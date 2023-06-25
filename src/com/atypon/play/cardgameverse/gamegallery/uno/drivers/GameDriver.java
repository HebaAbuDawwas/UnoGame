package com.atypon.play.cardgameverse.gamegallery.uno.drivers;

import com.atypon.play.cardgameverse.coreengine.Player;
import com.atypon.play.cardgameverse.gamegallery.uno.game.UnoGame;
import com.atypon.play.cardgameverse.gamegallery.uno.player.UnoPlayer;

import java.util.ArrayList;
import java.util.List;

public class GameDriver {
    public static void main(String[] args) {
        Player player1 = new UnoPlayer("heba");
        Player player2 = new UnoPlayer("mohammed");
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        UnoGame game = UnoGame.createNewUnoGame(playerList);
        game.play();

    }
}
