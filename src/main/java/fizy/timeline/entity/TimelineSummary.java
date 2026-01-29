package fizy.timeline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Entity
@Table(name = "zaman_tuneli_summary")
public class TimelineSummary {
    public TimelineSummary(String id, String userId, String year, Integer totalMinutes, Integer totalPlays, String topGenre, Instant created) {
        this.id = id;
        this.userId = userId;
        this.year = year;
        this.totalMinutes = totalMinutes;
        this.totalPlays = totalPlays;
        this.topGenre = topGenre;
        this.created = created;
    }

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(nullable = false)
    private String year;

    private Integer totalMinutes;
    private Integer totalPlays;
    private String topGenre;

    private Instant created;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Integer totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public Integer getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(Integer totalPlays) {
        this.totalPlays = totalPlays;
    }

    public String getTopGenre() {
        return topGenre;
    }

    public void setTopGenre(String topGenre) {
        this.topGenre = topGenre;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
