package com.example.projet.Model;

import java.util.ArrayList;

public class PlayerIA implements Player {

    Integer playerTurn = 2 ;
    public PlayerIA(Integer playerTurn) {
        this.playerTurn = playerTurn;
    }

    //Cette fonction retourne quel est le meilleur mouvement à effectuer
    public ArrayList<Position> GetMinMaxMove(int[][] game){

        Plateau plateau = new Plateau();
        int[][] gameTemp = cloneGame(game);
        ArrayList<Position> meilleurChoix = new ArrayList<>(2);
        int meilleurScore = Integer.MIN_VALUE;
        // créer une copie de tableau (java utilise les références dans les tableaux, arraylist ...
        plateau.setGame(cloneGame(game));
        ArrayList<Position> movables = plateau.SourceCaseJouable(playerTurn);
        for (Integer i = 0; i < movables.size(); i++) {
            // réinitialiser le plateau pour chaque case jouable et éviter les erreurs
            plateau.setGame(cloneGame(game));
            ArrayList<Position> destinations = plateau.DestCaseJouable(5,movables.get(i));
            for (int j = 0; j < destinations.size(); j++ ) {
                movement(movables.get(i), destinations.get(j), this.playerTurn, plateau.getGame());
                // Appeler le minimax algo pour récupérer la meilleure valeur si on va faire ce déplacement.
                int scoreMinimax = minimaxAlgo(cloneGame(plateau.getGame()),2,this.playerTurn );

                if (scoreMinimax>meilleurScore || (i==0&&j==0)){
                    meilleurScore = scoreMinimax;
                    meilleurChoix.add(0, movables.get(i));
                    meilleurChoix.add(1 ,destinations.get(j));
                    meilleurChoix.subList(2,meilleurChoix.size()).clear();
                }
            }
        }
        return meilleurChoix;
    }

    public int minimaxAlgo(int[][] game, int depth,int joueurEnCours){
        Plateau plateau = new Plateau();

        int[][] gameTemp = cloneGame(game);

        plateau.setGame(cloneGame(game));
        //possibilité de mouvement
        ArrayList<Position> movables = plateau.SourceCaseJouable(joueurEnCours);
        //je calcule le score
        int myScore = GetPlateauScore(plateau.getGame(), joueurEnCours);
        // si y a pas de mouvement ou la profondeur fixé est atteinte alors retourner le score
        if (depth < 1 || myScore == plateau.getGame().length ) {
            return myScore;
        }
        // sinon continuer à calculer le score en appelant minimaxAlgo encore une fois
        int scoreFinale = 0;
        for (Integer i = 0; i < movables.size(); i++) {
            plateau.setGame(cloneGame(game));
            ArrayList<Position> destinations = plateau.DestCaseJouable(5,movables.get(i));
            // aprés chaque destination déplacer et avoir le nouveau dashboard
            // calculer le score
            for (int j = 0; j < destinations.size(); j++ ){
                // déplacer
                // chaque déplacement doit se faire sur un nouveau board afin d'éviter le probleme de référence dans les tableau java.
                if (joueurEnCours==2) {
                    // Mettre la valeur à min car notre but c'est de prendre le score maximum qui sera supérieur
                    scoreFinale = Integer.MIN_VALUE;
                    movement(movables.get(i), destinations.get(j), 2, cloneGame(plateau.getGame()));
                    scoreFinale = Integer.max(scoreFinale, minimaxAlgo(cloneGame(plateau.getGame()), depth - 1, monAdversaire(joueurEnCours)));
                } else{
                    // Mettre la valeur à max
                    scoreFinale = Integer.MAX_VALUE;
                    movement(movables.get(i), destinations.get(j), 1, plateau.getGame());
                    scoreFinale = Integer.min(scoreFinale, minimaxAlgo(plateau.getGame(), depth - 1, monAdversaire(joueurEnCours)));
                }
            }
        }
        return scoreFinale;

    }


    public int GetPlateauScore(int[][] Board,int player)  {
        // calculer les scores (lignes, diagonal, colonnes)
        int diagScore = getDiagScore(Board, player);
        int diagScoreOppose = getInvDiagScore(Board, player);
        int ligneScore = getMaxLigneScore(Board, player);
        int colsScore = getMaxColonnesScore(Board, player);
        int max = Integer.max(diagScore,diagScoreOppose);
        max = Integer.max(max,ligneScore);
        max = Integer.max(max,colsScore);

        return max;
    }


    public int getLigneScore(ArrayList<Integer> ligne, int player )  {
        int score = Integer.MIN_VALUE;
        for (int i = 0; i < ligne.size(); i++) {
            if (ligne.get(i) == player) {
                if (score==Integer.MIN_VALUE) score=1;
                else score++;
            }
        }
        return score;
    }

    public int getMaxLigneScore(int[][] Board, int player)  {
        int size = Board.length;

        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> ligne = new ArrayList<Integer>();

            //
            for(int j=0; j< Board[i].length; j++){
                ligne.add(Board[i][j]);

            }
            System.out.println("Calcule score ligne: "+ ligne.toString());
            scores.add( getLigneScore(ligne, player));
        }

        return getMaxInArray(scores);
    }

    public int getMaxColonnesScore(int[][] Board, int player)  {
        int size = Board.length;
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> colonne = new ArrayList<Integer>();
            //
            for(int j=0; j< Board.length; j++){
                colonne.add(Board[j][i]);
            }
            scores.add( getLigneScore(colonne, player));
        }

        return getMaxInArray(scores);
    }

    public Integer monAdversaire(Integer playerTurn){
        if (playerTurn==1)
            return 2;
        else
            return 1;
    }
    public int getDiagScore(int[][] Board, int player)  {
        ArrayList<Integer> diagonal = new ArrayList<>() ;
        int size = Board.length;
        for (int i = 0; i < size; i++ ){
            diagonal.add(Board[i][i]);
        }
        return getLigneScore(diagonal, player);
    }

    public int getInvDiagScore(int[][] Board, int player) {
        ArrayList<Integer> diagonalInverse = new ArrayList<>() ;
        int size = Board.length;
        for (int i = 0; i < size; i++ ){
            diagonalInverse.add(Board[i][size-1-i]);
        }
        return getLigneScore(diagonalInverse, player);
    }

    public int getMaxInArray(ArrayList<Integer> scoreArray)  {
        int max = 0;
        for(int i = 0; i < scoreArray.size(); i++) {
            if (scoreArray.get(i) > max) {
                max = scoreArray.get(i);
            }
        }
        return max;
    }



    public void movement(Position A_source, Position B_Destination, int player, int [][] game) {

    }

    public int [][] cloneGame(int[][] game){
        if(game == null) return null;

        int[][] result = new int[game.length][];
        for(int i=0; i< game.length; i++){
            result[i] = game[i].clone();
        }
        return result;
    }
}
