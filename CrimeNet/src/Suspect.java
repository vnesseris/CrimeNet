import java.util.ArrayList;

public class Suspect {

	private String name;
	private String codeName;
	private String city;
	private ArrayList<String> phonenumbers = new ArrayList<String>();
	private ArrayList<Suspect> possiblePartners = new ArrayList<Suspect>();
	
	public Suspect(String aName,String aCodeName,String aCity) {
		name = aName;
		codeName = aCodeName;
		city = aCity;
	}
	
	public void addNumber(String number) {
		phonenumbers.add(number);
	}
	
	public void addPossiblePartner(Suspect suspect) {
		if(!possiblePartners.contains(suspect)) {
			possiblePartners.add(suspect);
		}
	}
	
	public boolean isConnectedTo(Suspect suspect) {
		boolean isConnected = false;
		for(Suspect aSuspect: possiblePartners) {
			if(aSuspect.equals(suspect)) {
				isConnected = true;
			}
		}
		for(Suspect aSuspect: suspect.possiblePartners) {
			if(aSuspect.equals(this)) {
				isConnected = true;
			}
		}
		return isConnected;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect){
		ArrayList<Suspect> commonPartners = new ArrayList<Suspect>();
		for(Suspect suspect: possiblePartners) {
			for(Suspect thesuspect: aSuspect.possiblePartners) {
				if (suspect.equals(thesuspect)) {
					commonPartners.add(suspect);
				}
			}
		}
		return commonPartners;
	}
	
	public ArrayList<Suspect> getPossiblePartners(){
		return this.possiblePartners;
	}
	
	public void printPossiblePartners() {
		System.out.println("Possible Partners");
		for(Suspect suspect: possiblePartners) {
			System.out.println("Name: " + suspect.name + ", Code Name: " + suspect.codeName );
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getCodeName() {
		return codeName;
	}
	
	public ArrayList<String> getPhoneNumbers(){
		return this.phonenumbers;
	}
	
}
