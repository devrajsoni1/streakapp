public interface StreakRepository extends MongoRepository<Streak, String> {
    Optional<Streak> findByActiveTrue();
}