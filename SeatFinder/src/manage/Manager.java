package manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Station;
import data.Train;

public class Manager {
	
	public static ArrayList<Station> manager(HttpServletRequest req, HttpServletResponse res, String path){
		ArrayList<Station> stations = new ArrayList<Station>();
		Train[] trains = new Train[Define.STATIONNUM];
		ReadFile rw = new ReadFile();
		Calculate calc = new Calculate();
		
		rw.readStation(path, stations);
		rw.readTransfer(path, stations);
		rw.readJson(path, stations);
		
		calc.calcCongestion(stations);
	
		//stations.add(new Station());
		return stations;
	}
}
