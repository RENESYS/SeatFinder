package manage;

import java.util.ArrayList;

import data.Station;
import data.TransferSta;

public class Calculate {
	private double[] percent = {0.1, 0.2, 0.4, 0.2, 0.1}; 
	
	public void calcCongestion(ArrayList<Station> sta){
		double[] platform;
		int[] cars = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i < Define.STATIONNUM; i++){
			double[] transPlatform = {0,0,0,0,0,0,0,0,0,0};
			for(int hour = 4; hour < Define.HOUR; hour++){
				int getOnPassenger = sta.get(i).getGetOn()[hour] / 6;
				int getOffPassenger = sta.get(i).getGetOff()[hour] / 6;
				int passengerOfStair = getOnPassenger / sta.get(i).getStair().size();
				//calculate passengers on platform
				platform = calcPlatformCongest(passengerOfStair, sta.get(i).getStair());
				if(sta.get(i) instanceof TransferSta){
					int trans = ((TransferSta)sta.get(i)).getTransferPassenger() * (sta.get(i).getGetOn()[hour] / sta.get(i).getGetOn()[24]);
					transPlatform = calcPlatformCongest(trans,  ((TransferSta)sta.get(i)).getTransferStair());
				}
				//calculate passengers on each cars
				if(i != 0){
					cars = sta.get(i-1).getCongetstion()[hour].getCrowd();
					for(int car = 0; car < 10; car++){
						cars[car] += ((int)platform[car] + (int)transPlatform[car] - (getOffPassenger / 20));
						if(cars[car] < 0)
							cars[car] = 0;
					}	
				}
				for(int x = 0; x <10; x++){
					sta.get(i).getCongetstion()[hour].getCrowd()[x] = cars[x];
				}
			}
		}
		
		/*
		for(int i = 0; i < 25; i++){
			int[] temp = sta.get(i).getCongetstion()[7].getCrowd();
			for(int e : temp)
				System.out.print(e + " ");
			System.out.println(sta.get(i).getName());
		}
		*/
	}
	
	//calculate passengers on each cars
	public double[] calcPlatformCongest(int passengers, ArrayList<Integer> stairs){
		double[] temp = new double[10]; 
		double[] passPercent = new double[5];
		for(int i = 0; i < 5; i++){
			passPercent[i] = (passengers * percent[i]);
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
