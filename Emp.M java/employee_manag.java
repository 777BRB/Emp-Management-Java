import java.util.Scanner;

class Employee {
   private String name;
   private int age;
   private String department;
   private double salary;
   
   public Employee(String name, int age, String department, double salary) {
      this.name = name;
      this.age = age;
      this.department = department;
      this.salary = salary;
   }
   
   public String getName() {
      return name;
   }
   
   public int getAge() {
      return age;
   }
   
   public String getDepartment() {
      return department;
   }
   
   public double getSalary() {
      return salary;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public void setAge(int age) {
      this.age = age;
   }
   
   public void setDepartment(String department) {
      this.department = department;
   }
   
   public void setSalary(double salary) {
      this.salary = salary;
   }
}

class EmployeeManagementSystem {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Employee[] employees = new Employee[10];
      int employeeCount = 0;
      
      while (true) {
         System.out.println("Enter 1 to add a new employee.");
         System.out.println("Enter 2 to display all employees.");
         System.out.println("Enter 3 to update an employee.");
         System.out.println("Enter 4 to delete an employee.");
         System.out.println("Enter 5 to exit.");
         int choice = input.nextInt();
         
         if (choice == 1) {
            System.out.print("Enter employee name: ");
            String name = input.next();
            System.out.print("Enter employee age: ");
            int age = input.nextInt();
            System.out.print("Enter employee department: ");
            String department = input.next();
            System.out.print("Enter employee salary: ");
            double salary = input.nextDouble();
            
            employees[employeeCount] = new Employee(name, age, department, salary);
            employeeCount++;
         }
         else if (choice == 2) {
            for (int i = 0; i < employeeCount; i++) {
               System.out.println("Name: " + employees[i].getName());
               System.out.println("Age: " + employees[i].getAge());
               System.out.println("Department: " + employees[i].getDepartment());
               System.out.println("Salary: " + employees[i].getSalary());
               System.out.println();
            }
         }
         else if (choice == 3) {
            System.out.print("Enter the name of the employee to update: ");
            String nameToUpdate = input.next();
            
            boolean foundEmployee = false;
            for (int i = 0; i < employeeCount; i++) {
               if (employees[i].getName().equals(nameToUpdate)) {
                  foundEmployee = true;
                  
                  System.out.println("Enter new information for employee " + nameToUpdate + ":");
                  System.out.print("Enter employee name: ");
                  String name = input.next();
                  System.out.print("Enter employee age: ");
                  int age = input.nextInt();
                  System.out.print("Enter employee department: ");
                  String department = input.next();
                  System.out.print("Enter employee salary: ");
                  double salary = input.nextDouble();
                  
                  employees[i].setName(name);
                  employees[i].setAge(age);
                  employees[i].setDepartment(department);
                  employees[i].setSalary(salary);
                  
                  System.out.println("Employee information updated successfully.");
                  break;
               }
            }
            
            if (!foundEmployee) {
               System.out.println("Employee not found.");
            }
        
         } else if (choice == 4) {
            System.out.print("Enter the name of the employee to delete: ");
            String nameToDelete = input.next();
            
            boolean foundEmployee = false;
            for (int i = 0; i < employeeCount; i++) {
               if (employees[i].getName().equals(nameToDelete)) {
                  foundEmployee = true;
                  
                  // Shift all elements left by 1 starting from index i
                  for (int j = i; j < employeeCount - 1; j++) {
                     employees[j] = employees[j + 1];
                  }
                  
                  employees[employeeCount - 1] = null;
                  employeeCount--;
                  
                  System.out.println("Employee deleted successfully.");
                  break;
               }
            }
            
            if (!foundEmployee) {
               System.out.println("Employee not found.");
            }
         }
         else if (choice == 5) {
            System.out.println("Exiting the program.");
            break;
         }
         else {
            System.out.println("Invalid choice. Please try again.");
         }
      }
      
      input.close();
   }
}