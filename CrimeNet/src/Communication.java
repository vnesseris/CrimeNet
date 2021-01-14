
public abstract class Communication {

	protected String firstnumber;
	protected String secondnumber;
	protected int day;
	protected int month;
	protected int year;
	
	public Communication(String numberone,String numbertwo,int aDay, int aMonth, int aYear) {
		firstnumber = numberone;
		secondnumber = numbertwo;
		day = aDay;
		month = aMonth;
		year = aYear;
	}
	
	public void printInfo() {
		System.out.println("Between " + firstnumber + " --- " + secondnumber);
		System.out.println("On " + year + "/" + month + "/" + day);
	}
	
	public String getFirstNumber() {
		return firstnumber;
	}
	
	public String getSecondNumber() {
		return secondnumber;
	}
	
	public int getdDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getDuration() {
		return 0;
	}
	
	public String getContent() {
		return "0";
	}
}
