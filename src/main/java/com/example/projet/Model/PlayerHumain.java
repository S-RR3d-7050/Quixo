package com.example.projet.Model;

public class PlayerHumain implements Player {
    public void movement(Position A_source, Position B_Destination, int player, int [][] game) {

        int XSource = A_source.getX(), YSource = A_source.getY();
        int XDest = B_Destination.getX(), YDest = B_Destination.getY();
        if (YSource == YDest) {
            // si la destination a un id plus grand
            //on décale vers La droite (incrémente)
            if (XSource < XDest) {
                for (int i = XSource; i < 4; i++) {

                    game[i][YSource] = game[i + 1][YSource];
                }
            }


            // si la destination a un id plus petit on décale vers La gauche(décrémente)
            if (XSource > XDest) {
                for (int i = XSource; i > 0; i--) {
                    game[i][YSource] = game[i - 1][YSource];
                }
            }

        }

        if (XSource == XDest) {
            // si la destination a un id plus grand on décale vers La droite (incrémente)
            if (YSource < YDest) {
                for (int i = YSource; i < 4; i++) {

                    game[XSource][i]= game[XSource][i + 1];

                }
            }

            // si la destination a un id plus petit on décale vers La gauche(décrémente)
            if (YSource > YDest) {
                for (int i = YSource; i > 0; i--) {
                    game[XSource][i]= game[XSource][i - 1];
                }
            }
        }


        game[XDest][YDest] = player;

    }
}
