package data;

import java.util.ArrayList;

import manage.Define;

public class Station {
	private int num = 0;
	private int[] passenger = new int[Define.HOUR];
	private ArrayList<Integer> stair = new ArrayList<Integer>();
	private int [] bound = new int[Define.HOUR];
	
	
	
	
	public Station(int num, int[] passenger, ArrayList<Integer> stair, int[] bound) {
		this.num = num;
		this.passenger = passenger;
		this.stair = stair;
		this.bound = bound;
	}
	
	public Station(){
		this.num = 400;
		this.passenger = null;
		this.stair = null;
		this.bound = null;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getPassenger() {
		return passenger;
	}
	public void setPassenger(int[] passenger) {
		this.passenger = passenger;
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
