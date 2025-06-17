@Service
@RequiredArgsConstructor
public class StreakService {
    private final StreakRepository streakRepo;
    private final StreakHistoryRepository historyRepo;

    public Streak startStreak() {
        return streakRepo.findByActiveTrue().orElseGet(() -> {
            Streak newStreak = new Streak();
            newStreak.setStartTime(LocalDateTime.now());
            newStreak.setActive(true);
            return streakRepo.save(newStreak);
        });
    }

    public void resetStreak() {
        streakRepo.findByActiveTrue().ifPresent(current -> {
            current.setActive(false);
            streakRepo.save(current);

            StreakHistory hist = new StreakHistory();
            hist.setStartTime(current.getStartTime());
            hist.setEndTime(LocalDateTime.now());
            historyRepo.save(hist);
        });
    }

    public Optional<Streak> getCurrent() {
        return streakRepo.findByActiveTrue();
    }

    public List<StreakHistory> getHistory() {
        return historyRepo.findAll(Sort.by(Sort.Direction.DESC, "endTime"));
    }
}
