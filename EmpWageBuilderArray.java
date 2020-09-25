package com.blz.EmpWageOops;

import java.util.*;
import java.lang.*;
public class EmpWageBuilderArray implements IComputeEmpWage{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private int dailyWage;
	private int numOfCompany = 0;
	//private CompanyEmpWage[] companyEmpWageArray;
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	public EmpWageBuilderArray() {
		companyEmpWageArray = new ArrayList<CompanyEmpWage>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
            int maxHoursPerMonth ) {
		companyEmpWageArray.add(new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth));
		numOfCompany++;
	}
/*
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
*/	
	
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
	public void computeEmpWage(){
	for(int i=0; i < numOfCompany;i++){
		companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i)));
		System.out.println(companyEmpWageArray.get(i));
	 }
	}
	
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
		
		int r = (int) Math.floor(((Math.random())*10)%2);
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("BigBazaar",15,5,20);
		empWageBuilder.addCompanyEmpWage("Vmart",10,2,14);
		empWageBuilder.addCompanyEmpWage("Guess",18,9,16);
		empWageBuilder.computeDailyWage(r);
		System.out.println("Daily Wage: "+empWageBuilder.dailyWage);
		empWageBuilder.computeEmpWage();
	}
}
