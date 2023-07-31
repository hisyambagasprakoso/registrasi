package com.cybertrend.registrasi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// import com.cybertrend.registrasi.config.CaptchaGenerator;
// import com.cybertrend.registrasi.model.CaptchaSettings;
import com.cybertrend.registrasi.model.User;
import com.cybertrend.registrasi.repository.UserRepository;
import com.cybertrend.registrasi.serviceimpl.EmailServiceImpl;
import com.cybertrend.registrasi.serviceimpl.ReCaptchaValidationService;

// import cn.apiclub.captcha.Captcha;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
	private ReCaptchaValidationService validator;

   @GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

    @GetMapping("/login2")
    public String showLoginForm(User user) {
        return "login2";
    }

    @PostMapping("/login2")
    public String processLogin(@ModelAttribute User user, Model model, @RequestParam(required=true,name="g-recaptcha-response") String captcha,
    BindingResult bindingResult) 
    {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if(validator.validateCaptcha(captcha)){
                model.addAttribute("user", user.getEmail());
                return "users";
        }
        return "users";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        try {
            userRepository.save(user);
            emailServiceImpl.sendSimpleMail(user);
        } catch (Exception e) {
            // TODO: handle exception
            return "register_failed";
        }
        return "register_success";
    }

    @GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
    
}
