package Vue;

import Cartes.Carte;
import Modele.Modele;
import Modele.Sujet;

import javax.swing.*;

public class VueCarte extends JLabel implements Observateur {
    private int indexCarte;
    private String repertoire;

    /**
     * Constructeur de la classe
     * @param repertoire repertoire de la carte
     * @param indexCarte s index de la carte
     */
    public VueCarte(String repertoire, int indexCarte) {
        this.repertoire = repertoire;
        this.indexCarte = indexCarte;
    }

    /**
     * Permet d'actualiser les vues
     *
     * @param s sujet sur lequel on se base pour actualiser
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m = (Modele) s;
        if (m.getCartes().get(this.indexCarte).isVisible()) {
            this.setIcon(new ImageIcon(this.repertoire + "/" + "im" + this.indexCarte + ".png"));
        }
        else {
            this.setIcon(new ImageIcon(this.repertoire + "/" + "fond.png"));
        }
    }

    /**
     * Obtenir l'index de la carte
     * @return l'index de la carte
     */
    public int getIndexCarte() {
        return this.indexCarte;
    }
}
