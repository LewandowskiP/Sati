package ProductionManagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ProductionClasses.ProductionLine;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String rfid;
    private String login;
    private String password;
    private int jobPosition;
    private Timestamp regDate;
    private String employeeID;

    public Employee() {
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(int id, String firstName, String lastName, String rfid, String login, String password, int jobPosition, Timestamp regDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rfid = rfid;
        this.login = login;
        this.password = password;
        this.jobPosition = jobPosition;
        this.regDate = regDate;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(int jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
