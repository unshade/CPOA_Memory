package Modele;

import Cartes.Carte;
import Vue.Observateur;
import Vue.VueCarte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author steiner58u
 */
public class Modele implements Sujet {

    /**
     * Carte precedement jouee
     */
    private Carte cartePrecedente;
    /**
     * Liste des cartes du jeu
     */
    private List<Carte> cartes;
    /**
     * Liste des observateurs du modele
     */
    private List<Observateur> observateurs;
    /**
     * Informations sur la partie
     */
    private int nbCoupJoues, nbPairesTrouvees;

    /**
     * Constructeur du modele
     * @param cartes Liste des cartes
     */
    public Modele(List<Carte> cartes) {
        this.cartePrecedente = null;
        this.cartes = cartes;
        this.observateurs = new ArrayList<>();
        this.nbCoupJoues = 0;
        this.nbPairesTrouvees = 0;
    }

    /**
     * Permet de retourner toutes les cartes
     */
    public void cacher(){
        for (Carte c : cartes) {
            c.setVisible(false);
        }
        this.notifierObservateurs();
    }

    /**
     * Permet de melanger les cartes
     */
    public void melanger(){
        Collections.shuffle(this.cartes);
        this.notifierObservateurs();
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
        notifierObservateurs();
        if (this.cartePrecedente == null) {
            this.cartePrecedente = this.cartes.get(i);
        }
        else {
            this.nbCoupJoues++;
            if (this.cartes.get(i).getNum() == this.cartePrecedente.getNum()) {
                this.cartePrecedente = null;
                this.nbPairesTrouvees++;
                this.notifierObservateurs();
            }
            else {
                this.cartes.get(i).setVisible(false);
                this.cartePrecedente.setVisible(false);
                this.cartePrecedente = null;
            }
        }
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

    /**
     * Permet de changer les images
     * @param s nom de la collection d'images
     */
    public void changeImg(String s) {
        VueCarte.setRepertoire(s);
        this.notifierObservateurs();
    }

}
