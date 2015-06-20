import java.util.*;
import java.io.*;

class DataStruct {
	public int age;
	public String line;
	public DataStruct(int age, String line) {
		this.age = age;
		this.line = line;
	}
}

public class SortContacts {
	public static void main(String argv[]){
		if(argv.length == 0 || argv.length == 1) {
			System.out.println("Syntax: java SortContacts [Filename to sort] [Attribute to sort by]");
		}
		String file = argv[0];
		String sort = argv[1];

		if(sort.equals("last_name")) {
			Vector tuples = new Vector();
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String thisLine, firstLine = reader.readLine();
				while((thisLine = reader.readLine()) != null) {
					String last_name = thisLine.split(",")[1];
					if(tuples.size() == 0) {
						String[] tuple = {last_name, thisLine};
						tuples.addElement(tuple);
					} else {
						for(int i=0; i<tuples.size(); i++) {
							if(last_name.compareTo(((String[]) tuples.elementAt(i))[0]) <= 0) {
								String[] tuple = {last_name, thisLine};
								tuples.insertElementAt(tuple, i);
								break;
							} else if(i==(tuples.size()-1)) {
								String[] tuple = {last_name, thisLine};
								tuples.addElement(tuple);
								break;
							}
						}
					}
				}
				String[] dummyFirstLine = {"", firstLine};
				tuples.insertElementAt(dummyFirstLine, 0);
				for(int i=0; i<tuples.size(); i++) {
					String[] printline = (((String[]) tuples.elementAt(i))[1]).split(",");
					System.out.print(printline[0]+"\t"+printline[1]+"\t"+printline[2]+"\t"+printline[3]+"\t"+printline[4]+"\t"+printline[5]+"\t"+
						printline[6]+"\t"+printline[7]+"\t"+printline[8]+"\t"+printline[9]+"\t"+printline[10]+"\t"+printline[11]+"\n");
				}			
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Something broke while reading the file");
			}
		} else if(sort.equals("age")) {
			Vector tuples = new Vector();
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String thisLine, firstLine = reader.readLine();
				while((thisLine = reader.readLine()) != null) {
					int age = Integer.parseInt(thisLine.split(",")[11]);
					if(tuples.size() == 0) {
						DataStruct tuple = new DataStruct(age, thisLine);
						tuples.addElement(tuple);
					} else {
						for(int i=0; i<tuples.size(); i++) {
							if(age <= ((DataStruct) tuples.elementAt(i)).age) {
								DataStruct tuple = new DataStruct(age, thisLine);
								tuples.insertElementAt(tuple, i);
								break;
							} else if(i==(tuples.size()-1)) {
								DataStruct tuple = new DataStruct(age, thisLine);
								tuples.addElement(tuple);
								break;
							}
						}
					}
				}
				DataStruct dummyFirstLine = new DataStruct(0, firstLine);
				tuples.insertElementAt(dummyFirstLine, 0);
				for(int i=0; i<tuples.size(); i++) {
					String[] printline = (((DataStruct) tuples.elementAt(i)).line).split(",");
					System.out.print(printline[0]+"\t"+printline[1]+"\t"+printline[2]+"\t"+printline[3]+"\t"+printline[4]+"\t"+printline[5]+"\t"+
						printline[6]+"\t"+printline[7]+"\t"+printline[8]+"\t"+printline[9]+"\t"+printline[10]+"\t"+printline[11]+"\n");
				}				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Something broke while reading the file");
			}
		}
	}	
}
