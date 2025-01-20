import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Inter {

    List<Pojo> empIdInAscendingOrder();
    Optional<Pojo> empWithMaximumSalary();
    Pojo secondSeniorEmployee();
    List<Pojo> empNameStartsWithGivenChar(String c);
    List<Pojo> empWithSalaryRange(double a,double b);
    List<Pojo> empJoinedBetween(LocalDate from,LocalDate to);
    int experience(int id);

}
