package com.example.template;

import java.util.ArrayList;

public class Manager {

    public ArrayList<player> players = new ArrayList<>();
    private int currentPlayer = 0;

    public void addPerson(String name) {
        players.add(new player(name));
    }

    public String getnames() {

        String chosen = players.get(currentPlayer).getName();

        return chosen;
    }
    public int getscores(){
        int chosen = players.get(currentPlayer).getScore();

        return chosen;
    }

    public int bank(ArrayList<Integer> dice) {

        players.get(currentPlayer).incscore(score.bank(dice));

        return players.get(currentPlayer).getScore();
    }

    public String changeplayer() {

        currentPlayer++;

        if (currentPlayer >= players.size()) {
            currentPlayer = 0;
        }

        String chosen = players.get(currentPlayer).getName();

        return chosen;
    }

    public boolean win(){
        boolean iswon = false;
        for (player player : players) {
            if(player.getScore() >= 10000){
                iswon = true;
            }
        }
        return iswon;
    }



}