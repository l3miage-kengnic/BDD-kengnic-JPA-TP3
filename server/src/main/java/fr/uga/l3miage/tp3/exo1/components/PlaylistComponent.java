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
                .totalDuration()
                .description("")
                .name()
                //.playlist*************
                .build();
        return playlistRepository.save(playlistEntity);
    }


}
