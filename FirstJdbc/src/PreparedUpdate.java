import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedUpdate {
    private static final String url = "jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";

    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE first SET age=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,25);
            ps.setInt(2,2);
            int result = ps.executeUpdate();
            if(result>0){
                System.out.println("Data updated using Prepared.");
            }
            else{
                System.out.println("Data not uploaded using Prepared");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
