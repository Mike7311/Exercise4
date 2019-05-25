package gov.kotkov.mikhail.exercise4.employeeService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import gov.kotkov.mikhail.exercise4.config.DataConfig;
import gov.kotkov.mikhail.exercise4.employee.Employee;
import gov.kotkov.mikhail.exercise4.employee.Manager;
import gov.kotkov.mikhail.exercise4.employee.Programmer;
import gov.kotkov.mikhail.exercise4.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  classes = { DataConfig.class }, 
  loader = AnnotationConfigContextLoader.class)
@Transactional
public class EmployeeRepositoryTest {
     
    @Resource
    private EmployeeRepository employeeRepository;
    
    private Employee testEmployee;
    
    @Before
    public void setup() {
    	testEmployee = new Programmer();
    	testEmployee.setFirstName("John");
    	testEmployee.setLastName("Bill");
    	testEmployee.setWageRate(new BigDecimal(500));
    	testEmployee.setActualWorkhours(150);
    }
    
    @Test
    public void testFind() {
    	employeeRepository.save(testEmployee);
    	assertEquals(testEmployee, employeeRepository.findOne(testEmployee.getId()));
    }
    
    @Test
    public void testDelete() {
    	employeeRepository.save(testEmployee);
    	employeeRepository.delete(testEmployee);
    	assertFalse(employeeRepository.exists(testEmployee.getId()));
    }
    
    @Test
    public void testSaveMultiple() {
    	Employee testEmployee2  = new Manager();
    	testEmployee2.setFirstName("Ruslan");
    	testEmployee2.setLastName("Bashirov");
    	testEmployee2.setWageRate(new BigDecimal(400));
    	testEmployee2.setActualWorkhours(160);
    	List<Employee> employees = Arrays.asList(testEmployee, testEmployee2);
    	employeeRepository.save(employees);
    	List<Employee> result = employeeRepository.findAll(Arrays.asList(testEmployee.getId(), testEmployee2.getId()));
    	assertEquals(employees, result);
    }
    
}