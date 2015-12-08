package pt.belele.project.business.util.footballDataInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CSVReader {

    private static final Logger LOG = LogManager.getLogger(CSVReader.class);

    public static List<String[]> readFromCSV(String path) {
	BufferedReader br = null;
	List<String[]> list = new ArrayList<>();
	try {
	    br = new BufferedReader(new InputStreamReader(new URL(path).openStream()));

	    br.readLine();
	    String line;
	    String csvSplitBy = ",";
	    while ((line = br.readLine()) != null) {
		try {
		    // use comma as separator
		    String[] fixture = line.split(csvSplitBy);

		    if (fixture[0].contains("E0") || fixture[0].contains("E1") || fixture[0].contains("E2") || fixture[0].contains("SC0")) {
//			LOG.debug("Fixture [liga= " + fixture[0]
//				+ " , data=" + fixture[1]
//				+ " , casa=" + fixture[2]
//				+ " , fora=" + fixture[3]
//				+ " , fullTimeHome=" + fixture[4]
//				+ " , fullTimeAway=" + fixture[5]
//				+ " , Home Win Odd=" + fixture[23]
//				+ " , Draw Odd=" + fixture[24]
//				+ " , Away Win Odd=" + fixture[25]
//				+ "]");

			list.add(fixture);
		    } else if (fixture[0].contains("D1") || fixture[0].contains("I1") || fixture[0].contains("SP1") || fixture[0].contains("F1")) {
//			LOG.debug("Fixture [liga= " + fixture[0]
//				+ " , data=" + fixture[1]
//				+ " , casa=" + fixture[2]
//				+ " , fora=" + fixture[3]
//				+ " , fullTimeHome=" + fixture[4]
//				+ " , fullTimeAway=" + fixture[5]
//				+ " , Home Win Odd=" + fixture[22]
//				+ " , Draw Odd=" + fixture[23]
//				+ " , Away Win Odd=" + fixture[24]
//				+ "]");

			list.add(fixture);
		    } else if (fixture[0].contains("D2") || fixture[0].contains("I2") || fixture[0].contains("SP2") || fixture[0].contains("F2") || fixture[0].contains("N1") || fixture[0].contains("B1") || fixture[0].contains("P1") || fixture[0].contains("T1") || fixture[0].contains("G1")) {
//			LOG.debug("Fixture [liga= " + fixture[0]
//				+ " , data=" + fixture[1]
//				+ " , casa=" + fixture[2]
//				+ " , fora=" + fixture[3]
//				+ " , fullTimeHome=" + fixture[4]
//				+ " , fullTimeAway=" + fixture[5]
//				+ " , Home Win Odd=" + fixture[10]
//				+ " , Draw Odd=" + fixture[11]
//				+ " , Away Win Odd=" + fixture[12]
//				+ "]");

			list.add(fixture);
		    } else {
			LOG.debug("FODEU CARA!! porque o array[0] é " + fixture[0]);
		    }

		} catch (ArrayIndexOutOfBoundsException ex) {
		    ex.printStackTrace();
		}
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

	LOG.debug("Done");
	return list;
    }
}
