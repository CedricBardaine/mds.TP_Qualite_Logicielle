package com.tactfactory.monprojetsb.controlers;

import org.springframework.ui.Model;

public interface genericControler {
	/**
	 * Liste l�ensemble des attributs de l�entit� pour tout les enregistrements. 
	 * Permet de naviguer vers la cr�ation d�un nouvel �l�ment. 
	 * Permet de naviguer vers le d�tails d�un �l�ment. 
	 * Permet de directement supprimer un �l�ment.
	 */
	String index(Model model);  
	/**
	 * Permet d�afficher la vue de cr�ation d�un �l�ment.
	 */
	public void createGet() ; 
	/**
	 * Permet d�envoyer les informations de l��l�ment vers le serveur et le sauvegarde dans la base de donn�es.
	 */
	public void createPost() ; 
	/**
	 * Permet de supprimer un �l�ment de la base de donn�es par son id.
	 */
	public void delete() ; 
	/**
	 *  Permet d�afficher le d�tails d�un �l�ment (avec les objets non primitif li�s).
	 */
	public void details() ;
	
	
}
