package gov.kotkov.mikhail.exercise4.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import gov.kotkov.mikhail.exercise4.util.Job;

@Entity
@DiscriminatorValue("Programmer")
public class Programmer extends Employee {

	public Programmer() {
		super();
		this.setJob(Job.PROGRAMMER);
	}

}
