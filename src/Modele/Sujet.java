package Modele;

import Vue.Observateur;

/**
 * @author steiner58u
 */
public interface Sujet {
    /**
     * Permet d'enregistrer un nouvel observateur
     * @param o Observateur a enregistrer
     */
    public void enregistrerObservateur(Observateur o);

    /**
     * Permet de supprimer un Observateur deja enregistre
     * @param o Observateur a supprimer
     */
    public void supprimerObservateur(Observateur o);

    /**
     * Permet d'actualiser les Observateurs
     */
    public void notifierObservateurs();
}
