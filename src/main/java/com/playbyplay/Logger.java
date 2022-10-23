package com.playbyplay;

public class Logger {
    public static void logError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void logPlayersAdded(int numOfPlayers) {
        System.out.printf("%s player(s) were added\n", numOfPlayers);
    }

    public static void logGameYearAdded(String url) {
        System.out.println(url);
    }
}
