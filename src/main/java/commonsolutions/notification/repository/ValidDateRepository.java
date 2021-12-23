package commonsolutions.notification.repository;

import commonsolutions.notification.service.TrainingId;
import commonsolutions.notification.service.ValidDate;
import commonsolutions.notification.service.ValidDateType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface ValidDateRepository {
    Optional<ValidDate> validDateOf(TrainingId trainingId, ValidDateType validDateType);
    void add(ValidDate validDate);
    void remove(ValidDate validDate);
}
