package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;
import com.gruppe21.player.BankBalance;
import com.gruppe21.player.Player;

import java.util.ArrayList;

public class ChanceCardMoney extends ChanceCard {
    private int money;
    public ChanceCardMoney(String description, int money) {
        super(description);
        this.money = money;
    }

    @Override
    public void use(Game game, Player[] players, Player cardUser) {

        game.getGuiWrapper().showMessage(description);
        if (players == null){
            cardUser.getBankBalance().addBalance(money);
        }
        else {
            ArrayList<Player> notEnoughMoney = new ArrayList<>(4);
            for (Player player : players) {
                if (player == cardUser) continue;
                if (player.getBankBalance().getBalance() < 0){
                    notEnoughMoney.add(player);
                }
                else cardUser.getBankBalance().addBalance(player.getBankBalance().getBalance() - player.getBankBalance().addBalance(money));
            }

            //Todo: Should evaluate each person and only then end the game if anyone have gone bankrupt.
            for (Player player: notEnoughMoney) {
                cardUser.getBankBalance().addBalance(player.getBankBalance().getBalance() - player.getBankBalance().addBalance(money));
            }
        }
    }

}
