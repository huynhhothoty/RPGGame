package hcmute.myrpggame.service.quest;

import hcmute.myrpggame.dtos.quest.questDto;
import hcmute.myrpggame.entities.characterEntity;
import hcmute.myrpggame.entities.monsterEntity;
import hcmute.myrpggame.entities.questEntity;
import hcmute.myrpggame.exceptions.InvalidException;
import hcmute.myrpggame.exceptions.NotFoundException;
import hcmute.myrpggame.repositories.questRepository;
import hcmute.myrpggame.service.character.charService;
import hcmute.myrpggame.service.monster.monsterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class questServiceImpl implements questService {

    private final questRepository questRepository;
    private final charService charService;

    private final monsterService monsterService;

    public questServiceImpl(hcmute.myrpggame.repositories.questRepository questRepository, hcmute.myrpggame.service.character.charService charService, hcmute.myrpggame.service.monster.monsterService monsterService) {
        this.questRepository = questRepository;
        this.charService = charService;
        this.monsterService = monsterService;
    }


    @Override
    public questEntity create(questDto dto) {
        if (!ObjectUtils.isEmpty(dto.getQuestId())){
            throw new InvalidException("Id field is auto generated, don't fill it!");
        }

        try {
            characterEntity myChar = charService.getById(dto.getHunter().getCharId());
            monsterEntity myMon = monsterService.getById(dto.getTargetMonster().getMonId());

            questEntity entity = new questEntity(null, myMon, dto.getQuantity(),
                    dto.getReward(), myChar);
            questRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public questEntity update(String id, questDto dto) {
        if (ObjectUtils.isEmpty(id)){
            throw new InvalidException("Id field is auto generated, don't fill it!");
        }

        try {
            characterEntity myChar = charService.getById(dto.getHunter().getCharId());
            monsterEntity myMon = monsterService.getById(dto.getTargetMonster().getMonId());

            questEntity entity = new questEntity(id, myMon, dto.getQuantity(),
                    dto.getReward(), myChar);
            questRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean delete(String id) {

        if(!questRepository.existsByQuestId(id)){
            throw new NotFoundException("Id is not exist!");
        }

        questRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<questEntity> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return questRepository.findAll(pageable);
    }

    @Override
    public questEntity getById(String id) {
        Optional<questEntity> temp = questRepository.findById(id);
        if (!temp.isPresent()){
            throw new NotFoundException("Id is not exist!");
        }
        questEntity quest = temp.get();

        return quest;
    }
}
