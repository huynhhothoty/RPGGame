package hcmute.myrpggame.service.monster;

import hcmute.myrpggame.dtos.monster.monsterDto;
import hcmute.myrpggame.entities.monsterEntity;
import hcmute.myrpggame.entities.questEntity;
import hcmute.myrpggame.exceptions.InvalidException;
import hcmute.myrpggame.exceptions.NotFoundException;
import hcmute.myrpggame.repositories.monsterRepository;
import hcmute.myrpggame.repositories.questRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class monsterServiceImpl implements monsterService{

    private final monsterRepository monsterRepository;
    private final questRepository questRepository;

    public monsterServiceImpl(hcmute.myrpggame.repositories.monsterRepository monsterRepository, hcmute.myrpggame.repositories.questRepository questRepository) {
        this.monsterRepository = monsterRepository;
        this.questRepository = questRepository;
    }

    @Override
    public monsterEntity create(monsterDto dto) {

        if (!ObjectUtils.isEmpty(dto.getMonId())){
            throw new InvalidException("Id field is auto generated, don't fill it!");
        }

        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill monster name!");
        }

        monsterEntity entity = new monsterEntity(null, dto.getName(), dto.getPower(), dto.getSkill());
        monsterRepository.save(entity);
        return entity;
    }

    @Override
    public monsterEntity update(String id, monsterDto dto) {

        if (ObjectUtils.isEmpty(id)){
            throw new InvalidException("Please fill Id!");
        }

        if (!monsterRepository.existsByMonId(id)){
            throw new NotFoundException("Id is not exist!");
        }
        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill monster name!");
        }

        monsterEntity entity = new monsterEntity(id, dto.getName(), dto.getPower(), dto.getSkill());
        monsterRepository.save(entity);

        List<questEntity> list = questRepository.findByTargetMonster_MonId(id);
        list.forEach(x ->  {
            x.setTargetMonster(entity);
            questRepository.save(x);
        });

        return entity;
    }

    @Override
    public boolean delete(String id) {

        if (!monsterRepository.existsByMonId(id)){
            throw new NotFoundException("Id is not exist!");
        }

        monsterRepository.deleteById(id);

        List<questEntity> list = questRepository.findByTargetMonster_MonId(id);
        list.forEach(x ->  {
            x.setTargetMonster(null);
            questRepository.save(x);
        });

        return true;
    }

    @Override
    public Page<monsterEntity> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return monsterRepository.findAll(pageable);
    }

    @Override
    public monsterEntity getById(String id) {

        Optional<monsterEntity> temp = monsterRepository.findById(id);
        if (!temp.isPresent()){
            throw new NotFoundException("Id is not exist!");
        }
        monsterEntity mon = temp.get();

        return mon;
    }
}
