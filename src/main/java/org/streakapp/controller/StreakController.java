@RestController
@RequestMapping("/api/streak")
@RequiredArgsConstructor
public class StreakController {
    private final StreakService service;

    @PostMapping("/start")
    public ResponseEntity<Streak> start() {
        return ResponseEntity.ok(service.startStreak());
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> reset() {
        service.resetStreak();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/current")
    public ResponseEntity<Streak> current() {
        return service.getCurrent()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/history")
    public ResponseEntity<List<StreakHistory>> history() {
        return ResponseEntity.ok(service.getHistory());
    }
}
