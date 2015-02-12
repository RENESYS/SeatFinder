package manage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Station;

public class Manager {
	
	public static ArrayList<Station> manager(String path){
		ArrayList<Station> stations = new ArrayList<Station>();
		ReadFile rw = new ReadFile();
		rw.readData(path, stations);
	
		//stations.add(new Station());
		return stations;
	}
}
