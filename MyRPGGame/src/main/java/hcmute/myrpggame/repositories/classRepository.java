package hcmute.myrpggame.repositories;

import hcmute.myrpggame.entities.classEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface classRepository extends MongoRepository<classEntity, String> {

    boolean existsByClassId(String id);

    Page<classEntity> findAll(Pageable pageable);
}
