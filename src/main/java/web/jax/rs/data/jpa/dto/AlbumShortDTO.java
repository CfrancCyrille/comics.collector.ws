package web.jax.rs.data.jpa.dto;

public class AlbumShortDTO {
    String scenaristName;
    String cartoonistName;
    String title;
    String serie;

    public AlbumShortDTO(String scenaristName, String cartoonistName, String title, String serie) {
        super();
        this.scenaristName = scenaristName;
        this.cartoonistName = cartoonistName;
        this.title = title;
        this.serie = serie;
    }


    public AlbumShortDTO(String title, String serie) {
        super();
        this.title = title;
        this.serie = serie;
    }

    public String getScenaristName() {
        return scenaristName;
    }

    public void setScenaristName(String scenaristName) {
        this.scenaristName = scenaristName;
    }

    public String getCartoonistName() {
        return cartoonistName;
    }

    public void setCartoonistName(String cartoonistName) {
        this.cartoonistName = cartoonistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}


