package empservicetest;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import model.EmployeePayrollData;
import service.EmployeePayrollService;

public class EmployeePayrollServiceTest {
	@Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(6, employeePayrollData.size());
    }
}
