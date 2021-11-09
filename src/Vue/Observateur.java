package Vue;

import Modele.Sujet;

/**
 * @author steiner58u
 */
public interface Observateur {

    /**
     * Permet d'actualiser les vues
     * @param s sujet sur lequel on se base pour actualiser
     */
    public void actualiser(Sujet s);
}
