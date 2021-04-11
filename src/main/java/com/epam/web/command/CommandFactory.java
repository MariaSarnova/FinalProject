package com.epam.web.command;

import com.epam.web.service.UserService;

public class CommandFactory {

    public static Command create(String type){
        switch (type){
            case "login":
                return new LoginCommand(new UserService());
            case "mainPage":
                return new ShowPageCommand("/WEB-INF/view/main.jsp");
            default:
                throw new IllegalArgumentException("Unknown type of command:" + type);
        }
    }
}
