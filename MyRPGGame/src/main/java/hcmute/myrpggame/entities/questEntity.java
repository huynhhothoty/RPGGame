package hcmute.myrpggame.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quests")
public class questEntity {

    @Id
    private String questId;

    monsterEntity targetMonster;

    private int quantity;

    private String reward;

    characterEntity hunter;
}
