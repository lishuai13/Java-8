package exercise.chapter4;

import entity.Artist;

import java.util.List;
import java.util.Optional;

public class Question3 {

    private List<Artist> artists;

    public Question3(List<Artist> artists) {
        this.artists = artists;
    }

    private Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                .orElse("unknown");
    }

}
