package gov.kotkov.mikhail.exercise4.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.kotkov.mikhail.exercise4.employee.Employee;
import gov.kotkov.mikhail.exercise4.repository.EmployeeRepository;

@Transactional(readOnly = true)
@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Transactional
	public Employee save(@Valid Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee find(long employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	@Transactional
	public void delete(Employee employeeToDelete) {
		employeeRepository.delete(employeeToDelete);
	}
	
}