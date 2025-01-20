import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        Service service=new Service();
        System.out.println(service.empIdInAscendingOrder());
    }
}
