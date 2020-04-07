package com.ss.example.springsecuritystarter.Services;


import com.ss.example.springsecuritystarter.Exceptions.UsernameExistsException;
import com.ss.example.springsecuritystarter.Models.DTOs.UserDto;
import com.ss.example.springsecuritystarter.Models.User;
import com.ss.example.springsecuritystarter.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userdto) throws UsernameExistsException {
        if (usernameExists(userdto.getUsername())){
            throw new UsernameExistsException("there was an account with this username: " + userdto.getUsername());
        }
        User register=new User();
        register.setUsername(userdto.getUsername());
        register.setPassword(passwordEncoder.encode(userdto.getPassword()));
        register.addRole("user");
        return userRepository.save(register);

    }
    private boolean usernameExists(String username){
        User user=userRepository.findByUsername(username);
        if (user==null){
            return false;
        } else {
            return true;
        }
    }
}
