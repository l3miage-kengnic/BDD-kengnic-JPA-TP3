package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    // lecture/Read d'une entité Song, en base grace à son Id(title)
    public SongEntity getSong(String title){
        return songRepository.findById(title).orElseThrow();
    }

    public SongEntity createSong(){
        SongEntity songEntity = SongEntity
                .builder()
                .duration() // c'est quoi le type Duration?!!!
                // playlistEnt..relation OneToMany, ManyToOne...?
                .title()
                .build();
        return songRepository.save(songEntity);
    }

    public SongEntity updateTitle(String title, String newtitle){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setTitle(newtitle);
        return songRepository.save(songEntity);
    }

    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

    // i) Récupérez une chanson dont la durée est comprise dans un interval donné
    public SongEntity getSongDurationBetween(int t1, int t2){
        return songRepository.findByDurationBetween(t1, t2);
        // quelles valeures en argument (t1, t2)? quelle échelle pour l'intervalle(seconde, minutes,..)
        //quel type (int, long, float)?
    }
}
