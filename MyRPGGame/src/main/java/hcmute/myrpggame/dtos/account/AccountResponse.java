package hcmute.myrpggame.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String token;
    private String email;
    private List<String> roles = new ArrayList<>();
}
