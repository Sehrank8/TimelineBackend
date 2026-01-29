package fizy.timeline.controller;

import fizy.timeline.entity.dto.TimelineResponseDTO;
import fizy.timeline.service.TimelineGenerationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wrapped")
public class TimelineController {

    public TimelineController(TimelineGenerationService generator) {
        this.generator = generator;
    }

    private final TimelineGenerationService generator;

    @GetMapping("/{userId}/{year}")
    public TimelineResponseDTO getTimeline(
            @PathVariable String userId,
            @PathVariable int year) {
        return generator.generate(userId, year);
    }
}
