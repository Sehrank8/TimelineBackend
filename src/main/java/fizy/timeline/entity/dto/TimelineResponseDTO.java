package fizy.timeline.entity.dto;


import java.util.List;

public class TimelineResponseDTO {
    public TimelineResponseDTO(int year, long totalMinutes, int totalPlays, List<TopItemDTO> topSongs, List<TopItemDTO> topArtists, List<TopItemDTO> topAlbums) {
        this.year = year;
        this.totalMinutes = totalMinutes;
        this.totalPlays = totalPlays;
        this.topSongs = topSongs;
        this.topArtists = topArtists;
        this.topAlbums = topAlbums;
    }

    private int year;
    private long totalMinutes;
    private int totalPlays;

    private List<TopItemDTO> topSongs;
    private List<TopItemDTO> topArtists;
    private List<TopItemDTO> topAlbums;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    public List<TopItemDTO> getTopSongs() {
        return topSongs;
    }

    public void setTopSongs(List<TopItemDTO> topSongs) {
        this.topSongs = topSongs;
    }

    public List<TopItemDTO> getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(List<TopItemDTO> topArtists) {
        this.topArtists = topArtists;
    }

    public List<TopItemDTO> getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(List<TopItemDTO> topAlbums) {
        this.topAlbums = topAlbums;
    }
}
