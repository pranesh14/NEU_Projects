/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class UserAccount {

    private Employee employee;
    private String username;
    private String password;
    private Role Role;
    private ArrayList<String> passwordHistory;
    private WorkQueue workQueue;

    public UserAccount() {
        employee = new Employee();
        passwordHistory = new ArrayList<>();
        workQueue = new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ArrayList<String> getPasswordHistory() {
        return passwordHistory;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.passwordHistory.add(password);
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }
    
    
    public String toString(){
        return this.employee.getName();
    }
    
}
