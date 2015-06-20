import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * DataReadSort class that represents all data and the header informations
 */
public class DataReadSort {
	
	public DataReadSort(String[] Firstline) {this.Firstline = Firstline;}
	private String[] Firstline;//this first line is the same for all addresses
	private static  ArrayList<DataOrg> addrArray = new ArrayList<DataOrg>();
	
	public void addaddresses(DataOrg addresses) {DataReadSort.addrArray.add(addresses);}
	
	public String[] getFirstLine() {
	return this.Firstline;}
	
	public ArrayList<DataOrg> getaddrArray() {
	return DataReadSort.addrArray;
	}
	
	
	public  String sort(String IndexSort){
		if (IndexSort.equals("last_name")) {
			sortByLastName();
		}
		else if (IndexSort.equals("age")) {
			sortByAge();}
		return IndexSort;
		}
	
	private static void sortByAge() {
		ArrayList<Integer> ageArray = new ArrayList<Integer>();//ArrayList<String> ageArray = new ArrayList<String>();
		for (DataOrg addr : addrArray) {
			ageArray.add(addr.getAge());}
		Collections.sort(ageArray);
		ArrayList<DataOrg>sortedArray = new ArrayList<DataOrg>();
		for (Integer age : ageArray) {
	    	for (int j = 0; j < addrArray.size(); j++) {
		    if (age.equals(addrArray.get(j).getAge())) {
			sortedArray.add(addrArray.get(j));
				addrArray.remove(j);
				  break;}}}
		addrArray = sortedArray;}
		private static void sortByLastName() {
		ArrayList<String> LastNamesArray = new ArrayList<String>();
		for (DataOrg addresses : addrArray) {
			LastNamesArray.add(addresses.getLastName());
		}
		Collections.sort(LastNamesArray);
		ArrayList<DataOrg>sortedArray = new ArrayList<DataOrg>();
		for (String LastName : LastNamesArray) {
			for (int j = 0; j < addrArray.size(); j++) {
				if ( LastName== addrArray.get(j).getLastName()) {
                	sortedArray.add(addrArray.get(j));
				    addrArray.remove(j);
					break;
				}}}
		addrArray = sortedArray;
	}
	
 
public void print() {
		for (DataOrg addr : addrArray) {
			String str = addr.getLastName()+ "\t" + addr.getAge() + "\t";
			if(addr.getotherData() != null)
			 for (String Attr : addr.getotherData()) {
				str += Attr + "\t";	}
 str = str.substring(0, str.length()-1);
			System.out.println(str);
		}
	}
	
}
