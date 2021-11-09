package Controleur;

import Modele.Modele;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author steiner58u
 */
public class ControleurSouris implements MouseListener {

    /**
     * Modele du controlleur
     */
    Modele modele;

    /**
     * Constructeur de base
     * @param m modele
     */
    public ControleurSouris(Modele m) {
        this.modele = m;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
