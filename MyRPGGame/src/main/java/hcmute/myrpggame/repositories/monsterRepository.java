package hcmute.myrpggame.repositories;

import hcmute.myrpggame.entities.monsterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface monsterRepository extends MongoRepository<monsterEntity, String> {

    boolean existsByMonId(String id);

    Page<monsterEntity> findAll(Pageable pageable);
}
