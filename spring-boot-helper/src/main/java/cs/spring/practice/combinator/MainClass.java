package cs.spring.practice.combinator;

import static cs.spring.practice.combinator.EmployeeValidator.*;

import java.time.LocalDate;

public class MainClass {
	
	public static void main(String[] args)
	{
		EmployeeBean lEmpBean = new EmployeeBean();
		lEmpBean.setName("John Doe");
		lEmpBean.setContactNo("9999999999");
		lEmpBean.setDateOfBirth(LocalDate.of(1970, 01, 01));
		
		ValidationResultEnum lValEnum = validateName()
		.and(validateContactNo())
		.and(validateSeniorEmployees())
		.apply(lEmpBean);
		
		System.out.println(lValEnum.name());
	}

}
