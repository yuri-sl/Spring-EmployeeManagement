package com.example.employee_management.Controller;

import com.example.employee_management.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    List<User> usersList = new ArrayList<>();
    int publicId = 0;
    public UserController(){
        usersList.add(User.builder()
                .id(publicId++)
                .firstName("Ichigo")
                        .lastName("Kurosaki")
                        .email("ichigo@gmail")
                .build());

    }
    public User findUserById(int id){
        for (User u:usersList){
            if( id == u.getId()){
                return u;
            }
        }
        return null;
    };
    //Página de formulário + tabela
    @GetMapping("/userForm")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("users",usersList);
        return "userForm";
    }
    // Recebe os dados do formulário, adiciona na lista e volta pra mesma página
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "userForm";
        }
        user.setId(publicId++);
        usersList.add(user);
        return "redirect:/users/userForm";
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return (ResponseEntity.ok(this.usersList)) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User foundU = findUserById(id);
        if (foundU != null){
            return(ResponseEntity.ok(foundU));
        }
        else{
            return(ResponseEntity.notFound().build());
        }
    };
}
