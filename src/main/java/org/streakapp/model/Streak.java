@Document(collection = "streaks")
@Data
public class Streak {
    @Id
    private String id;
    private LocalDateTime startTime;
    private boolean active;
}
