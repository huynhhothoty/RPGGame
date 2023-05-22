package hcmute.myrpggame.repositories;

import hcmute.myrpggame.entities.questEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface questRepository extends MongoRepository<questEntity, String> {

    boolean existsByQuestId(String id);

    Page<questEntity> findAll(Pageable pageable);

    List<questEntity> findByTargetMonster_MonId(String id);

    List<questEntity> findByHunter_CharId(String id);
}
