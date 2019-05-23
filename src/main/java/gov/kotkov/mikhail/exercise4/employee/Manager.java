package gov.kotkov.mikhail.exercise4.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import gov.kotkov.mikhail.exercise4.util.Job;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

	public Manager() {
		super();
		this.setJob(Job.MANAGER);
	}
}
