
public class SMS extends Communication {

	private String content;
	
	public SMS(String numberone,String numbertwo,int aDay, int aMonth, int aYear,String aContent) {
		super(numberone,numbertwo,aDay,aMonth,aYear);
		content = aContent;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + content);
	}
	
	public int getDuration() {
		return 0;
	}
}
