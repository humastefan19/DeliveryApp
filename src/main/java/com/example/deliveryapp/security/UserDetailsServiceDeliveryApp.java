package com.example.deliveryapp.security;

import com.example.deliveryapp.model.User;
import com.example.deliveryapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceDeliveryApp implements UserDetailsService {

    final UserRepository userRepo;


    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.getUserByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username not found: %s", username)));
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.get().getUsername())
//                .password(user.get().getPassword())
//                .authorities(user.get().getRoles().stream().limit(1).toString()).build();
//        return userDetails;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.get().getRole()){
        grantedAuthorities.add(new SimpleGrantedAuthority(user.get().getRole().getName()));
//        }

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);

    }
}
