package com.gruppe21.game.board.squares;

import com.gruppe21.game.Game;
import com.gruppe21.game.board.Board;
import com.gruppe21.gui.GUIManager;
import com.gruppe21.player.Player;
import com.gruppe21.utils.localisation.Localisation;

/*
        Opretter en basic Square
 */

public abstract class Square {
    private String name;
    private String description;
    protected Board board;

    public Square(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void handleLandOn(Player player, Game game) {
        String text = Localisation.getInstance().getStringValue(description);
        GUIManager.getInstance().waitForUserAcknowledgement(text);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}




/*
        Creates a FreeParking square class:
 */


/*
        Creates a GoToPrisonSquare class:
 */


/*
        Creates a ChanceSquare class:
 */


/*
        Creates a PropertySquare class:
 */

