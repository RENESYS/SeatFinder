package data;

import java.util.ArrayList;

import manage.Define;

public class Station {
	private String name;
	private int num;
	private int[] getOn;
	private int[] getOff;
	private ArrayList<Integer> stair;
	private int [] bound;
	

	public Station(String name, int num, int[] getOn, int[] getOff, ArrayList<Integer> stair, int[] bound) {
		this.name = name;
		this.num = num;
		this.getOn = getOn;
		this.getOff = getOff;
		this.stair = stair;
		this.bound = bound;
	}
	
	public Station(){
		this.name = "a";
		this.num = 400;
		this.getOn = new int[Define.HOUR];
		this.getOff = new int[Define.HOUR];
		this.stair = new ArrayList<Integer>();
		this.bound = new int[Define.HOUR];
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getGetOn() {
		return getOn;
	}
	public void setGetOn(int[] getOn) {
		this.getOn = getOn;
	}
	public int[] getGetOff() {
		return getOff;
	}
	public void setGetOff(int[] getOff) {
		this.getOff = getOff;
	}

	public ArrayList<Integer> getStair() {
		return stair;
	}
	public void setStair(ArrayList<Integer> stair) {
		this.stair = stair;
	}
	public int[] getBound() {
		return bound;
	}
	public void setBound(int[] bound) {
		this.bound = bound;
	}
}
