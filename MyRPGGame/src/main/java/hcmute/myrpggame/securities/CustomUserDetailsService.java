package hcmute.myrpggame.securities;

import java.util.stream.Collectors;

import hcmute.myrpggame.entities.AccountEntity;
import hcmute.myrpggame.repositories.accountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private accountRepository accountRepository;

    public CustomUserDetailsService(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public JwtAccountDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity account = accountRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Email %s does not exist!", email)));
        return getAccountDetails(account);
    }

    private JwtAccountDetails getAccountDetails(AccountEntity account) {
        return new JwtAccountDetails(
                account.getEmail(),
                account.getPassword(),
                account.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()),
                account.isTrangThai()
        );
    }
}
