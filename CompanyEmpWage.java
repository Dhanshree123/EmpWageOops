package com.blz.EmpWageOops;

public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public  int totalEmpWage;
	
	public CompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.maxHoursPerMonth=maxHoursPerMonth;
		this.numOfWorkingDays=numOfWorkingDays;
	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
   public String toString() {
	   return "Total Emp wage for company: "+company+ " is:"+totalEmpWage;
	   
   }
}