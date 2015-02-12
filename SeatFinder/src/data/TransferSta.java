package data;

import java.util.ArrayList;

public class TransferSta extends Station{
	private ArrayList<Integer>  stair;
	private int transferPassenger;
	
	
	
	public TransferSta() {
		super();
		this.stair = null;
		this.transferPassenger =0;
	}
	
	public TransferSta(int num, int[] passenger, ArrayList<Integer> stair, int[] bound, ArrayList<Integer> transStair, int transPass) {
		super(num, passenger, stair, bound);
		this.stair = transStair;
		this.transferPassenger = transPass;
	}
	
	public ArrayList<Integer> getStair() {
		return stair;
	}
	public void setStair(ArrayList<Integer> stair) {
		this.stair = stair;
	}
	public int getTransferPassenger() {
		return transferPassenger;
	}
	public void setTransferPassenger(int passenger) {
		this.transferPassenger = passenger;
	}
	
	
}
