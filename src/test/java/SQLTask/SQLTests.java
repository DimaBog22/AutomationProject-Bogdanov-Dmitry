package SQLTask;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@Log4j2
public class SQLTests {

    String dbUrl = "jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07";
    @Test(priority = 1)
    public void createTable() throws Exception {

        Connection connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();

        String CustomersCreation = "CREATE TABLE Customers " +
                "(Id INTEGER not NULL, " +
                " Age INTEGER, " +
                " FirstName VARCHAR(255), " +
                " LastName VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(CustomersCreation);
        log.info("TABLE Customers is created");
        statement.executeUpdate("INSERT INTO Customers " + "VALUES (1, 21, 'Dmitry', 'Bogdanov')");
        log.info("first customer is created");


    }
    @Test(priority = 2)
    public void addAndRemoveUser1() throws Exception {
        // will add new user ('2', '25', 'Dmitras', 'Bogdanas')

        Connection connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Customers " + "VALUES (2, 25, 'Dmitras', 'Bogdanas')");

        Integer id = 0;
        Integer age = 0;
        String firstName = "";
        String lastName = "";
        boolean testResult = false;

        ResultSet resultSet = statement.executeQuery("select * from Customers");
        while (resultSet.next()) {
            id = resultSet.getInt("Id");
            age = resultSet.getInt("Age");
            firstName = resultSet.getString("FirstName");
            lastName = resultSet.getString("LastName");
            log.info(id + " " + age + " "  + " " + firstName + " "  + " " + lastName);
        }

        if (firstName.equals("Dmitras")) {
            testResult = true;
        }

        Assert.assertTrue(testResult);
        // remove user from Customers table
        statement.executeUpdate("delete from Customers where Id=2");

    }
    @Test(priority = 3)
    public void addAndRemoveUser2() throws Exception {
        // will add new user ('3', '23', 'Dmitryan', 'Bogdanyan')

        Connection connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Customers " + "VALUES (3, 23, 'Dmitryan', 'Bogdanyan')");

        Integer id = 0;
        Integer age = 0;
        String firstName = "";
        String lastName = "";
        boolean testResult = false;

        ResultSet resultSet = statement.executeQuery("select * from Customers");
        while (resultSet.next()) {
            id = resultSet.getInt("Id");
            age = resultSet.getInt("Age");
            firstName = resultSet.getString("FirstName");
            lastName = resultSet.getString("LastName");
            log.info(id + " " + age + " "  + " " + firstName + " "  + " " + lastName);
        }

        if (firstName.equals("Dmitryan")) {
            testResult = true;
        }

        Assert.assertTrue(testResult);
        // remove user from Customers table
        statement.executeUpdate("delete from Customers where Id=3");

    }
    @Test(priority = 4)
    public void updateUser() throws Exception {
        // from 1, 21, 'Dmitry', 'Bogdanov'
        // to   randomValue(from 5 to 10), 21, 'Dima', 'Bogdanov'

        Connection connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();

        String updateUser = "UPDATE Customers " +
                "SET Id = RAND()*(10-5)+5, firstName = 'Dima'";

        statement.executeUpdate(updateUser);

        Integer id = 0;
        Integer age = 0;
        String firstName = "";
        String lastName = "";
        boolean testResult = false;

        ResultSet resultSet = statement.executeQuery("select * from Customers");
        while (resultSet.next()) {
            id = resultSet.getInt("Id");
            age = resultSet.getInt("Age");
            firstName = resultSet.getString("FirstName");
            lastName = resultSet.getString("LastName");
            log.info(id + " " + age + " "  + " " + firstName + " "  + " " + lastName);
        }

        if (firstName.equals("Dima")) {
            testResult = true;
        }

        log.info("User is updated");
        Assert.assertTrue(testResult);

    }
    @Test(priority = 5)
    public void dropTable() throws Exception {

        Connection connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();
        // postcondition
        statement.executeUpdate("DROP TABLE Customers");
        log.info("TABLE Customers is removed");

    }

}
