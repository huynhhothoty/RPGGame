package hcmute.myrpggame.dtos.monster;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class monsterDto {

    private String monId;

    private String name;

    private int power;

    private String skill;
}
