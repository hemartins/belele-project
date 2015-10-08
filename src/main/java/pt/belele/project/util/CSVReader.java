package pt.belele.project.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	public static List<String[]> readFromCSV(String path) {
		BufferedReader br = null;
		List<String[]> list = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new InputStreamReader(new URL(path).openStream()));
			 
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(path.substring(path.lastIndexOf("/")+1, path.length())), StandardCharsets.UTF_8, StandardOpenOption.CREATE);

			br.readLine();
			String line = "";
			String csvSplitBy = ",";
			while ((line = br.readLine()) != null) {
				try{
					// use comma as separator
					String[] fixture = line.split(csvSplitBy);
	
					if (fixture[0].contains("E0") || fixture[0].contains("E1") || fixture[0].contains("E2") || fixture[0].contains("SC0")){
						System.out.println("Fixture [liga= " + fixture[0] + 
								" , data=" + fixture[1] +
								" , casa=" + fixture[2] +
								" , fora=" + fixture[3] +
								" , fullTimeHome=" + fixture[4] +
								" , fullTimeAway=" + fixture[5] +
//							" , halfTimeHome=" + fixture[7] +
//							" , halfTimeAway=" + fixture[8] +
								" , Home Win Odd=" + fixture[23] +
								" , Draw Odd=" + fixture[24] +
								" , Away Win Odd=" + fixture[25] +
								"]");
					
						list.add(fixture);
						
						writer.write(line);
						writer.newLine();
					}
					else if (fixture[0].contains("D1") || fixture[0].contains("I1") || fixture[0].contains("SP1") || fixture[0].contains("F1")){
						System.out.println("Fixture [liga= " + fixture[0] + 
								" , data=" + fixture[1] +
								" , casa=" + fixture[2] +
								" , fora=" + fixture[3] +
								" , fullTimeHome=" + fixture[4] +
								" , fullTimeAway=" + fixture[5] +
//							" , halfTimeHome=" + fixture[7] +
//							" , halfTimeAway=" + fixture[8] +
								" , Home Win Odd=" + fixture[22] +
								" , Draw Odd=" + fixture[23] +
								" , Away Win Odd=" + fixture[24] +
								"]");
					
						list.add(fixture);
						
						writer.write(line);
						writer.newLine();
					}
					else if (fixture[0].contains("D2") || fixture[0].contains("I2") || fixture[0].contains("SP2") || fixture[0].contains("F2") || fixture[0].contains("N1") || fixture[0].contains("B1") || fixture[0].contains("P1") || fixture[0].contains("T1") || fixture[0].contains("G1")){
						System.out.println("Fixture [liga= " + fixture[0] + 
								" , data=" + fixture[1] +
								" , casa=" + fixture[2] +
								" , fora=" + fixture[3] +
								" , fullTimeHome=" + fixture[4] +
								" , fullTimeAway=" + fixture[5] +
//							" , halfTimeHome=" + fixture[7] +
//							" , halfTimeAway=" + fixture[8] +
								" , Home Win Odd=" + fixture[10] +
								" , Draw Odd=" + fixture[11] +
								" , Away Win Odd=" + fixture[12] +
								"]");
					
						list.add(fixture);
						
						writer.write(line);
						writer.newLine();
					}
					else {
						System.out.println("FODEU CARA!!");
					}
					
				} catch(ArrayIndexOutOfBoundsException ex)
				{
					ex.printStackTrace();
				}
			}
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
		return list;
	}
}
