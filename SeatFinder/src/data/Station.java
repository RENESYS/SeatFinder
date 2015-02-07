package data;

public class Station {
	private String name;
	private int num = 0;
	private int[] passenger = new int[20];
	private int[] stair = new int[4];
	private int [] bound = new int[20];
	
	
	
	
	public Station(String name, int num, int[] passenger, int[] stair, int[] bound) {
		this.name = name;
		this.num = num;
		this.passenger = passenger;
		this.stair = stair;
		this.bound = bound;
	}
	
	public Station(){
		this.name = "";
		this.num = 400;
		this.passenger = null;
		this.stair = null;
		this.bound = null;
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
