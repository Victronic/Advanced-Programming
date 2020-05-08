package com.victor.laborator11.controller;

public class Game {
    private int player1ID;
    private int player2ID;
    private String content;
    private String date;
    private String score;

    public Game(int player1ID, int player2ID, String content, String date, String score) {
        this.player1ID = player1ID;
        this.player2ID = player2ID;
        this.content = content;
        this.date = date;
        this.score = score;
    }
}
