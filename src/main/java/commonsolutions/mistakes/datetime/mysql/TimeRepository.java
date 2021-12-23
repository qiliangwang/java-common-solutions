package commonsolutions.mistakes.datetime.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Long> {
}