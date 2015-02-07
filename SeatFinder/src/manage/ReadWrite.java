package manage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import data.Station;
import data.TransferStation;

public class ReadWrite {
	
	public ReadWrite(){}
	
	public void readData(ArrayList<Station> stations){
		try{
			FileReader fr = new FileReader("bound.txt");
			BufferedReader inFile = new BufferedReader(fr);
			String data = inFile.readLine();
			StringTokenizer st = new StringTokenizer(data);
			
			String type;
			int num;
			Station sta;
			
			for(int i = 0; i < 24; i++){
			//setting station type
			type = st.nextToken();
			if(type.equals("T"))
				sta = new TransferStation();
			else
				sta = new Station();
			
			//setting station num
			num = Integer.parseInt(st.nextToken());
			sta.setNum(num);
				
			//set station's bound probability
				for(int j = 0; j < 24; i++){
					
					
				}
				stations.add(sta);
			}
			
		}
		catch(IOException e){
			
		}
		
		
	}
	
}
