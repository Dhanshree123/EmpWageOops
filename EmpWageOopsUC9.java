package com.blz.EmpWageOops;

public class EmpWageOopsUC9 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpWageOopsUC9(String company, int empRatePerHour, int numOfWorkingDays,
            int maxHoursPerMonth ){
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
	
	
	public void computeEmployeeWage(){
		
		int empHrs = 0;
		int totalEmpHrs =0;
		int totalWorkDays = 0;
		
		while(totalEmpHrs <= maxHoursPerMonth && totalWorkDays < numOfWorkingDays)
		{
			totalWorkDays++;
			int empCheck = (int)Math.floor(Math.random() *10)%3;
			switch((int)empCheck)
			{
			case IS_FULL_TIME:
				empHrs = 8;
			    break;
			case IS_PART_TIME:
				empHrs = 4;
				break;
			default:
				empHrs =0;
			}
			totalEmpHrs = totalEmpHrs + empHrs;
			
			System.out.println("Day#: "+ totalWorkDays+ " Emp Hr: "+empHrs);
		}
		totalEmpWage = totalEmpHrs * empRatePerHour;
	}
	
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+" is: "+totalEmpWage ;
	}
	public static void main(String[] args) {
		EmpWageOopsUC9 BigBazar = new EmpWageOopsUC9("BigBazaar",15,5,20);
		BigBazar.computeEmployeeWage();
		System.out.println(BigBazar);
		EmpWageOopsUC9 Vmart = new EmpWageOopsUC9("Vmart",10,2,14);
		Vmart.computeEmployeeWage();
		System.out.println(Vmart);
		EmpWageOopsUC9 Guess = new EmpWageOopsUC9("Guess",18,9,16);
		Guess.computeEmployeeWage();
		System.out.println(Guess);
	}
}
