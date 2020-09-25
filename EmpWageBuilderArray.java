package com.blz.EmpWageOops;

import java.util.*;
import java.lang.*;
public class EmpWageBuilderArray implements IComputeEmpWage{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	//private int dailyWage;
	private int numOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyEmpWageMap;
	//private CompanyEmpWage[] companyEmpWageArray;
//	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	public EmpWageBuilderArray() {
		companyEmpWageList = new LinkedList<>();
		companyEmpWageMap = new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
            int maxHoursPerMonth ) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyEmpWageMap.put(company,companyEmpWage);
		//numOfCompany++;
	}
/*
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
*/	
	
	public void computeEmpWage()
	{
		for(int i=0;i<companyEmpWageList.size();i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	
	@Override
	
	public int getTotalWage(String company) {
		return companyEmpWageMap.get(company).totalEmpWage;
		}
	/*
	public void computeDailyWage(int type) {
		int wage = 0;
		int emphours = 0;
		if(type == 0) {
			emphours = 4;
		}
		else
			emphours = 8;
		
		for(int i=0;i<numOfCompany ;i++) {
			wage = wage + companyEmpWageArray.get(i).empRatePerHour*emphours;
		}
		dailyWage = wage;
	}
	*/

	
	private int computeEmpWage(CompanyEmpWage companyEmpWage){
		
		int empHrs = 0;
		int totalEmpHrs =0;
		int totalWorkDays = 0;
		
		while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkDays < companyEmpWage.numOfWorkingDays)
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
		int totalEmpWage = totalEmpHrs * companyEmpWage.empRatePerHour;
		return totalEmpHrs*companyEmpWage.empRatePerHour;
	}
	
	
	public static void main(String[] args) {
		
		
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("BigBazaar",15,5,20);
		empWageBuilder.addCompanyEmpWage("Vmart",10,2,14);
		empWageBuilder.addCompanyEmpWage("Guess",18,9,16);
		
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for BigBazaar: "+empWageBuilder.getTotalWage("BigBazaar"));
		System.out.println("Total Wage for Vmart: "+empWageBuilder.getTotalWage("Vmart"));
		System.out.println("Total Wage for Guess: "+empWageBuilder.getTotalWage("Guess"));
	}
}
