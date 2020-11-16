package com.gruppe21.game.board.chancecard;

import com.gruppe21.game.Game;
import com.gruppe21.game.board.squares.Square;
import com.gruppe21.player.Player;
import com.gruppe21.utils.localisation.Localisation;

public class ChanceCardMove extends ChanceCard {
    private int moveToSquare;
    private boolean isTakeCard;
    private boolean isFreeColorSquare;
    private boolean isMoveUpTo;
    private boolean isFigure;

    public ChanceCardMove(String description, int moveToSquare, boolean isTakeCard, boolean isFreeColorSquare, boolean isMoveUpTo, boolean isFigure) {
        super(description);
        this.moveToSquare = moveToSquare;
        this.isTakeCard = isTakeCard;
        this.isFreeColorSquare = isFreeColorSquare;
        this.isMoveUpTo = isMoveUpTo;
        this.isFigure = isFigure;
    }


    @Override
    public void use(Game game, int playerIndex, Player cardUser) {
        if(isFreeColorSquare){
            freeColorSquare(game,playerIndex,cardUser);
        } else if(isTakeCard) {
            takeCard(game,playerIndex);
        } else if(isMoveUpTo) {
            moveUpTo(game,playerIndex);
        } else if(isFigure) {
            giveCardToFigure(game,playerIndex);
        }else{
            move(game,playerIndex);
        }
    }
    

    private void freeColorSquare(Game game,int playerIndex,Player cardUser){

    }
   
    private void takeCard(Game game,int playerIndex) {
        // int playerIndex = game.getCurrentPlayer();
        int playerCurrentSquareIndex = game.getPlayers()[playerIndex].getCurrentSquareIndex();
        int moveToSquare;
        String moveButton = Localisation.getInstance().getStringValue("moveButton");
        String takeButton = Localisation.getInstance().getStringValue("takeButton");

        String result = game.getGuiWrapper().getButtonPress(description, moveButton, takeButton);

        if (result.equals(moveButton)) {
            moveToSquare = playerCurrentSquareIndex + 1;
            if(moveToSquare > 24) moveToSquare = moveToSquare%24; //-1;

            Square square = game.getBoard().getSquareAtNumber(moveToSquare);
            game.movePlayer(playerIndex,square);
        } else {
            // Deck.draw();
        }
    }

    private void moveUpTo(Game game,int playerIndex){
        String moveButton1 = Localisation.getInstance().getStringValue("moveButton1");
        String moveButton2 = Localisation.getInstance().getStringValue("moveButton2");
        String moveButton3 = Localisation.getInstance().getStringValue("moveButton3");
        String moveButton4 = Localisation.getInstance().getStringValue("moveButton4");
        String moveButton5 = Localisation.getInstance().getStringValue("moveButton5");
        int playerCurrentSquareIndex = game.getPlayers()[playerIndex].getCurrentSquareIndex();
        int moveToSquare;
        int moveForwardChosen = 0;

        String moveUpToResult = game.getGuiWrapper().getButtonPress(description,moveButton1,moveButton2,moveButton3,moveButton4,moveButton5);

        switch (moveUpToResult){
            case "moveButton1" -> moveForwardChosen=1;
            case "moveButton2" -> moveForwardChosen=2;
            case "moveButton3" -> moveForwardChosen=3;
            case "moveButton4" -> moveForwardChosen=4;
            case "moveButton5" -> moveForwardChosen=5;
            default ->
                    moveUpTo(game,playerIndex);  // recursion. If no button chosen -> call moveUpTo() again;
        }
        moveToSquare = playerCurrentSquareIndex + moveForwardChosen;
        if(moveToSquare > 24) moveToSquare = moveToSquare%24; //-1;

        Square square = game.getBoard().getSquareAtNumber(moveToSquare);
        game.movePlayer(playerIndex,square);
    }

    private void giveCardToFigure(Game game,int playerIndex, Player player){
        // Find out how to check figure
    }

    /**Game keeps track of when
     * startsquare has been passed*/
    private void move(Game game,int playerIndex) {
        //int playerIndex = game.getCurrentPlayer();
        game.getGuiWrapper().showMessage(description);
        Square square = game.getBoard().getSquareAtNumber(moveToSquare);
        game.movePlayer(playerIndex, square);
    }

}
