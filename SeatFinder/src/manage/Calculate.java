package manage;

import java.util.ArrayList;

import data.Station;
import data.Train;

public class Calculate {
	private double[] percent = {0.1, 0.2, 0.4, 0.2, 0.1}; 
	
	public void calcCongestion(ArrayList<Station> sta){
		int[] platform;
		int[] cars = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i < Define.STATIONNUM; i++){
			for(int hour = 4; hour < Define.HOUR; hour++){
				int getOnPassenger = sta.get(i).getGetOn()[hour] / 6;
				int getOffPassenger = sta.get(i).getGetOff()[hour] / 6;
				int passengerOfStair = getOnPassenger / sta.get(i).getStair().size();
				platform = calcPlatformCongest(passengerOfStair, sta.get(i).getStair());
				
				if(i != 0){
					cars = sta.get(i-1).getCongetstion()[hour].getCrowd();
					for(int car = 0; car < 10; car++){
						cars[car] += (platform[car] - (getOffPassenger / 20));
						if(cars[car] < 0)
							cars[car] = 0;
					}	
				}
				for(int x = 0; x <10; x++){
					sta.get(i).getCongetstion()[hour].getCrowd()[x] = cars[x];
				}
			}
		}
		
		for(int i = 0; i < 25; i++){
			int[] temp = sta.get(i).getCongetstion()[18].getCrowd();
			for(int e : temp)
				System.out.print(e + " ");
			System.out.println(sta.get(i).getName());
		}
	}
	
	//calculate passengers on each cars
	public int[] calcPlatformCongest(int passengers, ArrayList<Integer> stairs){
		int[] temp = new int[10]; 
		int[] passPercent = new int[5];
		for(int i = 0; i < 5; i++){
			passPercent[i] = (int)(passengers * percent[i]);
		}
		for(int i = 0; i < stairs.size(); i++){
			int stairPos = stairs.get(i);
			for(int j = -2 ; j <= 2 ; j++){
				if(stairPos + j >= 0 && stairPos + j < 10)
					temp[stairPos + j] = passPercent[j+2];
				else if(stairPos + j < 0)
					temp[0] = passPercent[j+2];
				else if(stairPos + j >= 10)
					temp[9] = passPercent[j+2];
			}
		}
		return temp;
	}
	
}
