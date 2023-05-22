package hcmute.myrpggame.repositories;

import hcmute.myrpggame.entities.characterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface charRepository extends MongoRepository<characterEntity, String> {

    boolean existsByCharId(String id);

    Page<characterEntity> findAll(Pageable pageable);

    List<characterEntity> findByCharClass_ClassId(String id);
}
