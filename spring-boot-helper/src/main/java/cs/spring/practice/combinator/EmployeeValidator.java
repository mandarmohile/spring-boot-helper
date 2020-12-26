package cs.spring.practice.combinator;

import static cs.spring.practice.combinator.ValidationResultEnum.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface EmployeeValidator extends Function<EmployeeBean, ValidationResultEnum> 
{
	static EmployeeValidator validateName()
	{
		return lEmpBean -> lEmpBean.getName().matches("^[\\p{L} .'-]+$") ? SUCCESS : INVALID_NAME;
	}
	
	static EmployeeValidator validateContactNo()
	{
		return lEmpBean -> lEmpBean.getContactNo().matches("\\d{10}") ? SUCCESS : INVALID_CONTACT_NO;
	}
	
	static EmployeeValidator validateSeniorEmployees()
	{
		return lEmpBean -> 
		Period.between(lEmpBean.getDateOfBirth(), LocalDate.now()).getYears() >= 50 ? SUCCESS : NOT_A_SENIOR_EMPLOYEE;
	}

	
	default EmployeeValidator and(EmployeeValidator pEmpVal)
	{
		return lEmpBean -> {
			ValidationResultEnum lValEnum = this.apply(lEmpBean);
			return lValEnum.equals(SUCCESS) ? pEmpVal.apply(lEmpBean) : lValEnum;
		};
	}
}
