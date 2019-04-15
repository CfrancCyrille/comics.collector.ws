package comics.collector.ws.dto;

public class AlbumShortDTO {
	private String scenaristName;
	private String cartoonistName;
	private String title;
	private String serie;

	public AlbumShortDTO(String title, String serie) {
		super();
		this.title = title;
		this.serie = serie;
	}

	public AlbumShortDTO(String scenaristName, String cartoonistName, String title, String serie) {
		super();
		this.scenaristName = scenaristName;
		this.cartoonistName = cartoonistName;
		this.title = title;
		this.serie = serie;
	}

}
