package hcmute.myrpggame.service.gameClass;

import hcmute.myrpggame.dtos.gameClass.classDto;
import hcmute.myrpggame.entities.classEntity;
import org.springframework.data.domain.Page;

public interface classService {

    classEntity create(classDto dto);

    classEntity update(String id, classDto dto);

    Page<classEntity> getAll(int page, int size);

    classEntity getById(String id);

    boolean delete(String id);
}
