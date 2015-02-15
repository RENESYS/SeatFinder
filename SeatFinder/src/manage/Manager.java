package manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Station;
import data.TransferSta;

public class Manager {
	
	public static ArrayList<Station> manager(HttpServletRequest req, HttpServletResponse res, String path){
		ArrayList<Station> stations = new ArrayList<Station>();
		ReadFile rw = new ReadFile();
		rw.readStation(path, stations);
		rw.readTransfer(path, stations);
		rw.readJson(req, res, path, stations);
	
		//stations.add(new Station());
		return stations;
	}
}
