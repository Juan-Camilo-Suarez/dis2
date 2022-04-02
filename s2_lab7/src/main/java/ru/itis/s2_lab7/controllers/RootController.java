package ru.itis.s2_lab7.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.s2_lab7.dto.UserDto;
import ru.itis.s2_lab7.models.User;
import ru.itis.s2_lab7.models.UserData;
import ru.itis.s2_lab7.repositories.UserRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class RootController {


    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }

    @GetMapping(path = "/save")
    public String save( Model model) {
        User user = new User();
        user.setName(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        user.setPassword("122`12`12");

        UserData userData = new UserData();
        userData.setPassport("988790870");
        userData.setEmail("qqwqw@kkk.com");
        user.setUserData(userData);

        //userData = repository.save(userData);

        user = repository.save(user);

        model.addAttribute("user", user);

        return "result";
    }


    /*
    <form method="post"  action="/save">
        <div><label for="username">username:</label><input type="text" name="userName" id="username"></div>
        <div><label for="password">passsword:</label><input type="text" name="password" id="password"></div>
        <div><label for="passport">passport:</label><input type="text" name="passport" id="passport"></div>
        <div><label for="email">email:</label><input type="text" name="email" id="email"></div>
        <div><input type="submit"></div>
    </form>
        На стороне контроллера принимаем данные формы через класс UserDto
     */
    @PostMapping(path = "/save")
    public String save(UserDto userDto, Model model) {
        System.out.println(userDto);

        User user = new User();
        user.setName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        UserData userData = new UserData();
        userData.setPassport(userDto.getPassport());
        userData.setEmail(userDto.getEmail());

        user.setUserData(userData);

        // При использовании атрибута cascade = CascadeType.ALL отделное сохраниение userData не требуется
        //userData = repository.save(userData);

        user = repository.save(user);

        model.addAttribute("user", user);

        return "result";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getAllUsers(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
