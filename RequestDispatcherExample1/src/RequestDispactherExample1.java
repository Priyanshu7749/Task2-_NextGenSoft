import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class RequestDispactherExample1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        PrintWriter pr = resp.getWriter();
        if(email.equals("priyanshu@gmail.com") && password.equals("priyanshu")){
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req,resp);
        }
        else{
            resp.setContentType("text/html");
            pr.println("<h3>Email or Password is Incorrect</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req,resp);
        }
    }
}
