package security;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.Collections;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceDeliveryApp implements UserDetailsService {

    final UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.getUserByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username not found: %s", username)));

        return new UserDetailsDeliveryApp(
                user.get().getUsername(),
                user.get().getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.get().getRole().toString()))
        );
    }
}
