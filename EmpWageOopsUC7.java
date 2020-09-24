package com.blz.EmpWageOops;

public class EmpWageOopsUC7 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;
	
	public static int computeEmployeeWage(){
		
		int totalEmpHrs =0;
		int totalEmpWage = 0;
		int totalWorkDays = 0;
		
		while(totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkDays < NUM_OF_WORKING_DAYS)
		{
			int empHrs = 0;
			int empWage = 0;
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
		totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Wage: "+ totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args) {
		computeEmployeeWage();
	}
}
