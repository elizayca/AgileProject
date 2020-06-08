package test;
import java.sql.Connection;
import java.sql.DriverManager;

import controller.MainController;
import javafx.collections.ObservableList;
import library.Register;
import org.dbunit.DatabaseTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DbUnit extends DatabaseTestCase {
    public static final String TABLE_LOGIN = "project_sgk";
    public FlatXmlDataSet loadedDataSet;
    MainController controller;


    public DbUnit(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.cj.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/proje_sgk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "1794eliz");
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proje_sgk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1794eliz");
        return new DatabaseConnection(jdbcConnection);

    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        loadedDataSet = new FlatXmlDataSet(this.getClass().getClassLoader()
                .getResourceAsStream("dbunit_test.xml"));
        return loadedDataSet;
    }


  /*  protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.REFRESH;
    }

    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
    }*/



    public void testById() throws Exception {
          ObservableList<Register> list =controller.getRegistersList();

        //controller.insert(1,"eliz","Yilmaz","computer","ello@gmail.com", "12-01-2018","15.06.2020");

       // assertEquals(15, list.size());
    }


}