import java.util.ArrayList;
/**
 * @author Bambanza
 * This class takes care of the information of one address information storage
 */
public class DataOrg {

	private String lastName;
	private int age;
	private ArrayList<String> otherdata;
	public DataOrg(String lastName, int age, ArrayList<String> otherdata) {
		this.lastName = lastName;
		this.age = age;
		this.otherdata = otherdata;
	}
public String getLastName() {
		return this.lastName;
	}
	public int getAge() {
		return this.age;}
	public ArrayList<String> getotherData() {
		return this.otherdata;
	}
