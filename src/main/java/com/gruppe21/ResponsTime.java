package com.gruppe21;

public class ResponsTime {
    //Max responstime for Die method:
    public static long MAX_roll;

    //Max responstime for Deck methods:
    public static long MAX_shuffle;
    public static long MAX_draw;
    public static long MAX_return;

    //Max responstime for BankBalance method:
    public static long MAX_transfer;

    //Max responstime for PropertySquare method:
    public static long MAX_owner;

    //Max responstime for Game method:
    public static long MAX_teleport;



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
}
