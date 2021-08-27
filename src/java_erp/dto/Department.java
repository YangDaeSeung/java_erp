package java_erp.dto;

public class Department {
	private int deptno;
	private String deptName;
	private int floor;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int deptno) {
		super();
		this.deptno = deptno;
	}
	public Department(int deptno, String deptName, int floor) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
		this.floor = floor;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptName=" + deptName + ", floor=" + floor + "]";
	}
	
}
