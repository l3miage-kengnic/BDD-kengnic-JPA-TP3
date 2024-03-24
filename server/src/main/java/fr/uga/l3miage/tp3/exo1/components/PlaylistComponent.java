package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor // injection de dépendance de l'attribut playlistRepository
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name){
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity creatPlaylist(){
        PlaylistEntity playlistEntity = PlaylistEntity
                .builder()
                .totalDuration() // c'est quoi le type Duration?
                .description("description")
                .name("playlistname")
                //.playlist*************
                .build();
        return playlistRepository.save(playlistEntity);
    }

    // ici on construit une fonction de mise à jour en Patch pour changer la description d'une playlst, en base de données
    public PlaylistEntity updatedDescription(String name, String newDescription){
            PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
            playlistEntity.setDescription(newDescription);
            return playlistRepository.save(playlistEntity);
    }

    //ici on supprime en base de données une entité(playlist) à partir de son Id(name)
    public void deleteUser(String name){
        playlistRepository.deleteById(name);
    }

    // iii) Requete: Récupérez toutes les playlists, sans doublons qui ont une chanson particulière
    public Set<PlaylistEntity> getDistinctPlaylistsBySong(String songName){
        return playlistRepository.findDistinctBySongEntities(songName);
    }

}
