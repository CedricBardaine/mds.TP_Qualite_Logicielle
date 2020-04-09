package com.tactfactory.monprojetsb.controlers;

import org.springframework.ui.Model;

public interface genericControler {
	/**
	 * Liste l’ensemble des attributs de l’entité pour tout les enregistrements. 
	 * Permet de naviguer vers la création d’un nouvel élément. 
	 * Permet de naviguer vers le détails d’un élément. 
	 * Permet de directement supprimer un élément.
	 */
	String index(Model model);  
	/**
	 * Permet d’afficher la vue de création d’un élément.
	 */
	public void createGet() ; 
	/**
	 * Permet d’envoyer les informations de l’élément vers le serveur et le sauvegarde dans la base de données.
	 */
	public void createPost() ; 
	/**
	 * Permet de supprimer un élément de la base de données par son id.
	 */
	public void delete() ; 
	/**
	 *  Permet d’afficher le détails d’un élément (avec les objets non primitif liés).
	 */
	public void details() ;
	
	
}
