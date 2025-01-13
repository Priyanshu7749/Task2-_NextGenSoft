package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        if (email.equals("priyanshu@gmail.com") && password.equals("priyanshu")){
            pr.println("Hii Priyanshu ");
        }
        else{
            pr.println("Enter Proper Details.");
        }

    }
}
