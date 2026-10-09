package com.example.template;

import java.util.ArrayList;
import java.util.Collections;

public class score {

    static int pairs = 0;
    static int triples = 0;
    static int fours = 0;

    public static int bank(ArrayList<Integer> dice) {
          pairs = 0;
          triples = 0;
          fours = 0;
        int score = 0;

        if (dice.size() == 6) {

            boolean straight = true;

            for (int i = 1; i <= 6; i++) {

                if (Collections.frequency(dice, i) != 1) {
                    straight = false;
                }
            }

            if (straight) {
                return 1500;
            }


            for (int i = 1; i <= 6; i++) {

                int amount = Collections.frequency(dice, i);

                if (amount == 2) {
                    pairs++;
                }

                if (amount == 3) {
                    triples++;
                }
                if (amount == 4){
                    fours++;
                }
            }

            if (pairs == 3) {
               return  1500;
            }

            if (triples == 2) {
                return  2500;
            }
            if(fours == 1 && pairs == 1){
                return 1500;
            }

        }

        for (int i = 1; i <= 6; i++) {

            int amount = Collections.frequency(dice, i);

            if (amount == 6) {
                return  3000;
            }

            if (amount == 5) {

                score += 2000;


            }



        }

        for (int i = 1; i <= 6; i++) {

            int amount = Collections.frequency(dice, i);

            if (amount == 3) {

                if (i == 1) {
                    score += 300;
                } else {
                    score += i * 100;
                }

                for (int j = 0; j < dice.size(); j++) {

                    if (dice.get(j) == 1 && i != 1) {
                        score += 100;
                    }

                    if (dice.get(j) == 5 && i != 5) {
                        score += 50;
                    }
                }

            }
        }
        if (fours == 1 && pairs == 0) {
            score += 1000;
            for (int j = 0; j < dice.size(); j++) {

                if (dice.get(j) == 1 && Collections.frequency(dice, 1)<2) {
                    score += 100;
                }

                if (dice.get(j) == 5&& Collections.frequency(dice, 5)<2 ) {
                    score += 50;
                }
            }
        }





        return score;
    }

}