package service;

import java.util.List;
import model.EmployeePayrollData;

public class EmployeePayrollService {
	EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();

	public enum IOService {DB_IO}
	private List<EmployeePayrollData> employeePayrollList;

	public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
		if(ioService.equals(IOService.DB_IO)) {
			this.employeePayrollList = employeePayrollDBService.readData();
		}
		return this.employeePayrollList;
	}
}
