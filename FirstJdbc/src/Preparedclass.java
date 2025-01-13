import org.postgresql.Driver;

import java.lang.ClassNotFoundException;
import java.sql.*;

public class Preparedclass {
    private static final String url ="jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";
    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection cn = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO first VALUES(?,?,?)";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1,4);
            ps.setString(2,"Prince");
            ps.setInt(3,52);

            int rs = ps.executeUpdate();
            if(rs>0){
                System.out.println("Data Inserted");
            }
            else{
                System.out.println("Data not Inserted");
            }

            String query2="select * from first";
           PreparedStatement ps2 = cn.prepareStatement(query2);
           ResultSet rs2 = ps2.executeQuery();
           while (rs2.next()){
               int id = rs2.getInt("id");
               String name = rs2.getString("name");
               int age = rs2.getInt("age");

               System.out.println("id:"+id);
               System.out.println("name:"+name);
               System.out.println("age:"+age);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
