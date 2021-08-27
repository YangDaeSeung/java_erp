package java_erp.dto;

public class Title {
	private int tno;
	private String tName;
	
	public Title() {
		
		// TODO Auto-generated constructor stub
	}

	public Title(int tno) {
		super();
		this.tno = tno;
	}

	public Title(int tno, String tName) {
		super();
		this.tno = tno;
		this.tName = tName;
	}

	@Override
	public String toString() {
		return "Title [tno=" + tno + ", tName=" + tName + "]";
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	
	
}
