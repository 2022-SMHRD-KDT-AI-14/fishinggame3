package method;

public class CallOfFishDTO {

	private String fishname;
	private int fscore;
	private int price;
	private int grade;
	private int fno;
	private int i_tem;
	

	public CallOfFishDTO(String fishname, int fscore, int price, int grade, int fno, int i_tem) {
		this.fishname = fishname;
		this.fscore = fscore;
		this.price = price;
		this.grade = grade;
		this.fno = fno;
		this.i_tem = i_tem;
	}

	public CallOfFishDTO(int grade) {
		this.grade = grade;
	}

	public String getFishname() {
		return fishname;
	}

	public void setFishname(String fishname) {
		this.fishname = fishname;
	}

	public int getFscore() {
		return fscore;
	}

	public void setFscore(int fscore) {
		this.fscore = fscore;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}
}
