import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.loadFromFile();

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1.Add 2.View 3.Update Salary 4.Delete 5.Search Dept 6.Save 0.Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        String id = sc.next();
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Dept: ");
                        String dept = sc.next();
                        System.out.print("Position: ");
                        String pos = sc.next();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        manager.addEmployee(new Employee(id, name, dept, pos, sal));
                        break;

                    case 2:
                        manager.viewEmployees();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        String uid = sc.next();
                        System.out.print("New Salary: ");
                        double newSal = sc.nextDouble();
                        manager.updateSalary(uid, newSal);
                        break;

                    case 4:
                        System.out.print("ID: ");
                        manager.deleteEmployee(sc.next());
                        break;

                    case 5:
                        System.out.print("Department: ");
                        manager.searchByDepartment(sc.next());
                        break;

                    case 6:
                        manager.saveToFile();
                        break;

                    case 0:
                        manager.saveToFile();
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("⚠️ Invalid input! Please enter numbers only.");
                sc.nextLine(); 
            }
        }
    }
}
