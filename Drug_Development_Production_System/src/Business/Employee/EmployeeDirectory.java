/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeDirectory;

    public EmployeeDirectory() {
        employeeDirectory = new ArrayList<>();
    }

    public Employee createEmployee() {
        Employee employee = new Employee();
        employeeDirectory.add(employee);
        return employee;
    }

    public ArrayList<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void deactivateEmployee(Employee employee) {
        employeeDirectory.remove(employee);
    }

}
