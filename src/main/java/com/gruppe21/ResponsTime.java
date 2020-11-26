package com.gruppe21;

public class ResponsTime {
    //Max responstime for Die method:
    public static long MAX_roll = 0L;

    //Max responstime for Deck methods:
    public static long MAX_shuffle = 0L;
    public static long MAX_draw = 0L;
    public static long MAX_return = 0L;

    //Max responstime for BankBalance method:
    public static long MAX_transfer = 0L;

    //Max responstime for PropertySquare method:
    public static long MAX_owner = 0L;

    //Max responstime for Game method:
    public static long MAX_teleport = 0L;



    public static long getMAX_teleport() {
        return MAX_teleport;
    }

    public static void setMAX_teleport(long MAX_teleport) {
        ResponsTime.MAX_teleport = MAX_teleport;
    }

    public static long getMAX_roll() {
        return MAX_roll;
    }

    public static void setMAX_roll(long MAX_roll) {
        ResponsTime.MAX_roll = MAX_roll;
    }

    public static long getMAX_shuffle() {
        return MAX_shuffle;
    }

    public static void setMAX_shuffle(long MAX_shuffle) {
        ResponsTime.MAX_shuffle = MAX_shuffle;
    }

    public static long getMAX_draw() {
        return MAX_draw;
    }

    public static void setMAX_draw(long MAX_draw) {
        ResponsTime.MAX_draw = MAX_draw;
    }

    public static long getMAX_return() {
        return MAX_return;
    }

    public static void setMAX_return(long MAX_return) {
        ResponsTime.MAX_return = MAX_return;
    }

    public static long getMAX_transfer() {
        return MAX_transfer;
    }

    public static void setMAX_transfer(long MAX_transfer) {
        ResponsTime.MAX_transfer = MAX_transfer;
    }

    public static long getMAX_owner() {
        return MAX_owner;
    }

    public static void setMAX_owner(long MAX_owner) {
        ResponsTime.MAX_owner = MAX_owner;
    }

    public static String getAllMaxValueToString() {
        Long[] Max = new Long[7];

        Max[0] = getMAX_owner();
        Max[1] = getMAX_teleport();
        Max[2] = getMAX_transfer();
        Max[3] = getMAX_roll();
        Max[4] = getMAX_shuffle();
        Max[5] = getMAX_return();
        Max[6] = getMAX_draw();

        return "----------------------------- \n"+"Max respons time for setOwner: "+Max[0]+"ms \n"+"Max respons time for teleportPlayer: "+Max[1]+"ms \n"+"Max respons time for transferMoney: "+Max[2]+"ms \n"+"Max respons time for rollDie: "+Max[3]+"ms \n"+"Max respons time for shuffleDeck: "+Max[4]+"ms \n"+"Max respons time for returnCard: "+Max[5]+"ms \n"+"Max respons time for drawCard: "+Max[6]+"ms\n-----------------------------";
    }
}
