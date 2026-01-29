package fizy.timeline.service;

import fizy.timeline.entity.dto.TimelineResponseDTO;
import fizy.timeline.entity.dto.TopItemDTO;
import fizy.timeline.dao.ListeningEventDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class TimelineGenerationService {

    private final ListeningEventDao listeningRepo;


    public TimelineGenerationService(ListeningEventDao listeningRepo) {
        this.listeningRepo = listeningRepo;
    }

    @Transactional
    public TimelineResponseDTO generate(String userId, int year) {

        Instant start = LocalDate.of(year, 1, 1)
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant();

        Instant end = LocalDate.of(year, 12, 31)
                .atTime(23, 59, 59)
                .toInstant(ZoneOffset.UTC);

        int totalPlays = listeningRepo.countCompleted(userId, start, end);
        long totalMinutes = (listeningRepo.sumDuration(userId, start, end) / 60000);

        List<TopItemDTO> topSongs = listeningRepo
                .topSongs(userId, start, end, 5)
                .stream()
                .map(p -> new TopItemDTO(p.getName(), p.getPlayCount()))
                .toList();

        List<TopItemDTO> topArtists = listeningRepo
                .topArtists(userId, start, end, 5)
                .stream()
                .map(p -> new TopItemDTO(p.getName(), p.getPlayCount()))
                .toList();

        List<TopItemDTO> topAlbums = listeningRepo
                .topAlbums(userId, start, end, 5)
                .stream()
                .map(p -> new TopItemDTO(p.getName(), p.getPlayCount()))
                .toList();

        return new TimelineResponseDTO(
                year,
                totalMinutes,
                totalPlays,
                topSongs,
                topArtists,
                topAlbums
        );
    }

}
