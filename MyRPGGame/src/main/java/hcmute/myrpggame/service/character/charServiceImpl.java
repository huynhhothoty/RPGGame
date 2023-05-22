package hcmute.myrpggame.service.character;

import hcmute.myrpggame.dtos.character.charDto;
import hcmute.myrpggame.entities.characterEntity;
import hcmute.myrpggame.entities.classEntity;
import hcmute.myrpggame.entities.questEntity;
import hcmute.myrpggame.exceptions.InvalidException;
import hcmute.myrpggame.exceptions.NotFoundException;
import hcmute.myrpggame.repositories.charRepository;
import hcmute.myrpggame.repositories.questRepository;
import hcmute.myrpggame.service.gameClass.classService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class charServiceImpl implements charService{

    private final charRepository charRepository;
    private final classService classService;
    private final questRepository questRepository;

    public charServiceImpl(hcmute.myrpggame.repositories.charRepository charRepository, hcmute.myrpggame.service.gameClass.classService classService, hcmute.myrpggame.repositories.questRepository questRepository) {
        this.charRepository = charRepository;
        this.classService = classService;
        this.questRepository = questRepository;
    }


    @Override
    public characterEntity create(charDto dto) {
        if (!ObjectUtils.isEmpty(dto.getCharId())){
            throw new InvalidException("Id field is auto generated, don't fill it!");
        }

        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill name!");
        }

        try {
            classEntity myClass = classService.getById(dto.getCharClass().getClassId());
            characterEntity entity = new characterEntity(null, dto.getName(), dto.getLevel(), myClass);
            charRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public characterEntity update(String id, charDto dto) {

        if (ObjectUtils.isEmpty(id)){
            throw new InvalidException("Please fill Id!");
        }

        if (!charRepository.existsByCharId(id)){
            throw new NotFoundException("Id is not exist!");
        }

        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill name!");
        }

        try {
            classEntity myClass = classService.getById(dto.getCharClass().getClassId());
            characterEntity entity = new characterEntity(id, dto.getName(), dto.getLevel(), myClass);
            charRepository.save(entity);

            List<questEntity> list = questRepository.findByHunter_CharId(id);
            list.forEach(x -> {
                x.setHunter(entity);
                questRepository.save(x);
            });

            return entity;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean delete(String id) {

        if (!charRepository.existsByCharId(id)){
            throw new NotFoundException("Id is not exist!");
        }

        charRepository.deleteById(id);

        List<questEntity> list = questRepository.findByHunter_CharId(id);
        list.forEach(x -> {
            x.setHunter(null);
            questRepository.save(x);
        });

        return true;
    }

    @Override
    public Page<characterEntity> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return charRepository.findAll(pageable);
    }

    @Override
    public characterEntity getById(String id) {
        Optional<characterEntity> temp = charRepository.findById(id);
        if (!temp.isPresent()){
            throw new NotFoundException("Id is not exist!");
        }
        characterEntity ch = temp.get();

        return ch;
    }
}
