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
	
					System.out.println("Fixture [liga= " + fixture[0] + 
							" , data=" + fixture[1] +
							" , casa=" + fixture[2] +
							" , fora=" + fixture[3] +
							" , fullTimeHome=" + fixture[4] +
							" , fullTimeAway=" + fixture[5] +
//						" , halfTimeHome=" + fixture[7] +
//						" , halfTimeAway=" + fixture[8] +
							" , Home Win Odd=" + fixture[22] +
							" , Draw Odd=" + fixture[23] +
							" , Away Win Odd=" + fixture[24] +
							"]");
				
					list.add(fixture);
					
					writer.write(line);
					writer.newLine();
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
