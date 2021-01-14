
public class PhoneCall extends Communication {

	private int duration;
	
	public PhoneCall(String numberone,String numbertwo,int aDay, int aMonth, int aYear,int aDuration) {
		super(numberone,numbertwo,aDay,aMonth,aYear);
		duration = aDuration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + duration + "\n");
	}


	public String getContent() {
		return "0";
	}
}
