package com.example.projet.Controller;

import com.example.projet.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.ArrayList;

import java.util.Arrays;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
public class ControlleurHumain {

    @FXML
    private GridPane GD;

    @FXML
    private Button bt00;

    @FXML
    private Button bt01;

    @FXML
    private Button bt02;

    @FXML
    private Button bt03;

    @FXML
    private Button bt04;

    @FXML
    private Button bt10;

    @FXML
    private Button bt11;

    @FXML
    private Button bt12;

    @FXML
    private Button bt13;

    @FXML
    private Button bt14;

    @FXML
    private Button bt20;

    @FXML
    private Button bt21;

    @FXML
    private Button bt22;

    @FXML
    private Button bt23;

    @FXML
    private Button bt24;

    @FXML
    private Button bt30;

    @FXML
    private Button bt31;

    @FXML
    private Button bt32;

    @FXML
    private Button bt33;

    @FXML
    private Button bt34;

    @FXML
    private Button bt40;

    @FXML
    private Button bt41;

    @FXML
    private Button bt42;

    @FXML
    private Button bt43;

    @FXML
    private Button bt44;

    @FXML
    private Label idAfficherWinner;

    @FXML
    private Label idCurrentPlayer;


    PlayerHumain humainPlayr = new PlayerHumain();
    Plateau p = new Plateau();
    public int playerTurn = 1;

    public static int secondPlayerTurn = 2;
    public boolean optionSelectionner = true;
    ArrayList<Position> myArrayDest1 = new ArrayList<>();
    ArrayList<Position> myArraySource1 = p.SourceCaseJouable(playerTurn);

    Position selectionneDestination;
    Position selectionneSource;
    ArrayList<Button> allButtons;
    ArrayList<Button> lateralButtons;

    @FXML
    void RestartGame(ActionEvent event) {
        //Restart
        allButtons = new ArrayList<>(Arrays.asList(bt44,bt43,bt42,bt41,bt40,bt34,bt33,bt32,bt31,bt30,bt24,bt23,bt22,bt21,bt20,bt10,bt11,bt12,bt13,bt14,bt04,bt03,bt02,bt01,bt00));
        lateralButtons = new ArrayList<>(Arrays.asList(bt44,bt43,bt42,bt41,bt40,bt34,bt30,bt24,bt20,bt10,bt14,bt04,bt03,bt02,bt01,bt00));
        p = new Plateau();

        allButtons.forEach(button ->{
            button.setText("");
        });
        playerTurn = 1;
        lateralButtons.forEach(button ->{ if(button.isDisabled()){
            button.setDisable(false);} });
        idAfficherWinner.setText("");
        idCurrentPlayer.setText("C'est le tour du premier Humain");
        optionSelectionner= true;
        myArrayDest1 = new ArrayList<Position>();
        myArraySource1= p.SourceCaseJouable(playerTurn);
        UpdateAffichage();
    }

    public void UpdateAffichage(){
        if (p.game[0][0]== 2){bt00.setText("X");}else if (p.game[0][0]== 1){bt00.setText("O"); } else {bt00.setText(""); }
        if (p.game[0][1]== 2){bt10.setText("X");}else if (p.game[0][1]== 1) {bt10.setText("O");} else {bt10.setText("");}
        if (p.game[0][2]== 2){bt20.setText("X");}else if (p.game[0][2]== 1) bt20.setText("O"); else {bt20.setText("");}
        if (p.game[0][3]== 2){bt30.setText("X");}else if (p.game[0][3]== 1) bt30.setText("O"); else {bt30.setText("");}
        if (p.game[0][4]== 2){bt40.setText("X");}else if (p.game[0][4]== 1) bt40.setText("O"); else {bt40.setText("");}
        if (p.game[1][0]== 2){bt01.setText("X");}else if (p.game[1][0]== 1) bt01.setText("O");else {bt01.setText("");}
        if (p.game[1][1]== 2){bt11.setText("X");}else if (p.game[1][1]== 1) bt11.setText("O");else {bt11.setText("");}
        if (p.game[1][2]== 2){bt21.setText("X");}else if (p.game[1][2]== 1) bt21.setText("O");else {bt21.setText("");}
        if (p.game[1][3]== 2){bt31.setText("X");}else if (p.game[1][3]== 1) bt31.setText("O");else {bt31.setText("");}
        if (p.game[1][4]== 2){bt41.setText("X");}else if (p.game[1][4]== 1) bt41.setText("O");else {bt41.setText("");}
        if (p.game[2][0]== 2){bt02.setText("X");}else if (p.game[2][0]== 1) bt02.setText("O");else {bt02.setText("");}
        if (p.game[2][1]== 2){bt12.setText("X");}else if (p.game[2][1]== 1) bt12.setText("O");else {bt12.setText("");}
        if (p.game[2][2]== 2){bt22.setText("X");}else if (p.game[2][2]== 1) bt22.setText("O");else {bt22.setText("");}
        if (p.game[2][3]== 2){bt32.setText("X");}else if (p.game[2][3]== 1) bt32.setText("O");else {bt32.setText("");}
        if (p.game[2][4]== 2){bt42.setText("X");}else if (p.game[2][4]== 1) bt42.setText("O");else {bt42.setText("");}
        if (p.game[3][0]== 2){bt03.setText("X");}else if (p.game[3][0]== 1) bt03.setText("O");else {bt03.setText("");}
        if (p.game[3][1]== 2){bt13.setText("X");}else if (p.game[3][1]== 1) bt13.setText("O");else {bt13.setText("");}
        if (p.game[3][2]== 2){bt23.setText("X");}else if (p.game[3][2]== 1) bt23.setText("O");else {bt23.setText("");}
        if (p.game[3][3]== 2){bt33.setText("X");}else if (p.game[3][3]== 1) bt33.setText("O");else {bt33.setText("");}
        if (p.game[3][4]== 2){bt43.setText("X");}else if (p.game[3][4]== 1) bt43.setText("O");else {bt43.setText("");}
        if (p.game[4][0]== 2){bt04.setText("X");}else if (p.game[4][0]== 1) bt04.setText("O");else {bt04.setText("");}
        if (p.game[4][1]== 2){bt14.setText("X");}else if (p.game[4][1]== 1) bt14.setText("O");else {bt14.setText("");}
        if (p.game[4][2]== 2){bt24.setText("X");}else if (p.game[4][2]== 1) bt24.setText("O");else {bt24.setText("");}
        if (p.game[4][3]== 2){bt34.setText("X");}else if (p.game[4][3]== 1) bt34.setText("O");else {bt34.setText("");}
        if (p.game[4][4]== 2){bt44.setText("X");}else if (p.game[4][4]== 1) bt44.setText("O");else {bt44.setText("");}

    }

