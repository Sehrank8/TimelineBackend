package fizy.timeline.controller;

import fizy.timeline.entity.dto.LoginRequestDTO;
import fizy.timeline.entity.dto.TimelineResponseDTO;
import fizy.timeline.service.AuthService;
import fizy.timeline.service.TimelineGenerationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timeline")
public class TimelineController {

    public TimelineController(TimelineGenerationService generator, AuthService authService) {
        this.generator = generator;
        this.authService = authService;
    }

    private final TimelineGenerationService generator;
    private final AuthService authService;

    @GetMapping("/{userId}/{year}")
    public TimelineResponseDTO getTimeline(
            @PathVariable String userId,
            @PathVariable int year) {
        return generator.generate(userId, year);
    }
    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequestDTO request) {

        return authService.login(request.getUsername(), request.getPassword());
    }

}
