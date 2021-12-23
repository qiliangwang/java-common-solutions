package commonsolutions.notification.repository;

import commonsolutions.notification.service.Training;
import commonsolutions.notification.service.TrainingId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface TrainingRepository {
    Optional<Training> trainingOf(TrainingId trainingId);
    void add(Training training);
    void remove(Training training);
}