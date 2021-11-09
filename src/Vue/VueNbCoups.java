package Vue;

import Modele.Modele;
import Modele.Sujet;

import javax.swing.*;

/**
 * @author steiner58u
 */
public class VueNbCoups extends JLabel implements Observateur {

    /**
     * Creates a <code>JLabel</code> instance with the specified text.
     * The label is aligned against the leading edge of its display area,
     * and centered vertically.
     *
     * @param text The text to be displayed by the label.
     */
    public VueNbCoups(String text) {
        super(text);
    }

    /**
     * Permet d'actualiser les vues
     *
     * @param s sujet sur lequel on se base pour actualiser
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m = (Modele) s;
        this.setText("Nombre de coups joués : " + m.getNbCoupJoues());
    }

}
