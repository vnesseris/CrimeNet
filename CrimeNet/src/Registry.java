import java.util.ArrayList;

public class Registry {

	private ArrayList<Suspect> suspects = new ArrayList<Suspect>();
	private ArrayList<Communication> communications = new ArrayList<Communication>();
	private ArrayList<Communication> phoneCallsBetween = new ArrayList<Communication>();
	private ArrayList<SMS> smsBetween = new ArrayList<SMS>();
	
	public void addSuspect(Suspect aSuspect) {
		suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aComm) {
		communications.add(aComm);
		for(Suspect suspect: suspects) {
			if(suspect.getPhoneNumbers().contains(aComm.getFirstNumber())){
				for(Suspect asuspect: suspects) {
					if(asuspect.getPhoneNumbers().contains(aComm.getSecondNumber())) {
						suspect.addPossiblePartner(asuspect);
						asuspect.addPossiblePartner(suspect);
					}
				}
			}
		}
	}
	
	public ArrayList<Suspect> getSuspects(){
		return suspects;
	}
	
	public Suspect getSuspectWithMostPartners() {
		Suspect mostWantedSuspect = suspects.get(0);
		for(Suspect suspect: suspects) {
			if(suspect.getPossiblePartners().size() >= mostWantedSuspect.getPossiblePartners().size()) {
				mostWantedSuspect = suspect;	
			}
		}
		return mostWantedSuspect;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		
		for(Communication phonecall: communications) {
			if((phonecall.getFirstNumber().equals(number1) && phonecall.getSecondNumber().equals(number2) && phonecall.getDuration()>0) || (phonecall.getFirstNumber().equals(number2) && phonecall.getSecondNumber().equals(number1) && phonecall.getDuration()>0)) {
				phoneCallsBetween.add(phonecall);
			}
		}
		Communication longestPhoneCall = phoneCallsBetween.get(0);
		for(Communication phoneCall: phoneCallsBetween) {
			if(phoneCall.getDuration()>=longestPhoneCall.getDuration()) {
				longestPhoneCall = phoneCall;
			}
		}
		return (PhoneCall)longestPhoneCall;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1,String number2) {
		for(Communication sms:communications) {
			 if ((sms.getFirstNumber().equals(number1) && sms.getSecondNumber().equals(number2)  && (sms.getContent().contains("Bomb") || sms.getContent().contains("Attack") || sms.getContent().contains("Explosives") || sms.getContent().contains("Gun"))) ){	
				smsBetween.add((SMS)sms);
			}
		}
		return smsBetween;
	}
}
