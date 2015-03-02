package manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Station;
import data.Train;

public class Manager implements ICongestion{
	
	public static ArrayList<Station> initialize(String path){
		ArrayList<Station> stations = new ArrayList<Station>();
		Train[] trains = new Train[Define.STATIONNUM];
		ReadFile rw = new ReadFile();
		Calculate calc = new Calculate();
		
		rw.readStation(path, stations);
		rw.readTransfer(path, stations);
		rw.readJson(path, stations);
		
		calc.calcCongestion(stations);
		return stations;
	}
	
	public int getStationNum(ArrayList<Station> sta, String name){
		int num = 0;
		for(int i = 0; i < sta.size(); i++){
			if(sta.get(i).getName().equals(name))
				num = i;
		}
		return num;
	}
	
	public int[] getTrainCongestion(ArrayList<Station> sta, int staNum, int hour){
		return sta.get(staNum).getCongetstion()[hour].getCrowd();
	}
}
