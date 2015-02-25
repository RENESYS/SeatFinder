package data;

import manage.Define;

public class Train {
	private int[] crowd;
	
	public Train(){
		crowd = new int[Define.CARNUM];
	}

	public int[] getCrowd() {
		return crowd;
	}
	public void setCrowd(int[] crowd) {
		this.crowd = crowd;
	}
	
	
}
