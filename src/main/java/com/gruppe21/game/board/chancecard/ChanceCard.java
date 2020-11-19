package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;
import com.gruppe21.player.Player;

public abstract class ChanceCard {
    protected String descriptionLabel;

    public ChanceCard(String descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public void use() {

    }

    public void use(Game game, Player player) {
        // Do something
    }

    public void onDraw(Game game, Player player) {
        use(game, player);
    }
}
