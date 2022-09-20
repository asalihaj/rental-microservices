package com.rental.securityjwtservice.service;

import com.rental.securityjwtservice.model.AppUser;
import com.rental.securityjwtservice.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RentalUserServiceImpl implements RentalUserService {
    private final AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userData = userRepository.findByUsername(username);
        if (userData.isPresent()) {
            AppUser user = userData.get();

            return new User(user.getUsername(),
                    user.getPassword(), getAuthorities(user));
        }
        throw new UsernameNotFoundException("User not found in the database");
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(AppUser user) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getScopes().forEach(scope ->
                authorities.add(new SimpleGrantedAuthority(scope.getName())));
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return authorities;
    }
}
