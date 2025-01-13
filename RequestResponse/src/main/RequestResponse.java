package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.management.Query;
import java.lang.ClassNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/submit")
public class RequestResponse extends HttpServlet {
    private static final String url = "jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            String query = String.format("INSERT INTO first VALUES(%d,'%s',%d)",id,name,age);
            int result = st.executeUpdate(query);
            if(result>0){
                pr.println("Data inserted");
            }
            else {
                pr.println("Data not inserted");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
