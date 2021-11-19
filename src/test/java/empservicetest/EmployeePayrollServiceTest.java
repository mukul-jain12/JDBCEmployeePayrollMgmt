package empservicetest;

import java.time.LocalDate;
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
    public void givenNewSalaryUpdated_ShouldSyncWithDBUsingStatement() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Raju", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Raju");
        Assert.assertTrue(result);
    }
	
	@Test
    public void givenNewSalaryUpdated_ShouldSyncWithDBUsingPreparedStatement() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalaryUsingPreparedStatement("Raju", 5000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Raju");
        Assert.assertTrue(result);
    }

    @Test
    public void givenDateRange_WhenRetrieved_ShouldMatchTheEmployeeCount() {
    	EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        LocalDate startDate = LocalDate.of(2015, 01, 01);
        LocalDate endDate = LocalDate.now();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollForDateRange(EmployeePayrollService.IOService.DB_IO, startDate, endDate);
        Assert.assertEquals(3, employeePayrollData.size());
    }
}
