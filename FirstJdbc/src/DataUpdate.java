import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataUpdate {
    private static final String url ="jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";
    public static void main(String[] args){

        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age:");
        int age = sc.nextInt();
        System.out.println("Enter the id you want to update:");
        int id = sc.nextInt();
        try {
            Connection cn = DriverManager.getConnection(url,username,password);
            Statement st = cn.createStatement();
            String query = String.format("UPDATE first SET age=%d where id=%d",age,id);
            int result =st.executeUpdate(query);
            if(result>0){
                System.out.println("Data Updated");
            }
            else{
                System.out.println("Data not updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
