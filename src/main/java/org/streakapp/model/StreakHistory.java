@Document(collection = "streak_history")
@Data
public class StreakHistory {
    @Id
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
