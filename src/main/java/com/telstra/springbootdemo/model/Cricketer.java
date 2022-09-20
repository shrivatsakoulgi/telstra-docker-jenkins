package com.telstra.springbootdemo.model;

import java.io.Serializable;

public class Cricketer implements Serializable{

	private String name;
	private String shortName;
	private int runs;
	private int balls;
	private int fours;
	private int sixes;
	private double runRate;
	
	private static final long serialVersionUID=10L;
	
	public Cricketer() {
	
	}
	
	public Cricketer(String name, String shortName,int runs, int balls, 
			int fours, int sixes) {
		
		this.name = name;
		this.shortName=shortName;
		this.runs = runs;
		this.balls = balls;
		this.fours = fours;
		this.sixes = sixes;
		this.runRate = ((double)runs/(double)balls)*100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public double getRunRate() {
		return runRate;
	}

	public void setRunRate(double runRate) {
		this.runRate = runRate;
	}

	@Override
	public String toString() {
		return "Cricketer [name=" + name + ",shortName="+shortName+" runs=" + runs + ", balls=" + balls + ", fours=" + fours + ", sixes="
				+ sixes + ", runRate=" + runRate + "]";
	}

	

	
}
