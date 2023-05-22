package hcmute.myrpggame.repositories;

import hcmute.myrpggame.entities.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface accountRepository extends MongoRepository<AccountEntity, String> {
    Optional<AccountEntity> findByEmail(String email);
}
