package hcmute.myrpggame.dtos.character;

import hcmute.myrpggame.entities.classEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class charDto {

    private String charId;

    private String name;

    private int level;

    private classEntity charClass;
}
