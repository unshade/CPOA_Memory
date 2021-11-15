import Cartes.Carte;
import Controleur.ControleurBoutons;
import Controleur.ControleurSouris;
import Modele.Modele;
import Vue.VueCarte;
import Vue.VueNbCoups;
import Vue.VueNbPaires;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {


		/**********************************
		* Création des bords des composants
		***********************************/
		Border 			compound;
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
					
		
		/***************************************************************
		*Creation de la liste de cartes avec un doublon de chaque carte
		****************************************************************/
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		for (int i = 0; i < 20; i++) {
			Carte carte = new Carte((int) i / 2);
			cartes.add(carte);
		}
		// Mélange des cartes
		Collections.shuffle(cartes);
		
		Modele modele = new Modele(cartes);


		/*******************************************************************
		* Le JPanel plateau au nord dans lequel les cartes sont affichees
		* les JLabel avec une ImageIcon associee a chaque carte
		* Le choix du jeu de carte est fait selon la valeur de répertoire
		********************************************************************/
		JPanel plateau =new JPanel();
		plateau.setBorder(compound);
		plateau.setLayout(new GridLayout(4, 5));
		plateau.setSize(120 * 5, 120 * 4);
		
		//Création des JLabel associés aux cartes - affichage dans le JPanel Plateau
		String repertoire="smiley"; //ou "fruits" selon la série choisie
		VueCarte.setRepertoire(repertoire);
		for (int i = 0; i < 20; i++) {
			VueCarte newCarte = new VueCarte(cartes.get(i), i);
			plateau.add(newCarte); //association du fichier image avec le JLabel avec la classe ImageIcon
			newCarte.addMouseListener(new ControleurSouris(modele));
			modele.enregistrerObservateur(newCarte);
		}

		
		/********************************************************************
		* Le JPanel panneauScore au centre de l'IG contenant des informations
		* sur le nombre de coups joues et le nombre de paires decouvertes
		********************************************************************/
		JPanel 			panneauScore;
		panneauScore= new JPanel(new GridLayout(2,1));
		
		VueNbCoups nbCoups;
		nbCoups=new VueNbCoups(" Nombre de coups joués : 0 ",JLabel.CENTER);
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauScore.add(nbCoups);
		modele.enregistrerObservateur(nbCoups);
	
		VueNbPaires nbPaires;
		nbPaires=new VueNbPaires("Nombre de paires découvertes :  0 ",JLabel.CENTER);
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauScore.add(nbPaires);
		modele.enregistrerObservateur(nbPaires);
				
		
		/********************************************************************
		* Le JPanel panneauChoix au sud de l'IG contenant les 4 boutons
		********************************************************************/
		JPanel panneauChoix=new JPanel();

		ControleurBoutons controleurBoutons = new ControleurBoutons(modele);

		JButton boutonSmiley = new JButton("Smiley");
		panneauChoix.add(boutonSmiley);
		boutonSmiley.addActionListener(controleurBoutons);
		
		JButton boutonFruits = new JButton("Fruits");
		panneauChoix.add(boutonFruits);
		boutonFruits.addActionListener(controleurBoutons);
		
		JButton boutonCacher = new JButton("Cacher");
		panneauChoix.add(boutonCacher);
		boutonCacher.addActionListener(controleurBoutons);

		JButton boutonMelanger = new JButton("Melanger");		
		panneauChoix.add(boutonMelanger);
		boutonMelanger.addActionListener(controleurBoutons);
		
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.add(plateau,BorderLayout.NORTH);
		frame.add(panneauScore,BorderLayout.CENTER);
		frame.add(panneauChoix, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
