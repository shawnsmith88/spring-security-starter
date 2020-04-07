package com.ss.example.springsecuritystarter.Controllers;

import com.ss.example.springsecuritystarter.Exceptions.UsernameExistsException;
import com.ss.example.springsecuritystarter.Models.DTOs.UserDto;
import com.ss.example.springsecuritystarter.Models.User;
import com.ss.example.springsecuritystarter.Repositories.UserRepository;
import com.ss.example.springsecuritystarter.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BaseController {
    @Autowired
    IUserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String getSignup (Model model){
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup (@ModelAttribute("user") @Valid UserDto userDto, BindingResult result){
        User registering=new User();
        if (!result.hasErrors()){
            registering=createNewUserAccount(userDto,result);
            if (registering==null){
                return "redirect:/signup?error=duplicateusername";
            }
        }
        return "redirect:/loggedin";
    }

    @GetMapping("/loggedin")
    public String loggedIn(Model model, Authentication authentication){
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        User user=userRepository.findByUsername(userDetails.getUsername());
        model.addAttribute("name",user.getUsername());
        return "loggedIn";
    }

    public User createNewUserAccount(UserDto userDto, BindingResult result){
        User registering=null;
        try {
            registering = userService.registerNewUserAccount(userDto);
        }catch(UsernameExistsException e){
            System.out.println(e.getMessage());
            return null;
        }
        return registering;
    }
}
