package web.jax.rs.data.jpa.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import web.jax.rs.data.jpa.domain.Album;
import web.jax.rs.data.jpa.dtos.AlbumShortDto;

import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TestEntityManager em;


    @Test
    public void testFindAllSort() {
        List<Album> album  = this.albumRepository.findAll();
        int expected = 207;
        int actual= album.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testListTitleAndAlbum() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dtos.AlbumShortDto(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
        List<AlbumShortDto> shortAlbumDto = q.getResultList();
        int expected = 207;
        assertEquals(expected, shortAlbumDto.size());
    }

    @Test
    public void getAlbumsShort_Brigande_1() {

        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dtos.AlbumShortDto(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum= :titreAlbum");
        q.setParameter("titreAlbum", "Brigande").getResultList();
        List<AlbumShortDto> shortAlbumDto = q.getResultList();
        int expected = 1;
        assertEquals(expected, shortAlbumDto.size());
    }

    @Test
    public void getCouple_Asterix_UderzoGoscinny() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dtos.AlbumShortDto((SELECT ap.personne.nomUsuel FROM Albumpersonne ap INNER JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Goscinny, René'), (SELECT ap.personne.nomUsuel FROM Albumpersonne ap INNER JOIN ap.album a2 WHERE a2 = a AND ap.personne.nom = 'Uderzo, Albert'), a.titreAlbum, s.titreSerie) FROM Album a LEFT JOIN a.serie s");
        int expected = 7;
        List<AlbumShortDto> shortAlbumDto  = q.getResultList();
        int actual = shortAlbumDto.size();
        System.out.println(shortAlbumDto.size());
        assertEquals(expected, actual);
    }

    @Test
    public void nbAlbums_All_39() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dtos.AlbumCountAuthorEditorDTO(count(a), a.editeur, ap.personne) FROM Album a LEFT JOIN a.albumpersonnes ap GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel ORDER BY count(a)");
        int expected = 39;
        List<AlbumShortDto> shortAlbumDto  = q.getResultList();
        int actual = shortAlbumDto.size();
        System.out.println(shortAlbumDto.size());
        assertEquals(expected, actual);
    }
}
