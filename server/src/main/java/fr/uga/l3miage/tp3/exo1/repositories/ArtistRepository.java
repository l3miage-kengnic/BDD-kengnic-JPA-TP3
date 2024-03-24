package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, String> {
    // ii) requete : Récupérer le nombre d'artistes en fonction de leur genre musical.
    int countArtistEntitiesByGenreMusical(String genreMusical);
}
