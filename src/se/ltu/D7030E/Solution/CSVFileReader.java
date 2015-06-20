import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * This CSVFilereader implements the Reader interface for reading CSV files
 *it also create BufferReader to read line after line in the whole file
 *@author bambanza
 */
public class CSVFileReader implements Reader {

	public CSVFileReader() {}
  
  	@Override
	public DataReadSort readFile(String fileName) {
		DataReadSort readSort = null;
		try {BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			 String[] firstline = reader.readLine().replaceAll("\"","").split(",");// save First line from CSV document, replaceAll to replace white spaces for empty String
		   int ageIndex = 0, lastNameIndex = 0;
			for (int i = 0; i < firstline.length; i++) {
				if (firstline[i].equals("age")) {
					ageIndex = i;
				}
				else if (firstline[i].equals("last_name")) {
					lastNameIndex = i;
				}
			}
			String addressesLine;
			readSort = new DataReadSort(firstline);
			while ((addressesLine = reader.readLine()) != null) {
			String[] addressesInfo = addressesLine.replaceAll("\\s+","").split(",");
			ArrayList<String> otherData = new ArrayList<String>();//// to store values
			String lastName = "";
			int age = 0;
				for (int i = 0; i < addressesInfo.length; i++) 
				{
					if (i == ageIndex) {
					age = Integer.valueOf(addressesInfo[i]);
					}
				else if (i == lastNameIndex) {lastName = addressesInfo[i];}
					else {
						otherData.add(addressesInfo[i]);
					    }
				}
		                readSort.addaddresses(new DataOrg(lastName, age, otherData));// add entry to readSort
			}
			reader.close();
		
		} catch (FileNotFoundException e) {
			String file = "File: " + fileName + " not found!";
			System.out.println(file);
		} catch (IOException e) {
			String file = "Cannot read file: " + fileName;
			System.out.println(file);
		}
		
		return readSort;
	}

}
