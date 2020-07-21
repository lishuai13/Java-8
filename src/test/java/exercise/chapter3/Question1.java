package exercise.chapter3;

import entity.Album;
import entity.Artist;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {

    //1
    private static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (accumulator, element) -> accumulator + element);
    }

    //2
    private static List<String> getArtistNamesAndNations(List<Artist> artists){
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(),artist.getOrigin()))
                .collect(toList());
    }

    //3
    public static List<Album> getAlbumsWithMostThreeTracks(List<Album> albums){
        return albums.stream()
                .filter(album -> album.getTrackList() <= 3)
                .collect(toList());
    }

    @Test
    public void test1() {
        Integer[] a={1,2,3};
        Stream<Integer> a1 = Stream.of(a);
        int sum=addUp(a1);
        System.out.println(sum);
    }

    @Test
    public void test2() {
        Artist artist1 = new Artist("Tom","China");
        Artist artist2 = new Artist("Bob","America");
        List<Artist> artists = Arrays.asList(artist1,artist2);
        List<String> artistNamesAndNations = getArtistNamesAndNations(artists);
        for (String artistNamesAndNation : artistNamesAndNations) {
            System.out.println(artistNamesAndNation);
        }
    }

    @Test
    public void test3() {
        Album album1 = new Album("左轮手枪","曲目列表",5);
        Album album2 = new Album("麦克雷","曲目列表",2);
        Album album3 = new Album("维和者","曲目列表",3);
        List<Album> albums = Arrays.asList(album1,album2,album3);
        List<Album> albumsWithMostThreeTracks = getAlbumsWithMostThreeTracks(albums);
        for (Album albumsWithMostThreeTrack : albumsWithMostThreeTracks) {
            System.out.println(albumsWithMostThreeTrack);
        }
    }



}
