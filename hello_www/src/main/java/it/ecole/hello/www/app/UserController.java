package it.ecole.hello.www.app;
import org.springframework.data.domain.Example;
import org.springframework.ui.Model;
import it.ecole.hello.www.model.User;
import it.ecole.hello.www.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    private UserRepository users;
    public UserController(UserRepository userRepository){
        users = userRepository;
    }

    @GetMapping("/")
    public String displayLogin(Model model)
    {
        return "login";

    }

    @GetMapping("/register")
    public String displayContacts(Model model) {
        model.addAttribute("registers", users.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String submitRegister(@Validated RegisterForm registerForm) {
        User user = new User(registerForm.getNom(), registerForm.getEmail(), registerForm.getPassword());
        //  Does the new user exist?
        List<User> userList = users.findAll(Example.of(user));
        System.out.println(userList);
        if (userList.isEmpty()) {
            //  user does not exist, we'll create it
            users.save(user);
        }
        else {
            //  user exists, we'll not create it twice
        }

        return "redirect:/";
    }

    @PostMapping("/")
    public String Login(@Validated User user, Model model){
        String email = user.getEmail();
        String password = user.getPassword();
        User user1 = users.findByEmailAndPassword(email, password);

        if(user1 != null){
            model.addAttribute("user", user1);
            System.out.println("User added to model: " + user1);
            return "welcome" ; // rediriger vers page d'acceuil
        }else{
            model.addAttribute("error", "Identifiant ou mot de passe incorrect.");
            return "login";
        }

    }

}

