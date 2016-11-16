import java.util.ArrayList;


public class CaiPiaoBaseModel {
	private ArrayList<String> numbers ; // 开奖序列号
	private String issue = null;// 期数 
	private String date = null;	// 日期
	private String time = null;	// 时间

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if (date.length()>0) {
			this.date = date;
		}
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		if (time.length()>0) {
			this.time = time;
		}
	}

	public ArrayList<String> getNumbers() {
		return this.numbers;
	}

	public void setNumbers(ArrayList<String> numbers) {
		this.numbers = numbers;
	}

}
