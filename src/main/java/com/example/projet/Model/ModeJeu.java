package com.example.projet.Model;

public class ModeJeu {
    // 1 = humain vs humain
    // 2 = humain vs IA
    // Develooped by @Amine
    public int mode;

    public ModeJeu() {
    }
    public ModeJeu(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
