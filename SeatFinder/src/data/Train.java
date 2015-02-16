package data;

public class Train {
	private int[] crowd;
	
	public Train(){
		//System.out.println("aa");
		crowd = new int[10];
	}

	public int[] getCrowd() {
		return crowd;
	}
	public void setCrowd(int[] crowd) {
		this.crowd = crowd;
	}
	
	
}
