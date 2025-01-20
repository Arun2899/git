import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public class Service implements Inter{



    List<Pojo> list=Pojo.l;



    public List<Pojo> empIdInAscendingOrder() {

        List<Pojo> listInAscendingOrder=list.stream()
                .sorted(
                        (a,b)->{
                            return a.getEmp_id()-b.getEmp_id();
                        })
                .toList();

        return listInAscendingOrder;
    }

    public Optional<Pojo> empWithMaximumSalary() {
        Optional<Pojo> max=list.stream()
                .max((Pojo a,Pojo b)->
                        {
                            if(a.getSalary()> b.getSalary())
                                return 1;
                            else if (a.getSalary()< b.getSalary())
                                return -1;
                            return 0;

                        });

        return max;
    }

    public Pojo secondSeniorEmployee() {
        List<Pojo> listInOrderBasedOnDoj=list.stream()
                .sorted(
                        (Pojo a,Pojo b)->
                        {
                            if(a.getDate_of_joining().isAfter(b.getDate_of_joining()))
                                return 1;
                            else if (b.getDate_of_joining().isAfter(a.getDate_of_joining()))
                               return -1;
                            return 0;

                        })
                .toList();
        Pojo secSenior=listInOrderBasedOnDoj.get(1);

        return secSenior;
    }

    public List<Pojo> empNameStartsWithGivenChar(String c) {

         if(c==null)
             return List.of();

        List<Pojo> empNameStartsWithChar=list.stream()
                .filter(a->a.getEmp_name().startsWith(c))
                .toList();

        return empNameStartsWithChar;
    }

    public List<Pojo> empWithSalaryRange(double a, double b) {

        List<Pojo> empWithRange=list.stream()
                .filter((Pojo x)->
                {
                   return x.getSalary()>=a && x.getSalary()<=b;
                })
                .toList();


        return empWithRange;
    }

    public List<Pojo> empJoinedBetween(LocalDate from, LocalDate to) {

        List<Pojo> empJoinedBetween=list.stream()
                .filter((Pojo x)->
                {
                    return x.getDate_of_joining().isAfter(from) && x.getDate_of_joining().isBefore(to);
                })
                .toList();
        return empJoinedBetween;
    }

    public int experience(int id) {

        List<Pojo> l1=list.stream()
                .filter(x->x.getEmp_id()==id)
                .distinct()
                .toList();

        Pojo emp=l1.get(0);

        Period period=Period.between(emp.getDate_of_joining(),LocalDate.now());

        int exp=period.getYears();

        return exp;
    }
}
