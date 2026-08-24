abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double fixed;

    FullTime(String name, int id, double fixed) {
        super(name, id);
        this.fixed = fixed;
    }

    @Override
    double monthlySalary() {
        return fixed;
    }
}

class PartTime extends Employee {
    double hours;
    double rate;

    PartTime(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTime("Luffy", 101, 50000),
                new PartTime("Ichigo", 102, 80, 300),
                new Intern("Yhwach", 103, 15000),
                new FullTime("Goku", 104, 60000)
        };
        double total = 0;
        for (Employee e : employees) {
            double salary = e.monthlySalary();
            System.out.println(
                    e.name + " (ID: " + e.id + ") Salary: " + salary);
            if (e instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }
            total += salary;
        }
        System.out.println("Total Payroll: " + total);
    }
}