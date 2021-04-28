package com.mph.model;

import java.io.Serializable;

public class Salary implements Serializable{

	private int basic;
	private double da;
	private double hra;
	private double pf;
	private double gross;
	private double net;
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salary(int basic, double da, double hra, double pf, double gross, double net) {
		super();
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		this.pf = pf;
		this.gross = gross;
		this.net = net;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public double getDa() {
		return da;
	}
	public void setDa(int basic) {
		this.da = 0.2*basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(int basic) {
		this.hra = 0.3*basic;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public double getGross() {
		return gross;
	}
	public void setGross(int basic ,double da,double hra) {
		this.gross = basic+da+hra;
	}
	public double getNet() {
		return net;
	}
	public void setNet(double gross,int pf) {
		this.net = gross-pf;
	}
	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", da=" + da + ", hra=" + hra + ", pf=" + pf + ", gross=" + gross + ", net="
				+ net + "]";
	}
	
	
}
