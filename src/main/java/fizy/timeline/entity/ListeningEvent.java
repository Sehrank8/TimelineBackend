package fizy.timeline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Entity
@Table(name = "listening_event")

public class ListeningEvent {
    public ListeningEvent(String id, String userId, String songId, String albumId, String artistId, Instant playedAt, Integer durationMs, Boolean completed) {
        this.id = id;
        this.userId = userId;
        this.songId = songId;
        this.albumId = albumId;
        this.artistId = artistId;
        this.playedAt = playedAt;
        this.durationMs = durationMs;
        this.completed = completed;
    }

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "song_id", nullable = false)
    private String songId;

    @Column(name = "album_id")
    private String albumId;

    @Column(name = "artist_id")
    private String artistId;

    @Column(name = "played_at", nullable = false)
    private Instant playedAt;

    @Column(name = "duration_ms")
    private Integer durationMs;

    @Column(name = "completed")
    private Boolean completed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public Instant getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(Instant playedAt) {
        this.playedAt = playedAt;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
