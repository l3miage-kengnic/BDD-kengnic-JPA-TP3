package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    public ArtistEntity getArtist(String name){
        return artistRepository.findById(name).orElseThrow();
    }

    public ArtistEntity createArtist(){
        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .genreMusical() //que mettre entre parenthèses...?
                .biography()
                .name("nom artiste")
                // playlistEnt..relation OneToMany, ManyToOne...?
                .build();

        return artistRepository.save(artistEntity);
    }

    // fonction de mise à jour en Patch pour changer la biography d'une entité Artist, en base de données
    public ArtistEntity updateBiography(String biography, String newBiography){
        ArtistEntity artistEntity = artistRepository.findById(biography).orElseThrow();
        artistEntity.setBiography(newBiography);
        return artistRepository.save(artistEntity);

    }

    //supprime un artiste à partir de son Id(name)
    public void deleteArtist(String name){

    }

    // ii) Récupérer le nombre d'artistes en fonction de leur genre musical.
    public int getNumberArtistByGenreMusical(String genreMusical){
        return artistRepository.countArtistEntitiesByGenreMusical(genreMusical);
    }

}
