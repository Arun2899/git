import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pojo {

    public int emp_id;
    public String emp_name;
    public LocalDate date_of_joining;
    public double salary;
    public static List<Pojo> l=new ArrayList<>();

    static {
        l= Arrays.asList(
                new Pojo(3,"Arun", LocalDate.parse("2021-11-04"),6000),
                new Pojo(1,"Veer", LocalDate.parse("2015-07-14"),10000),
                new Pojo(5,"Nagu", LocalDate.parse("2018-05-17"),16000),
                new Pojo(2,"Mani", LocalDate.parse("2023-01-10"),50000),
                new Pojo(4,"Kumar", LocalDate.parse("2013-06-23"),5000)
        );
    }


    public Pojo() {
    }

    public Pojo(int emp_id, String emp_name, LocalDate date_of_joining, double salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.date_of_joining = date_of_joining;
        this.salary = salary;
    }


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public LocalDate getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(LocalDate date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", date_of_joining=" + date_of_joining +
                ", salary=" + salary +
                '}';
    }
}
