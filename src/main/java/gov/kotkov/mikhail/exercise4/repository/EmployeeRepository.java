package gov.kotkov.mikhail.exercise4.repository;

import org.springframework.data.repository.CrudRepository;

import gov.kotkov.mikhail.exercise4.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
