import javax.swing.*;
import java.sql.*;
import java.lang.ClassNotFoundException;

public class DataInsert {
    private static final String url="jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username="postgres";
    private static final String password="priyanshu";

    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection cn = DriverManager.getConnection(url,username,password);
            Statement st = cn.createStatement();
            String query = String.format("Insert INTO first VALUES(%o,'%s',%d)",2,"yash",25);
            int result = st.executeUpdate(query);

            if(result>0){
                System.out.println("Data inserted");
            }
            else{
                System.out.println("Data not inserted");
            }

            String query2 = "select * from first";
            ResultSet result2 = st.executeQuery(query2);
            while (result2.next()){
                int id = result2.getInt("id");
                String name = result2.getString("name");
                int age = result2.getInt("age");

                System.out.println("ID:"+id);
                System.out.println("Name:"+name);
                System.out.println("Age:"+age);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
