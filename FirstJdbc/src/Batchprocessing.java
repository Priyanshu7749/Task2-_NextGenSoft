import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Batchprocessing {
    private static final String url = "jdbc:postgresql://localhost:5432/FirstDatabase";
    private static final String username = "postgres";
    private static final String password = "priyanshu";

    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            while(true){
                System.out.print("Enter id:");
                int id = sc.nextInt();
                System.out.print("Enter the name:");
                String name = sc.next();
                System.out.println("Enter the age:");
                int age = sc.nextInt();
                System.out.print("Enter Y for add more Data or N for Exit:");
                String choice = sc.next();
                String query = String.format("INSERT INTO first VALUES(%d,'%s',%d)",id,name,age);
                st.addBatch(query);
//                if(!(choice.toUpperCase().equals("N") || choice.toUpperCase().equals("Y"))){

                    int check = 0;
                        Scanner scanner = new Scanner(System.in);
                    while (check == 0){

                        if(choice.toUpperCase().equals("Y") || choice.toUpperCase().equals("N")){
                            check = 1;
                        }else{
                            System.out.print("\n please insert valid  keyMark\n");
                            choice = sc.next();
                        }
                    }
//                }else{
                    if (choice.toUpperCase().equals("N")){

                        break;
                    }
//                }
            }
            int[] arr = st.executeBatch();
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    System.out.println("Query:"+i+"not exceuted.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
