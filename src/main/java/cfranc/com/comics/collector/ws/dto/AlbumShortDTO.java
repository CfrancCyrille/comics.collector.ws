package cfranc.com.comics.collector.ws.dto;

public class AlbumShortDTO {

	String scenaristeName;
	String cartoonistName;
	String title;
	String serie;

	public AlbumShortDTO(String scenaristeName, String cartoonistName) {
		this(scenaristeName,cartoonistName,"","");
	}

	public AlbumShortDTO(String scenaristeName, String cartoonistName, String title, String serie) {
		super();
		this.scenaristeName = scenaristeName;
		this.cartoonistName = cartoonistName;
		this.title = title;
		this.serie = serie;
	}
}
