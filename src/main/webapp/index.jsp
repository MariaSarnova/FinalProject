<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="static/style.css" />
</head>
<html>
    <body>

        <div class="bg-image"></div>
        <div class="container">
            <form action="/FinalProject/controller?command=login" method="POST">
                <h1>FlowersAuction</h1>
                <h2>Sign In</h2>
                <!--input type="hidden" name="command" value="login"-->
                <input type="text" name="username" placeholder="Username" />

                <input type="password" name="password" placeholder="Password" />

                <input type="submit" value="login" />
            </form>


        </div>
    </body>
</html>
