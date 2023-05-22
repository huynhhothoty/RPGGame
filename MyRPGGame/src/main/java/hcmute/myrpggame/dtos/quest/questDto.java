package hcmute.myrpggame.dtos.quest;

import hcmute.myrpggame.entities.characterEntity;
import hcmute.myrpggame.entities.monsterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class questDto {

    private String questId;

    private monsterEntity targetMonster;

    private int quantity;

    private String reward;

    private characterEntity hunter;
}
