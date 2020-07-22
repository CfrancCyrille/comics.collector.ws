package cfranc.com.comics.collector.ws.dto;

public class AlbumShortDTO {
	String scenaristName;
	String cartoonistName;
	String title;
	String serie;
	
	public AlbumShortDTO(String title, String serie){
		this("", "", title, serie);
	}

	public AlbumShortDTO(String scenaristName, String cartoonistName, String title, String serie) {
		super();
		this.scenaristName = scenaristName;
		this.cartoonistName = cartoonistName;
		this.title = title;
		this.serie = serie;
	}
	
}
