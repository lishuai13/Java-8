package entity;

import java.util.List;

public class Album {
    private String name;
    private String tracks;
    private List<String> musicians;
    private int TrackList;

    public Album() {
    }

    public Album(String name, String tracks, int trackList) {
        this.name = name;
        this.tracks = tracks;
        TrackList = trackList;
    }

    public int getTrackList() {
        return TrackList;
    }

    public void setTrackList(int trackList) {
        TrackList = trackList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", tracks='" + tracks + '\'' +
                ", musicians=" + musicians +
                ", TrackList=" + TrackList +
                '}';
    }
}
