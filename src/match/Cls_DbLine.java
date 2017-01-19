package match;

public class Cls_DbLine {

	int id;
	String jph;
	String jpk;
	String sp;
	String en;
	
	public Cls_DbLine(){
	}
	
	public Cls_DbLine(int id, String jph, String jpk, String sp, String en){
		this.id = id;
		this.jph = jph;
		this.jpk = jpk;
		this.sp = sp;
		this.en = en;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJph() {
		return jph;
	}

	public void setJph(String jph) {
		this.jph = jph;
	}

	public String getJpk() {
		return jpk;
	}

	public void setJpk(String jpk) {
		this.jpk = jpk;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}
	
	
}
