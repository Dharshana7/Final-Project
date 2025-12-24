import java.io.*;
import java.util.*;

public class EmployeeManager {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private HashMap<String, Employee> employeeMap = new HashMap<>();
    private final String FILE_NAME = "employees.dat";

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        employeeMap.put(emp.getId(), emp);
        System.out.println("Employee added successfully.");
    }

    public void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employeeList.forEach(System.out::println);
    }

    public void updateSalary(String id, double salary) {
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            emp.setSalary(salary);
            System.out.println("Salary updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(String id) {
        Employee emp = employeeMap.remove(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void searchByDepartment(String dept) {
        employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .forEach(System.out::println);
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employeeList);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("File save error.");
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employeeList = (ArrayList<Employee>) ois.readObject();
            employeeMap.clear();
            for (Employee e : employeeList) {
                employeeMap.put(e.getId(), e);
            }
            System.out.println("Data loaded from file.");
        } catch (Exception e) {
            System.out.println("No existing data found.");
        }
    }
}
