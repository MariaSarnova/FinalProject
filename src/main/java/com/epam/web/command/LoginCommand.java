package com.epam.web.command;

import com.epam.web.entity.User;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command{

    private final UserService userService;

    public LoginCommand(UserService userService){
        this.userService=userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        Optional<User> user =userService.login(username,password);
        user.ifPresent(u->request.getSession().setAttribute("user",u));
        return CommandResult.redirect("/FinalProject/controller?command=mainPage");
    }
}
