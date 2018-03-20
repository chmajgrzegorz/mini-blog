package pl.grzegorzchmaj.blog.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.grzegorzchmaj.blog.model.entities.User;
import pl.grzegorzchmaj.blog.model.forms.LoginForm;
import pl.grzegorzchmaj.blog.model.forms.RegisterForm;
import pl.grzegorzchmaj.blog.repositories.UserRepository;
import pl.grzegorzchmaj.blog.services.UserSessionService;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserSessionService userSessionService;
    private ModelMapper modelMapper;


    @Autowired
    public UserController(UserRepository userRepository, UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterForm registerForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }

        User user = modelMapper.map(registerForm, User.class);
        userRepository.save(user);

        return "index";

    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    public String loginUser(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model){
        boolean logged = userSessionService.loginUser(loginForm.getUsername(), loginForm.getPassword());
        if(!logged){
            bindingResult.reject("username", null, "Uzytkownik nie istnieje");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("loggedUser", logged);
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
}
