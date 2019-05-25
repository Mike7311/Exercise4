package gov.kotkov.mikhail.exercise4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.kotkov.mikhail.exercise4.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
