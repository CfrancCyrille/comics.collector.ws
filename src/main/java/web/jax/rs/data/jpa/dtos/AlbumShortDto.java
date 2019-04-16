package web.jax.rs.data.jpa.dtos;

public class AlbumShortDto {
    private String scenaristName;
    private String cartoonListName;
    private String title;
    private String serie;

    public AlbumShortDto(String title, String serie) {
        this.title = title;
        this.serie = serie;
    }

    public AlbumShortDto(String scenaristName, String cartoonListName, String title, String serie) {
        this.scenaristName = scenaristName;
        this.cartoonListName = cartoonListName;
        this.title = title;
        this.serie = serie;
    }

    public String getScenaristName() {
        return scenaristName;
    }

    public void setScenaristName(String scenaristName) {
        this.scenaristName = scenaristName;
    }

    public String getCartoonListName() {
        return cartoonListName;
    }

    public void setCartoonListName(String cartoonListName) {
        this.cartoonListName = cartoonListName;
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
