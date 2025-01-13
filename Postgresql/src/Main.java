import java.sql.*;

public class Main {
    private static final String url ="jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username ="postgres";
    private static final String password = "priyanshu";

    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            String query = "select * from first";
            ResultSet rs = st.executeQuery(query);
            System.out.println(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}