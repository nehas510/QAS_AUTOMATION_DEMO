package model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

public class sendEmail {
	
	 @ExcelRow                  
	private int rowIndex;
	 
	 @ExcelCell(0)
	private String testcaseName;
	 @ExcelCell(1)
	private String toEmailID;
	 @ExcelCell(2)
	private String fromEmailID;
	 @ExcelCell(3)
	private String subject;
	 @ExcelCell(4)
	private String date;
	 @ExcelCell(5)
	private String messageID;
	 @ExcelCell(6)
	private String body;
	
	public String getTestcaseName() {
		return testcaseName;
	}
	public void setTestcaseName(String testcaseName) {
		this.testcaseName = testcaseName;
	}
	public String getToEmailID() {
		return toEmailID;
	}
	public void setToEmailID(String toEmailID) {
		this.toEmailID = toEmailID;
	}
	public String getFromEmailID() {
		return fromEmailID;
	}
	public void setFromEmailID(String fromEmailID) {
		this.fromEmailID = fromEmailID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
