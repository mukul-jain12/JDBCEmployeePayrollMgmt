package empservicetest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.EmployeePayrollData;
import service.EmployeePayrollService;

public class EmployeePayrollServiceTest {
	@Test
    public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(6, employeePayrollData.size());
    }
	
	@Test
    public void givenNewSalaryUpdated_ShouldSyncWithDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Raju", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Raju");
        Assert.assertTrue(result);
    }
}
