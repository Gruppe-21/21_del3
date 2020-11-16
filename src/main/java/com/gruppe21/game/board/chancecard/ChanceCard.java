package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;
import com.gruppe21.player.Player;

public abstract class ChanceCard {
    protected String description;

    public ChanceCard(String description) {
        this.description = description;
    }

    // Used in ChanceCardMove
    public void use(Game game,int playerIndex,Player cardUser) {
        // Do something
    }

    // Used in ChanceCardMoney
    public void use(Game game, Player[] players, Player cardUser){
        // Do something
    }
}
