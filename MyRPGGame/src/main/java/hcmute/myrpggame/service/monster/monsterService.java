package hcmute.myrpggame.service.monster;

import hcmute.myrpggame.dtos.monster.monsterDto;
import hcmute.myrpggame.entities.monsterEntity;
import org.springframework.data.domain.Page;

public interface monsterService {

    monsterEntity create(monsterDto dto);

    monsterEntity update(String id, monsterDto dto);

    boolean delete(String id);

    Page<monsterEntity> getAll(int page, int size);

    monsterEntity getById(String id);
}
