package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;

public class ChanceCardGetOutOfJailFree extends ChanceCard{

    public ChanceCardGetOutOfJailFree(String description){
        super(description);
    }

    /**
     * Game should check for if Player has
     *  a GetOutOfJailCard.
     *
     *  To-do Player should have a list of
     *  owned ChanceCards.
    */
    public void use(Game game){
        game.getGuiWrapper().showMessage(description);
    }

}
