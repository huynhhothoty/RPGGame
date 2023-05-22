package hcmute.myrpggame.service.quest;

import hcmute.myrpggame.dtos.quest.questDto;
import hcmute.myrpggame.entities.questEntity;
import org.springframework.data.domain.Page;

public interface questService {

    questEntity create(questDto dto);

    questEntity update(String id, questDto dto);

    boolean delete(String id);

    Page<questEntity> getAll(int page, int size);

    questEntity getById(String id);
}
