package manage;

import java.util.ArrayList;

import data.Station;
import data.TransferSta;

public class Calculate {
	
	public void calcCongestion(ArrayList<Station> sta){
		double[] platform;
		double[] transPlatform = new double[Define.CARNUM];
		int[] interval = {0, 0, 0, 0, 0, 5, 6, 9, 10, 10, 6, 5, 6, 
				6, 5, 6, 5, 7, 8, 8, 7, 6, 5, 4};	//train per hour
		
		for(int i = 0; i < Define.STATIONNUM; i++){
			Station station = sta.get(i);
			
			for(int hour = 5; hour < Define.HOUR; hour++){
				int[] cars = {0,0,0,0,0,0,0,0,0,0};
				int getOnPassenger = station.getGetOn()[hour] / interval[hour];
				int getOffPassenger = station.getGetOff()[hour] / interval[hour];
				int passengerOfStair = getOnPassenger / station.getStair().size();
				//calculate passengers on platform
				platform = calcPlatformCongest(passengerOfStair, station.getStair());
				if(station instanceof TransferSta){
					double transferPerHour = station.getGetOn()[hour] / station.getGetOn()[24];
					double trans = ((TransferSta)station).getTransferPassenger() * transferPerHour;
					transPlatform = calcPlatformCongest((int)trans,  ((TransferSta)station).getTransferStair());
				}
				//calculate passengers on each cars
				if(i != 0){
					cars = sta.get(i-1).getCongetstion()[hour].getCrowd();
					for(int car = 0; car < 10; car++){
						cars[car] += ( (int)(platform[car] + transPlatform[car] - (getOffPassenger / 20)) );
						if(cars[car] < 0)
							cars[car] = 0;
					}	
				}
				//put the result in the Station instance
				cars = modifyCars(cars);
				for(int carNum = 0; carNum <Define.CARNUM; carNum++){
					sta.get(i).getCongetstion()[hour].getCrowd()[carNum] = cars[carNum];
				}
			}
		}
	}
	
	//calculate passengers on each cars
	public double[] calcPlatformCongest(int passengers, ArrayList<Integer> stairs){
		double[] percent = {0.1, 0.2, 0.4, 0.2, 0.1};
		double[] temp = new double[Define.CARNUM]; 
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
	
	public int[] modifyCars(int[] car){
		for(int i = 0; i < 9; i++){
			if(car[i] > car[i+1] + 30){
				car[i] -= 15;
				car[i+1] += 15;
			}
		}
		for(int i = 9; i > 0; i--){
			if(car[i] > car[i-1] + 30){
				car[i] -= 15;
				car[i-1] += 15;
			}
		}
		return car;
	}
}
