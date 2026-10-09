package com.example.template;
//github test

public class player {

    private String name;
    private int score;
    private boolean banked500 = false;

    public player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isBanked500() {
        return banked500;
    }

    public void setBanked500(boolean banked500) {
        this.banked500 = banked500;
    }

    public int incscore(int point) {
        score += point;
        return score;
    }
}