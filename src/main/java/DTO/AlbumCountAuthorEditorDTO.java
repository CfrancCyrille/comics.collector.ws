package DTO;

import cfranc.com.comics.collector.ws.model.Personne;
import cfranc.com.comics.collector.ws.model.Editeur;

public class AlbumCountAuthorEditorDTO 
{
	
	long NbrAlbum;
	Editeur Editeur;
	Personne Person;
	
	public AlbumCountAuthorEditorDTO(long nbrAlbum, Editeur editeur, Personne person) 
	{
		super();
		NbrAlbum = nbrAlbum;
		Editeur = editeur;
		Person = person;
	}
	
	

}
