package manage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import data.Station;
import data.TransferSta;

public class ReadFile extends HttpServlet{
	
	BufferedReader boundFile;
	BufferedReader exitFile;
	BufferedReader transferFile;
	
	
	public ArrayList<Station> readStation(String path, ArrayList<Station> stations){
		try{
			boundFile = new BufferedReader(new FileReader(path + "/bound.txt"));
			exitFile = new BufferedReader(new FileReader(path + "/exit.txt"));
			String type;
			Station sta = null;
			
			for(int i = 0; i < Define.STATIONNUM; i++){
				StringTokenizer st1 = new StringTokenizer(boundFile.readLine());
				StringTokenizer st2 = new StringTokenizer(exitFile.readLine());
				
				//setting station type
				type = st1.nextToken();
				if(type.equals("T"))
					sta = new TransferSta();
				else
					sta = new Station();
				
				//setting station
				sta.setName(st1.nextToken());
				sta.setNum(Integer.parseInt(st1.nextToken()));
				sta.setBound(setBounds(st1));
				sta.setStair(setExit(st2));
				
				//add new stations to arraylist
				stations.add(sta);
			}
		}catch(IOException e){
			System.out.println("File not found.");
			e.printStackTrace();
		}finally{
			try{
				boundFile.close();
				exitFile.close();
			}catch(IOException e){}
		}
		return stations;
	}
	
	
	//read transfer data from text file
	public ArrayList<Station> readTransfer(String path, ArrayList<Station> sta){
		try{
			transferFile = new BufferedReader(new FileReader(path + "/transfer.txt"));
			ArrayList<Integer> tempTransStair = new ArrayList<Integer>();
			int stationNum = 400;
			int num = 0;
			
			while(num != -2){
				StringTokenizer st = new StringTokenizer(transferFile.readLine());
				stationNum = Integer.parseInt(st.nextToken()) - 409;
				
				int passenger = Integer.parseInt(st.nextToken());
				((TransferSta) sta.get(stationNum)).setTransferPassenger(passenger);
				
				while(true){
					num = Integer.parseInt(st.nextToken());
					if(num < 0)
						break;
					tempTransStair.add(num);
				}
				((TransferSta) sta.get(stationNum)).setTransferStair(tempTransStair);	
			}
		}catch(IOException e){
			System.out.println("File not found.");
			e.printStackTrace();
		}
		finally{
			try{
				transferFile.close();
			}catch(IOException e){}
		}
		return sta;
	}
	
	
	//read passengers in hour data from json file
	public void readJson(String path, ArrayList<Station> sta){
		try{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(path + "/passengers.json"));
			JSONObject jo = (JSONObject)obj;
			JSONArray arr = (JSONArray)jo.get("DATA");
			String jsonPath;
			StringTokenizer st;
			
			for(int i = 0; i < (Define.STATIONNUM * 2); i+=2){
				JSONObject jo1 = (JSONObject)arr.get(i);
				JSONObject jo2 = (JSONObject)arr.get(i+1);
				for(int j = 0; j < Define.HOUR; j++){
					if(j < 9)
						jsonPath = "FROM0" + j + "TO0" + (j+1);
					else if(j == 9)
						jsonPath = "FROM09TO10";
					else
						jsonPath = "FROM" + j + "TO" + (j+1);
					
				String s = (String) jo1.get("STN_NM");
				st = new StringTokenizer(s, "^([\\d])$");
				st.nextToken();
				int staNum = Integer.parseInt(st.nextToken()) - 409;
				
				sta.get(staNum).getGetOn()[j] = Integer.parseInt( (String)jo1.get(jsonPath) );
				sta.get(staNum).getGetOff()[j] = Integer.parseInt( (String)jo2.get(jsonPath) );
				}
			}	
		}catch(IOException e){} 
		catch (ParseException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
	
	
	//set station's bound probability
	public int[] setBounds(StringTokenizer st){
		int[] tempBound = new int[Define.HOUR];
		for(int j = 0; j < Define.HOUR; j++){
			tempBound[j] = Integer.parseInt(st.nextToken());
		}
		return tempBound;
	}
	
	
	//set station's exit position
	public ArrayList<Integer> setExit(StringTokenizer st){
		ArrayList<Integer> tempStair = new ArrayList<Integer>();
		int num = Integer.parseInt(st.nextToken());
		while(num != -1){
			num = Integer.parseInt(st.nextToken());
			tempStair.add(num);
		}
		return tempStair;
	}
	
}