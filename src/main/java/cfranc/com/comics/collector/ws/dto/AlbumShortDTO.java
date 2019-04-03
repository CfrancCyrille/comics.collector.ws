package cfranc.com.comics.collector.ws.dto;

public class AlbumShortDTO {
    private String scenaristName, cartonnistName, title, serie;

    public String getScenaristName() {
        return scenaristName;
    }

    public String getCartonnistName() {
        return cartonnistName;
    }

    public String getTitle() {
        return title;
    }

    public String getSerie() {
        return serie;
    }

    public AlbumShortDTO(String scenaristName, String cartonnistName) {
        this(scenaristName, cartonnistName, "", "");
    }

    public AlbumShortDTO(String scenaristName, String cartonnistName, String title, String serie) {
        super();
        this.scenaristName = scenaristName;
        this.cartonnistName = cartonnistName;
        this.title = title;
        this.serie = serie;
    }
}
