package com.example.template;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {

    public Label turnScoreLabel;
    public Label scoreLabel;
    public TextField nameTextField;

    public Label die1Label;
    public Label die2Label;
    public Label die3Label;
    public Label die4Label;
    public Label die5Label;
    public Label die6Label;

    public ToggleButton die1Toggle;
    public ToggleButton die2Toggle;
    public ToggleButton die3Toggle;
    public ToggleButton die4Toggle;
    public ToggleButton die5Toggle;
    public ToggleButton die6Toggle;

    public Button rollDiceButton;
    public Label playerlbl;

    private Manager Manager = new Manager();
    private int cscore = 0;
    int value = 0;

    ToggleButton[] toggles = new ToggleButton[6];
    Label[] labels = new Label[6];
    int[] dice = new int[6];
    boolean[] diceclick = new boolean[6];
    boolean rolldice = true;
    int temp1 = 0;

    ArrayList<Integer> names = new ArrayList<>();
    ArrayList<Integer> selectedDice = new ArrayList<>();

    public void initialize() {

        toggles[0] = die1Toggle;
        toggles[1] = die2Toggle;
        toggles[2] = die3Toggle;
        toggles[3] = die4Toggle;
        toggles[4] = die5Toggle;
        toggles[5] = die6Toggle;

        labels[0] = die1Label;
        labels[1] = die2Label;
        labels[2] = die3Label;
        labels[3] = die4Label;
        labels[4] = die5Label;
        labels[5] = die6Label;
    }

    public void rollDice() {
        temp1 = Integer.parseInt(turnScoreLabel.getText());
        if(rolldice){
            selectedDice.clear();

            for (int i = 0; i < 6; i++) {

                if (!diceclick[i]) {

                    int number = Randnum(1, 6);
                    dice[i] = number;
                    labels[i].setText(String.valueOf(number));
                    selectedDice.add(number);
                }
            }

            rolldice = false;
            value = score.bank(selectedDice);

            if (value == 0) {

                playerlbl.setText(Manager.changeplayer());

                for (int i = 0; i < 6; i++) {
                    dice[i] = 6;
                    toggles[i].setSelected(false);
                    diceclick[i] = false;
                }
                cscore = 0;

                turnScoreLabel.setText("0");

                rolldice = true;
            }

            selectedDice.clear();
        }
        selectedDice.clear();




    }
    @FXML
    private void selectDie() {
        int temp = Integer.parseInt(turnScoreLabel.getText());

        scoreLabel.setText(String.valueOf(Manager.getscores()));

        for (int i = 0; i < 6; i++) {

            if (toggles[i].isSelected() && !diceclick[i]) {
                System.out.println("dice array: " + java.util.Arrays.toString(dice));
                int value = dice[i];

                selectedDice.add(value);
                diceclick[i] = true;

                System.out.println("Selected dice: " + selectedDice);




                if (getDiceclick()) {
                    for (int j = 0; j < 6; j++) {
                        toggles[j].setSelected(false);
                        diceclick[j] = false;
                    }
                }
            }
        }
        int valueScore = score.bank(selectedDice);
        cscore += valueScore;
        cscore -= temp;
        cscore += temp1;
        rolldice =  true;
        turnScoreLabel.setText(String.valueOf(cscore));
    }

    public void bankPoints() {

        for ( int i =0; i<Manager.players.size(); i++){
            if(Manager.players.get(i).isBanked500() ||score.bank(selectedDice) >= 500 ){
                scoreLabel.setText(
                        String.valueOf(Manager.bank(selectedDice))
                );
                Manager.players.get(i).setBanked500(true);
            }
        }

        if(Manager.win()){
            String gerard = playerlbl.getText();
            playerlbl.setText( gerard +"has won");

        }else{
            playerlbl.setText(Manager.changeplayer());

            for (int i = 0; i < 6; i++) {
                toggles[i].setSelected(false);
                diceclick[i] = false;
            }

            selectedDice.clear();

            turnScoreLabel.setText("0");
            cscore = 0;


        }
        rolldice = true;





    }

    public void addPlayer(ActionEvent actionEvent) {

        Manager.addPerson(nameTextField.getText());
        playerlbl.setText(Manager.changeplayer());
        nameTextField.clear();
    }

    public boolean getDiceclick() {

        for (boolean i : diceclick) {

            if (!i) {
                return false;
            }
        }

        return true;
    }

    public int Randnum(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }




}