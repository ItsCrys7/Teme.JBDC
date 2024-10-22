package ro.emanuel.cantina.pojo;

public class Meniu {
	
	private int id;
	private String fel1;
	private String fel2;
	private String desert;
	private int pret;
	
	public Meniu(int id, String fel1, String fel2, String desert, int pret) {
		super();
		this.id = id;
		this.fel1 = fel1;
		this.fel2 = fel2;
		this.desert = desert;
		this.pret = pret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFel1() {
		return fel1;
	}
	public void setFel1(String fel1) {
		this.fel1 = fel1;
	}
	public String getFel2() {
		return fel2;
	}
	public void setFel2(String fel2) {
		this.fel2 = fel2;
	}
	public String getDesert() {
		return desert;
	}
	public void setDesert(String desert) {
		this.desert = desert;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	
}
