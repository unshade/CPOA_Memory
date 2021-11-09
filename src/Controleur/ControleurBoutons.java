package Controleur;

import Modele.Modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author steiner58u
 */
public class ControleurBoutons implements ActionListener {

    /**
     * Modele du controleur
     */
    Modele modele;

    /**
     * Contructeur de base
     * @param m modele
     */
    public ControleurBoutons(Modele m) {
        this.modele = m;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
