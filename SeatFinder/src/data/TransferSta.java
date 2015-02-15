package data;

import java.util.ArrayList;

public class TransferSta extends Station{
	private ArrayList<Integer> transferStair;
	private int transferPassenger;
	
	public TransferSta() {
		super();
		this.transferStair = new ArrayList<Integer>();
		this.transferPassenger = 0;
	}
	
	public ArrayList<Integer> getTransferStair() {
		return transferStair;
	}
	public void setTransferStair(ArrayList<Integer> stair) {
		this.transferStair = stair;
	}
	public int getTransferPassenger() {
		return transferPassenger;
	}
	public void setTransferPassenger(int passenger) {
		this.transferPassenger = passenger;
	}
	
	
}
