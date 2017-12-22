package in.vamsoft.pojo;

public class ModelQuestion {
	
	int qno;
	String qut;
	String opta;
	String optb;
	String optc;
	String optd;
	String ans;
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQut() {
		return qut;
	}
	public void setQut(String qut) {
		this.qut = qut;
	}
	public String getOpta() {
		return opta;
	}
	public void setOpta(String opta) {
		this.opta = opta;
	}
	public String getOptb() {
		return optb;
	}
	public void setOptb(String optb) {
		this.optb = optb;
	}
	public String getOptc() {
		return optc;
	}
	public void setOptc(String optc) {
		this.optc = optc;
	}
	public String getOptd() {
		return optd;
	}
	public void setOptd(String optd) {
		this.optd = optd;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "ModelQuestion [qno=" + qno + ", qut=" + qut + ", opta=" + opta + ", optb=" + optb + ", optc=" + optc
				+ ", optd=" + optd + ", ans=" + ans + "]";
	}
	public ModelQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelQuestion(int qno, String qut, String opta, String optb, String optc, String optd, String ans) {
		super();
		this.qno = qno;
		this.qut = qut;
		this.opta = opta;
		this.optb = optb;
		this.optc = optc;
		this.optd = optd;
		this.ans = ans;
	}
	
	
	
	
	
}
