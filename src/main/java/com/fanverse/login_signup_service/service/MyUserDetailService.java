package com.fanverse.login_signup_service.service;

import com.fanverse.login_signup_service.dao.User;
import com.fanverse.login_signup_service.dao.UserDetailsImpl;
import com.fanverse.login_signup_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<User> optionalUser = userRepository.findByUserName(username);
        if(optionalUser.isEmpty()) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User not found (404)");
        }
        User user = optionalUser.get();
        System.out.println(user.toString());
        return new UserDetailsImpl(user);
    }
}
