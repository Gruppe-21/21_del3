package com.gruppe21.gui;

import com.gruppe21.game.board.squares.*;
import com.gruppe21.player.Player;
import com.gruppe21.utils.arrayutils.OurArrayList;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUIWrapper {
    private GUI gui;
    private final OurArrayList<GUI_Field> fields;
    private final OurArrayList<GUI_Player> players;

    public GUIWrapper() {
        fields = new OurArrayList<GUI_Field>();
        players = new OurArrayList<GUI_Player>();
    }

    private void addSquares(OurArrayList<Square> squareList) {
        for (Square square : squareList.toArray(new Square[0])) {

        GUI_Field field = null;
           if(square.getClass() == PropertySquare.class){
               PropertySquare p = (PropertySquare)square;
               field = new GUI_Street();
               field.setSubText("" + p.getPrice());

               field.setBackGroundColor(p.getColor());
           }
           else if(square.getClass() == StartSquare.class){
               field = new GUI_Start();

            //   field.setBackGroundColor((Color.WHITE));
           }
           else if(square.getClass() == PrisonSquare.class){
               field = new GUI_Jail();
           }
           else if(square.getClass() == ChanceSquare.class){
               field = new GUI_Chance();
           }
           else{
               field = new GUI_Street();
           }


            field.setTitle(square.getName());
            field.setSubText("");
            field.setDescription(square.getDescriptionLabel());

            fields.add(field);

        }
    }

    // Has to be called every time new squares are added; Most likely only at the start of the game.
    public void reloadGUI(OurArrayList<Square> squareList) {
        if (gui != null)
            gui.close();

        addSquares(squareList);
        gui = new GUI(fields.toArray(new GUI_Field[0]), Color.WHITE);
    }

    // First add players after gui reload
    public void addPlayer(Player player, Color color) {

        // Don't add if player is null
        if (player == null)
            return;
        // Check if player is already added
        for (GUI_Player pl : players.toArray(new GUI_Player[0])) {
            if (pl.getName().equals(player.getName()))
                return;
        }

        GUI_Player guiPlayer = new GUI_Player(player.getName() + " " + player.getPieceAsString());
        guiPlayer.setBalance(player.getBankBalance().getBalance());
        guiPlayer.getCar().setPrimaryColor(color);
        player.setGuiPlayer(guiPlayer);
        gui.addPlayer(guiPlayer);
        players.add(guiPlayer);
    }

    public void movePlayer(Player player, int nextSquareIndex) {
        GUI_Player guiPlayer = player.getGuiPlayer();
        if (guiPlayer != null) {
            fields.get(player.getCurrentSquareIndex() ).setCar(guiPlayer, false);
            fields.get(nextSquareIndex).setCar(guiPlayer, true);
        }
    }

    public void close() {
        if (gui != null)
            gui.close();
    }

    public void setDice(int val1, int val2) {
        gui.setDice(val1, 4, 5, val2, 6, 5);
    }

    // Show message to player
    public void showMessage(String message) {
        gui.showMessage(message);
    }

    // Get a string input from player
    public String getStringInput(String message) {
        return gui.getUserString(message);
    }

    // Get a string input from player
    public String getButtonPress(String message, String... buttonText) {
        return gui.getUserButtonPressed(message, buttonText);
    }

    public void updatePlayerBalance(GUI_Player guiPlayer, int balance) {
        if (guiPlayer != null) {
            guiPlayer.setBalance(balance);
        }
    }

    public GUI_Player getPlayer(int playerIndex) {
        //Mabye should make sure that playerIndex isn't out of bounds
        return players.get(playerIndex);
    }

    public GUI_Player getPlayer(String name) {
        for (GUI_Player player : players.toArray(new GUI_Player[0])) {
            if (player.getName().equals(name))
                return player;
        }
        return null;
    }

    public Boolean hasPlayerWithName(String name) {
        for (GUI_Player player : players.toArray(new GUI_Player[0])) {
            if (player.getName().split(" ")[0].equals(name)) return true;
        }
        return false;
    }


}
