package com.atypon.play.cardgameverse.coreengine.observerpattern;

import com.atypon.play.cardgameverse.coreengine.GameStatus;

public interface Observer {
    void update(GameStatus gameStatus);
}