package web.jax.rs.data.jpa.dto;

public class AlbumShortDTO {
    private String scenaristeName;
    private String cartoonistName;
    private String title;
    private String serie;


    public AlbumShortDTO(String scenaristeName, String cartoonistName){
        this(scenaristeName, cartoonistName, "","");
    }

    public AlbumShortDTO(String scenaristeName,
                         String cartoonistName,
                         String title,
                         String serie){
        super();
        this.scenaristeName = scenaristeName;
        this.cartoonistName = cartoonistName;
        this.title = title;
        this.serie = serie;
    }
}
