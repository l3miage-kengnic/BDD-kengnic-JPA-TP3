package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private  final AlbumRepository albumRepository;

    // lecture Read d'une entité Album, en base grace à son Id(title)
    public AlbumEntity getAlbum(String title){
        return albumRepository.findById(title).orElseThrow();
    }


    public AlbumEntity createAlbum(){
        AlbumEntity albumEntity = AlbumEntity
                .builder()
                .releaseDate()
                .title()
                //playlistEnt.....?
                .build();
        return albumRepository.save(albumEntity);
    }

    // fonction de mise à jour en Patch pour changer le titre d'une entité Album, en base de données
    public AlbumEntity updateTitle(String title, String newTitle){
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setTitle(newTitle);
        return albumRepository.save(albumEntity);
    }

    //supprime un album à partir de son Id(title)
    public void deletAlbum(String title){
        albumRepository.deleteById(title);
    }

}
