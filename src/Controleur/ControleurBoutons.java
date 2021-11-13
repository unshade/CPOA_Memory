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
        if (e.getActionCommand().equals("Cacher")) {
            this.modele.cacher();
        }
        if (e.getActionCommand().equals("Melanger")) {
            this.modele.melanger();
        }
        if (e.getActionCommand().equals("Smiley")) {
            this.modele.changeImg("smiley");
        }
        if (e.getActionCommand().equals("Fruits")) {
            this.modele.changeImg("fruits");
        }
    }
}
