package data;

public class TransferStation extends Station{
	private int[]  stair;
	private int transferPassenger;
	
	
	
	public TransferStation() {
		super();
		this.stair = null;
		this.transferPassenger =0;
	}
	
	public TransferStation(String name, int num, int[] passenger, int[] stair, int[] bound, int[] transStair, int transPass) {
		super(name, num, passenger, stair, bound);
		this.stair = transStair;
		this.transferPassenger = transPass;
	}
	
	public int[] getStair() {
		return stair;
	}
	public void setStair(int[] stair) {
		this.stair = stair;
	}
	public int getTransferPassenger() {
		return transferPassenger;
	}
	public void setTransferPassenger(int passenger) {
		this.transferPassenger = passenger;
	}
	
	
}