    public void selectionner(Integer rowIndex, Integer colIndex) {
        selectionneSource = new Position(colIndex, rowIndex);

        if (myArraySource1.stream().anyMatch(position -> position.x == selectionneSource.x && position.y == selectionneSource.y)) {
            myArrayDest1 = p.DestCaseJouable(5, selectionneSource);
            disableAllNode();
            EnableButtons(myArrayDest1);
            myArraySource1.clear();
            optionSelectionner = false;
            UpdateAffichage();
            p.afficheBoard();
        }
    }

    public void deplacer(Integer rowIndex, Integer colIndex) {
        selectionneDestination = new Position(colIndex, rowIndex);

        if (myArrayDest1.stream().anyMatch(position -> position.x == selectionneDestination.x && position.y == selectionneDestination.y)) {
            humainPlayr.movement(selectionneSource, selectionneDestination, playerTurn, p.game);
            UpdateAffichage();

            // Check for a winner or switch to the next player's turn
            if (p.Solved() == -10) {
                // Humain a gagné
                idAfficherWinner.setText("Joueur " + playerTurn + " a gagné ! Félicitations");
                System.out.println("Joueur " + playerTurn + " a gagné ! Félicitations");
                disableAllNode();
            } else if (p.Solved() == 10) {
                // Humain 2 a gagné
                idAfficherWinner.setText("Joueur " + playerTurn + " a gagné ! Félicitations");
                System.out.println("Joueur " + playerTurn + " a gagné ! Félicitations");
                disableAllNode();
            } else {
                // Switch to the next player's turn
                playerTurn = (playerTurn == 1) ? 2 : 1;
                myArrayDest1.clear();
                myArraySource1 = p.SourceCaseJouable(playerTurn);
                disableAllNode();
                EnableButtons(myArraySource1);
                optionSelectionner = true;
                UpdateAffichage();
                p.afficheBoard();
            }
        }
    }

    @FXML
    void jouer(ActionEvent e) throws InterruptedException {
        Node source = (Node) e.getSource();
        Integer rowIndex = GD.getRowIndex(source) == null ? 0 : GD.getRowIndex(source);
        Integer colIndex = GD.getColumnIndex(source) == null ? 0 : GD.getColumnIndex(source);

        if (playerTurn > 0) {
            idCurrentPlayer.setText("Tour du premier Joueur");
            if (optionSelectionner) {
                selectionner(colIndex, rowIndex);
            } else {
                deplacer(colIndex, rowIndex);
                Thread.sleep(1000);
            }
            playerTurn *= -1;
        } else {
            idCurrentPlayer.setText("Tour du deuxième Joueur");
            if (optionSelectionner) {
                selectionner(colIndex, rowIndex);
            } else {
                deplacer(colIndex, rowIndex);
                Thread.sleep(1000);
            }
            playerTurn *= -1;
        }
    }


    public void disableAllNode (){
        ObservableList<Node> allButtons = GD.getChildren();

        for (Node node : allButtons) {
            node.setDisable(true);
        }

    }

    public void EnableButtons(ArrayList<Position> ButtonsPosition){
        ObservableList<Node> allButtons = GD.getChildren();

        for (Node node : allButtons) {
            for (Position po : ButtonsPosition) {
                Integer rowIndex = GD.getRowIndex(node)==null? 0: GD.getRowIndex(node);
                Integer colIndex = GD.getColumnIndex(node)==null?0: GD.getColumnIndex(node);
                if (rowIndex== po.getX() && colIndex== po.getY())
                    node.setDisable(false);
            }
        }

    }

    @FXML
    void initialize() {
        disableAllNode();
        EnableButtons(myArraySource1);
    }
}
