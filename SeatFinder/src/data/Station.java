package data;

public class Station {
	private int num = 0;
	private int[] passenger = new int[24];
	private int[] stair = new int[4];
	private int [] bound = new int[24];
	
	
	
	
	public Station(int num, int[] passenger, int[] stair, int[] bound) {
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
	public int[] getStair() {
		return stair;
	}
	public void setStair(int[] stair) {
		this.stair = stair;
	}
	public int[] getBound() {
		return bound;
	}
	public void setBound(int[] bound) {
		this.bound = bound;
	}
}
