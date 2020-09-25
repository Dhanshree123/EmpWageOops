package com.blz.EmpWageOops;

public class EmpWageBuilderArray {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public EmpWageBuilderArray() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}
	
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
            int maxHoursPerMonth ) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		numOfCompany++;
	}

	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public void computeEmpWage(){
	for(int i=0; i < numOfCompany;i++){
		companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
		System.out.println(companyEmpWageArray[i]);
	 }
	}
	
	private int computeEmpWage(CompanyEmpWage companyEmpWage){
		
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
		return totalEmpHrs*companyEmpWage.empRatePerHour;
	}
	
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+" is: "+totalEmpWage ;
	}
	public static void main(String[] args) {
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("BigBazaar",15,5,20);
		empWageBuilder.addCompanyEmpWage("Vmart",10,2,14);
		empWageBuilder.addCompanyEmpWage("Guess",18,9,16);
		empWageBuilder.computeEmpWage();
	}
}
