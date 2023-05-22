package hcmute.myrpggame.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class AccountEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String accountName;

    private String email;

    @JsonIgnore
    private String password;

    private String userID;

    private List<String> roles = new ArrayList<>();

    private boolean trangThai = true;

}
