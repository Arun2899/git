import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    List<Pojo> l=Pojo.l;
    Service service=new Service();

    @Test
    void empIdInAscendingOrder() {
        List<Pojo> l1=l.stream()
                .sorted(
                        (Pojo a,Pojo b)->
                        {
                            if(a.getEmp_id()>b.getEmp_id())
                                return 1;
                            else if (a.getEmp_id()<b.getEmp_id())
                              return -1;
                            return 0;

                        })
                .toList();
        assertEquals(l1,service.empIdInAscendingOrder());

    }

    @Test
    void empWithMaximumSalary() {
        Pojo max=null;
        for(Pojo a:l)
        {
            if(a.getSalary()==50000d)
              max=a;
        }
       Optional<Pojo> maxEmp= Optional.of(max);
        assertEquals(maxEmp,service.empWithMaximumSalary());
    }

    @Test
    void secondSeniorEmployee() {
        Pojo secondSenior=null;
        for (Pojo a:l)
        {
            if(a.getDate_of_joining().equals(LocalDate.of(2015,07,14)))
                secondSenior=a;
        }
        assertEquals(secondSenior,service.secondSeniorEmployee());
    }

    @Test
    void empNameStartsWithGivenChar() {
        Pojo emp=null;
        for (Pojo a:l)
        {
            if(a.getEmp_name().startsWith("A"))
                emp=a;
        }
        List<Pojo> l2=service.empNameStartsWithGivenChar("A");
        assertEquals(emp,l2.get(0));
    }

    @Test
    void empWithSalaryRange() {
        List<Pojo> l1=new ArrayList<>();
        for (Pojo a:l)
        {
            if(a.getSalary()>=15000d && a.getSalary()<=30000d)
                l1.add(a);
        }
        assertEquals(l1,service.empWithSalaryRange(15000d,30000d));
    }

    @Test
    void empJoinedBetween() {
        List<Pojo> l1=new ArrayList<>();
        for(Pojo a:l)
        {
            if(a.getDate_of_joining().isAfter(LocalDate.of(2015,01,01)) && a.getDate_of_joining().isBefore(LocalDate.of(2020,01,01)))
                l1.add(a);
        }
        assertEquals(l1,service.empJoinedBetween(LocalDate.of(2015,01,01), LocalDate.of(2020,01,01)));
    }

    @Test
    void experience() {
        assertEquals(3,service.experience(3));
    }
}