package com.blz.EmpWageOops;

public class EmpWageOopsUC8 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	
	public static int computeEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays,
			                                int maxHoursPerMonth ){
		
		int empHrs = 0;
		int totalEmpHrs =0;
		int totalEmpWage = 0;
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
		System.out.println("Total Emp Wage: "+ totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args) {
		computeEmployeeWage("BigBazaar",15,5,20);
		computeEmployeeWage("Vmart",10,2,14);
		computeEmployeeWage("Guess",18,9,16);
	}
}
