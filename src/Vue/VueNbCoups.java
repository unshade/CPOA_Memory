package Vue;

import Modele.Modele;
import Modele.Sujet;

import javax.swing.*;

/**
 * @author steiner58u
 */
public class VueNbCoups extends JLabel implements Observateur {
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
