package com.rental.securityjwtservice.service;

import com.rental.securityjwtservice.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface RentalUserService extends UserDetailsService {
}
