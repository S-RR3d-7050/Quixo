package com.example.projet.Model;

import java.util.ArrayList;

public class Plateau {

    public Plateau() {

    }

    public  int [][] game =
            {
                    { 0, 0, 0, 0,0},
                    { 0, 0, 0, 0,0},
                    { 0, 0, 0, 0,0},
                    { 0, 0, 0, 0,0},
                    { 0, 0, 0, 0,0},
            };



    public Plateau(int[][] game) {
        this.game = game;
    }

    public static boolean AuDebut(int i) {
        if(i==0){return true;}
        return false;}
    public static boolean AlaFin(int i) {
        if(i==4)
        {return true;}
        return false;
    }


    public void setGame(int[][] game) {
        this.game = game;
   }

    public int[][] getGame() {

        return game;
    }

    //Cela me permet de voir les pieces ou cotés qui sont succeptible d'etre déplacer
    public ArrayList<Position> DestCaseJouable(int BoardSize, Position point){

        ArrayList<Position> DestCaseJouable = new ArrayList<Position>();
        //Si les points sont sur la premiere ligne ou dernière ligne
        if((AlaFin(point.getX()))||(AuDebut(point.getX()))){
            if((AuDebut(point.getY()))||AlaFin(point.getY())) {

                DestCaseJouable.add(new Position(point.getX(), 4 - point.getY()));
                DestCaseJouable.add(new Position(4 - point.getX(),point.getY()));
            } else {
                //Les trois cases au milieu de la premiere ligne ou dernière ligne
                DestCaseJouable.add(new Position(4-point.getX(),point.getY()));
                DestCaseJouable.add(new Position(point.getX(), 0));
                DestCaseJouable.add(new Position(point.getX(), 4));
            }
        } else {
            //Les trois cases au milieu de la premiere colonne ou dernière colonne
            DestCaseJouable.add(new Position(4, point.getY()));
            DestCaseJouable.add(new Position(0, point.getY()));
            DestCaseJouable.add(new Position(point.getX(),4-point.getY()));
        }

        return DestCaseJouable;




    }

    // l'état du jeux
    public   void afficheBoard(){
        System.out.println();
        for (int i =0;i<5;i++){
            for(int j =0;j<5;j++){
                String val="?";
                if(game[i][j]==1){
                    val="O";
                }else if(game[i][j]==2){
                    val="X";
                }

            }

        }

    }

    // recherche des cubes que le joueur peut déplacer
    public  ArrayList<Position> SourceCaseJouable(int pi){
        ArrayList<Position> CasesSources = new ArrayList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                //vérifier que le cube et dans les cotés déja 16 cases
                if((i==0)||(i==4)||(j==0)||(j==4)){
                    //puis si c'est vide personne ne l'a encore jouer ou c'est la sienne
                    if((game[i][j]==0)||(game[i][j]==pi)){
                        CasesSources.add(new Position(i,j));
                    }
                }
            }
        }

        return CasesSources;
    }


    public int Solved() {
        //Vérifier ligne
        for (int row = 0; row < 5; row++) {


            if (game[row][0] == game[row][1] && game[row][1] == game[row][2] && game[row][2] == game[row][3] && game[row][3] == game[row][4]) {

                if (game[row][0] == 1) {

                    return -10;
                } else if (game[row][0] == 2) {

                    return 10;
                }

            }

        }


        //verifier colonne
        for (int column = 0; column < 5; column++) {

            if (game[0][column] == game[1][column] && game[1][column] == game[2][column] && game[2][column] == game[3][column] && game[3][column] == game[4][column]) {

                if (game[0][column] == 1) {
                    //this.winnerPlayer = 'H';
                    return -10;
                } else if (game[0][column] == 2) {
                    //this.winnerPlayer = 'I';
                    return 10;
                }

            }

        }


        //verifier diagonal top left to bottom right
        if (game[0][0] != 0) {
            if (game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[2][2] == game[3][3] && game[3][3] == game[4][4]) {

                if (game[0][0] == 1) {
                    return -10;
                } else {
                    if (game[0][0] == 2) {
                        return 10;
                    }
                }


            }
        }
        //verifier diagonal top right to bottom left
        if (game[0][4] != 0) {
            if (game[0][4] == game[1][3] && game[1][3] == game[2][2] && game[2][2] == game[3][1] && game[3][1] == game[4][0]) {

                if (game[4][0] == 1) {
                    return -10;
                } else {
                    if (game[4][0] == 2) {
                        return 10;
                    }
                }


            }
        }
        return 0;
    }

}
