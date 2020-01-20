package JDBC_Practice;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.*;
public class JDBC_TestCases {

    Connection connection ;
    Statement statement;
    @BeforeMethod
    public void setUp(){
        String url = "jdbc:oracle:thin:@54.166.75.182:1521:xe";
        String username ="hr";
        String password = "hr";
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }catch(Exception e){
        }
    }
    @Test(description = "Verify that Seyfo's salary is greater than Hakan's salary")
    public void Test1() throws SQLException{
        int seyfoSalary = 0,
                hakanSalary = 0;
        String query = "select * from testers";
        ResultSet result =  statement.executeQuery(query);
        while(result.next()){
            String name = result.getString(2);
            int salary = result.getInt(3);
            if(name.equals("Seyfo")){
                seyfoSalary   =  salary;
            }
            if(name.equals("Hakan")){
                hakanSalary   =  salary;
            }
        }
        System.out.println("Seyfo's salary: "+seyfoSalary);
        System.out.println("Hakan's salary: "+hakanSalary);
        Assert.assertTrue(seyfoSalary > hakanSalary);

        sleepForNow(5);
    }
    public void sleepForNow(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch(Exception ne){}
    }
}