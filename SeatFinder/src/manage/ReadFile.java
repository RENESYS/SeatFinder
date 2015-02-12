package manage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Station;
import data.TransferSta;

public class ReadFile extends HttpServlet{
	
	//FileReader fr1;
	BufferedReader boundFile;
	BufferedReader exitFile;
	
	public ArrayList<Station> readData(String path, ArrayList<Station> stations){
		try{
			boundFile = new BufferedReader(new FileReader(path + "/bound.txt"));
			exitFile = new BufferedReader(new FileReader(path + "/exit.txt"));
	
			String type;
			int num;
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
				
				//setting station number
				num = Integer.parseInt(st1.nextToken());
				sta.setNum(num);
					
				//set station's bound probability
				sta.setBound(setBounds(st1));
				
				//set station's exit position
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
			}catch(IOException e){}
		}
		
		return stations;
	}
	
	
	public int[] setBounds(StringTokenizer st){
		int[] tempBound = new int[Define.HOUR];
		for(int j = 0; j < Define.HOUR; j++){
			tempBound[j] = Integer.parseInt(st.nextToken());
		}
		return tempBound;
	}
	
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