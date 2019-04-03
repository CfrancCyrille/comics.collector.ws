package DTO;

public class AlbumShortDTO 
{
	
	String scenaristName;
	String cartoonistName;
	String title;
	String serie;
	
	public AlbumShortDTO(String scenaristName, String cartoonistName) 
	{
		this(scenaristName, cartoonistName, "", "");
	}

	public AlbumShortDTO(String scenaristName, String cartoonistName, String title, String serie) 
	{
		super();
		this.scenaristName = scenaristName;
		this.cartoonistName = cartoonistName;
		this.title = title;
		this.serie = serie;
	}

}
