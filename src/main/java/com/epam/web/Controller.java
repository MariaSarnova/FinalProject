package com.epam.web;

import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;
import com.epam.web.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("index.jsp").forward(request,response);
        String command = request.getParameter("command");
        Command action=CommandFactory.create(command);
        String page;
        boolean isRedirect=false;
        try{
            CommandResult result=action.execute(request,response);
            page=result.getPage();
            isRedirect=result.isRedirect();
        }catch (Exception e){
            request.setAttribute("errorMessage", e.getMessage());
            page="/error.jsp";
        }
        if(!isRedirect){
            forward(request,response,page);
        }else{
            response.sendRedirect(page);
        }
    }

    private void forward(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
