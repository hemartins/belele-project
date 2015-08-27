package pt.belele.project.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	public static List<String[]> readFromCSV(String path) {
		BufferedReader br = null;
		List<String[]> list = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new InputStreamReader(new URL(path).openStream()));
			br.readLine();
			String line = "";
			String csvSplitBy = ",";
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] fixture = line.split(csvSplitBy);

				System.out.println("Fixture [liga= " + fixture[0] + 
						" , data=" + fixture[1] +
						" , casa=" + fixture[2] +
						" , fora=" + fixture[3] +
						" , fullTimeHome=" + fixture[4] +
						" , fullTimeAway=" + fixture[5] +
						" , halfTimeHome=" + fixture[7] +
						" , halfTimeAway=" + fixture[8] +
						"]");
				
				list.add(fixture);
			}

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
