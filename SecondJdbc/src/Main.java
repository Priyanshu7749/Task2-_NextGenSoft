
import java.lang.ClassNotFoundException;
import java.sql.*;

public class Main {
    private static final String url = "jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try{
            Connection cn = DriverManager.getConnection(url,username,password);
            Statement st = cn.createStatement();
            String query = "select * from first";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id);
                System.out.println(name);
                System.out.println(age);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}