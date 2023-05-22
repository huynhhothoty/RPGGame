package hcmute.myrpggame.service.character;

import hcmute.myrpggame.dtos.character.charDto;
import hcmute.myrpggame.entities.characterEntity;
import org.springframework.data.domain.Page;

public interface charService {

    characterEntity create(charDto dto);

    characterEntity update(String id, charDto dto);

    boolean delete(String id);

    Page<characterEntity> getAll(int page, int size);

    characterEntity getById(String id);
}
