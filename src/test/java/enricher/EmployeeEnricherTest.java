package enricher;

import com.integraltech.enricher.EmployeeEnricher;
import com.integraltech.model.Employee;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jqueen on 10/06/2016.
 */
public class EmployeeEnricherTest {

    @Test
    public void simpleTest(){
        Employee employee = new Employee();
        EmployeeEnricher enricher = new EmployeeEnricher();
        employee = enricher.enrich(employee);

        assertEquals("IntegralTech", employee.getOrganisation());
    }


}
