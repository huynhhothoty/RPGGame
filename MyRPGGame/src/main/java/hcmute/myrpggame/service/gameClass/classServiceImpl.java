package hcmute.myrpggame.service.gameClass;

import hcmute.myrpggame.dtos.gameClass.classDto;
import hcmute.myrpggame.entities.characterEntity;
import hcmute.myrpggame.entities.classEntity;
import hcmute.myrpggame.exceptions.InvalidException;
import hcmute.myrpggame.exceptions.NotFoundException;
import hcmute.myrpggame.repositories.charRepository;
import hcmute.myrpggame.repositories.classRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class classServiceImpl implements classService{

    private final classRepository classRepository;
    private final charRepository charRepository;

    public classServiceImpl(hcmute.myrpggame.repositories.classRepository classRepository, hcmute.myrpggame.repositories.charRepository charRepository) {
        this.classRepository = classRepository;
        this.charRepository = charRepository;
    }

    @Override
    public classEntity create(classDto dto) {
        if (!ObjectUtils.isEmpty(dto.getClassId())){
            throw new InvalidException("Id field is auto generated, don't fill it!");
        }

        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill name!");
        }

        classEntity entity = new classEntity(null, dto.getName(), dto.getWeapon(), dto.getSkill());
        classRepository.save(entity);
        return entity;
    }

    @Override
    public classEntity update(String id, classDto dto) {
        if (ObjectUtils.isEmpty(id)){
            throw new InvalidException("Please fill Id!");
        }

        if (!classRepository.existsByClassId(id)){
            throw new NotFoundException("Id is not exist!");
        }
        if (ObjectUtils.isEmpty(dto.getName())){
            throw new InvalidException("Please fill name!");
        }

        classEntity entity = new classEntity(id, dto.getName(), dto.getWeapon(), dto.getSkill());
        classRepository.save(entity);

        List<characterEntity> list = charRepository.findByCharClass_ClassId(id);
        list.forEach(x -> {
            x.setCharClass(entity);
            charRepository.save(x);
        });

        return entity;
    }

    @Override
    public Page<classEntity> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return classRepository.findAll(pageable);
    }

    @Override
    public classEntity getById(String id) {

        Optional<classEntity> temp = classRepository.findById(id);
        if (!temp.isPresent()){
            throw new NotFoundException("Id is not exist!");
        }
        classEntity clx = temp.get();

        return clx;
    }

    @Override
    public boolean delete(String id) {
        if (!classRepository.existsByClassId(id)){
            throw new NotFoundException("Id is not exist!");
        }

        classRepository.deleteById(id);

        List<characterEntity> list = charRepository.findByCharClass_ClassId(id);
        list.forEach(x -> {
            x.setCharClass(null);
            charRepository.save(x);
        });

        return true;
    }
}
