package Modele;

import Cartes.Carte;
import Vue.Observateur;
import java.util.List;

/**
 * @author steiner58u
 */
public class Modele implements Sujet {

    private Carte cartePrecedente;
    private List<Carte> cartes;
    private List<Observateur> observateurs;
    private int nbCoupJoues, nbPairesTrouvees;

    /**
     * Permet de retourner toutes les cartes
     */
    public void cacher(){
        for (Carte c : cartes) {
            c.setVisible(false);
        }
    }

    /**
     * Permet de melanger les cartes
     */
    public void melanger(){
        for (int i = 0; i < cartes.size(); i++) {
            int j = (int) (Math.random() * cartes.size());
            Carte temp = cartes.get(i);
            cartes.set(i, cartes.get(j));
            cartes.set(j, temp);
        }
    }

    /**
     * Retourne la liste des cartes
     * @return Liste des cartes
     */
    public List<Carte> getCartes() {
        return this.cartes;
    }

    /**
     * Retourne une carte en particulier
     * @param i carte a retourner
     */
    public void retournerCarte(int i){
        this.cartes.get(i).setVisible(true);
    }

    /**
     * Obtenir le nombre de coup joues
     * @return nombre de coup joues
     */
    public int getNbCoupJoues() {
        return this.nbCoupJoues;
    }

    /**
     * Obtenir le nombre de paires trouvees
     * @return nombre de paires trouvees
     */
    public int getNbPairesTrouvees() {
        return this.nbPairesTrouvees;
    }

    /**
     * Permet d'enregistrer un nouvel observateur
     *
     * @param o Observateur a enregistrer
     */
    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * Permet de supprimer un Observateur deja enregistre
     *
     * @param o Observateur a supprimer
     */
    @Override
    public void supprimerObservateur(Observateur o) {
        this.observateurs.remove(o);
    }

    /**
     * Permet d'actualiser les Observateurs
     */
    @Override
    public void notifierObservateurs() {
        for (Observateur observateur : this.observateurs) {
            observateur.actualiser(this);
        }
    }

}
