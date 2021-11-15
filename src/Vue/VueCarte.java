package Vue;

import Cartes.Carte;
import Modele.Modele;
import Modele.Sujet;

import javax.swing.*;

/**
 * @author steiner58u
 */
public class VueCarte extends JLabel implements Observateur {
    private int indexCarte;
    private static String repertoire;
    private Carte carte;

    /**
     * Constructeur de la classe
     * @param indexCarte s index de la carte
     */
    public VueCarte(Carte carte, int indexCarte) {
        this.carte = carte;
        this.indexCarte = indexCarte;
        this.setIcon(new ImageIcon("img/" + repertoire + "/" + "fond.png"));
    }

    /**
     * Permet d'actualiser les vues
     *
     * @param s sujet sur lequel on se base pour actualiser
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m = (Modele) s;
        this.carte = m.getCartes().get(this.indexCarte);
        String path;
        if (this.carte.isVisible()) {
            path = "img/" + repertoire + "/" + "im" + this.carte.getNum() + ".png";
        }
        else {
            path = "img/" + repertoire + "/" + "fond.png";
        }
        this.setIcon(new ImageIcon(path));
    }

    /**
     * Obtenir l'index de la carte
     * @return l'index de la carte
     */
    public int getIndexCarte() {
        return this.indexCarte;
    }

    /**
     * Obtenir la carte
     * @return la carte
     */
    public Carte getCarte() {
        return this.carte;
    }


    /**
     * Obtenir le repertoire
     * @param repertoire repertoire
     */
    public static void setRepertoire(String repertoire) {
        VueCarte.repertoire = repertoire;
    }
}
