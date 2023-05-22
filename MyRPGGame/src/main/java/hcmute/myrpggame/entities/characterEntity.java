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
@Document(collection = "characters")
public class characterEntity {

    @Id
    private String charId;

    private String name;

    private int level;

    private classEntity charClass;
}
