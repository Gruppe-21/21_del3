package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;
import com.gruppe21.game.board.squares.Square;
import com.gruppe21.player.BankBalance;
import com.gruppe21.player.Player;

/** if it's implementet that Game keeps track of when
 * startsquare has been passed, this method can be
 * moved to ChanceCardMove and class ChanceCardStart
 * can be removed.
 */
public class ChanceCardStart extends ChanceCard {
    int money;

    public ChanceCardStart(String description,int money) {
        super(description);
        this.money = money;
    }

    @Override
    public void use(Game game,Player player){
        startCard(game,player);
    }

    //Current player moves to StartSquare and receives money
        private void startCard(Game game, Player player) {
            int playerIndex = game.getCurrentPlayer();
            int startSquareIndex = 1; // TO-DO: game.getBoard().getSquareAtNumber(start)
            int modifyBalance = money; // +2M

            game.getGuiWrapper().showMessage(description);
            Square square = game.getBoard().getSquareAtNumber(startSquareIndex);
            game.movePlayer(playerIndex, square);

            BankBalance playerCurrentBalance = player.getBankBalance();

            playerCurrentBalance.addBalance(modifyBalance);
        }

}
