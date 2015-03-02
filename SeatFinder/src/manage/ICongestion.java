package manage;

import java.util.ArrayList;

import data.Station;

public interface ICongestion {
	public int[] getTrainCongestion(ArrayList<Station> sta, int staNum, int hour);
	public int getStationNum(ArrayList<Station> sta, String name);
}
