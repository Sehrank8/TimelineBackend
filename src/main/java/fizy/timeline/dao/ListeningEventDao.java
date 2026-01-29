package fizy.timeline.dao;

import fizy.timeline.entity.dto.CountProjection;
import fizy.timeline.entity.ListeningEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ListeningEventDao
        extends JpaRepository<ListeningEvent, String> {

    @Query("""
                SELECT COUNT(le)
                FROM ListeningEvent le
                WHERE le.userId = :userId
                  AND le.completed = true
                  AND le.playedAt BETWEEN :start AND :end
            """)
    int countCompleted(
            String userId,
            Instant start,
            Instant end
    );

    @Query("""
                SELECT COALESCE(SUM(le.durationMs), 0)
                FROM ListeningEvent le
                WHERE le.userId = :userId
                  AND le.completed = true
                  AND le.playedAt BETWEEN :start AND :end
            """)
    long sumDuration(
            String userId,
            Instant start,
            Instant end
    );

    @Query(value = """
                SELECT
                s.id AS id,
                s.name AS name,
                COUNT(*) AS playCount
                FROM listening_event le
                JOIN song s ON s.id = le.song_id
                WHERE le.user_id = :userId
                  AND le.completed = true
                  AND le.played_at BETWEEN :start AND :end
                GROUP BY s.id, s.name
                ORDER BY playCount DESC
                LIMIT :limit
            """, nativeQuery = true)
    List<CountProjection> topSongs(
            String userId,
            Instant start,
            Instant end,
            int limit
    );

    @Query(value = """
                SELECT
                a.id AS id,
                a.name AS name,
                COUNT(*) AS playCount
                FROM listening_event le
                JOIN artist a ON a.id = le.artist_id
                WHERE le.user_id = :userId
                  AND le.completed = true
                  AND le.played_at BETWEEN :start AND :end
                GROUP BY a.id, a.name
                ORDER BY playCount DESC
                LIMIT :limit
            """, nativeQuery = true)
    List<CountProjection> topArtists(
            String userId,
            Instant start,
            Instant end,
            int limit
    );

    @Query(value = """
                SELECT
                al.id AS id,
                al.name AS name,
                COUNT(*) AS playCount
                FROM listening_event le
                JOIN album al ON al.id = le.album_id
                WHERE le.user_id = :userId
                  AND le.completed = true
                  AND le.played_at BETWEEN :start AND :end
                GROUP BY al.id, al.name
                ORDER BY playCount DESC
                LIMIT :limit
            """, nativeQuery = true)
    List<CountProjection> topAlbums(
            String userId,
            Instant start,
            Instant end,
            int limit
    );
}

