package E09RetakeExam16december2020.bakery;

import E05RetakeExam18august2021.cafe.Employee;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public List<Employee> employees;
    public String name;
    public int capacity;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void add(Employee employee){
        if (employees.size() < capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        int oldest = Integer.MIN_VALUE;
        Employee oldestName = null;
        for (Employee employee: employees){
            int currentAge = employee.getAge();
            if (currentAge > oldest){
                oldest = currentAge;
                oldestName = employee;
            }
        }
        return oldestName;
    }

    public Employee getEmployee(String name){
        for (Employee employee:employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s%n",name));
        for (Employee employee:employees){
            sb.append(employee).append("\n");
        }
        return sb.toString().trim();
    }
}
