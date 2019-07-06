package models;

public class STAT {
	
	 private int numcycle;
	 private  int val;
	 private String typeclasse ;
	 
	 private int bf;
	 private int coll;
	 private int reject;
	
	 public int getBf() {
		return bf;
	}
	public void setBf(int bf) {
		this.bf = bf;
	}
	public int getColl() {
		return coll;
	}
	public void setColl(int coll) {
		this.coll = coll;
	}
	
	public int getReject() {
		return reject;
	}
	public void setReject(int reject) {
		this.reject = reject;
	}
	
	 
	 
	 
	 
	public STAT(int numcycle, int val, String typeclasse) {
		super();
		this.numcycle = numcycle;
		this.val = val;
		this.typeclasse = typeclasse;
	}
	public STAT() {
		super();
		this.typeclasse = "";
		this.bf=0;
		this.coll=0;
		this.numcycle=-1;
		this.reject=0;
		this.val=0;
		
		
	}

	public int getNumcycle() {
		return numcycle;
	}
	public void setNumcycle(int numcycle) {
		this.numcycle = numcycle;
	}
	
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	
	public String getTypeclasse() {
		return typeclasse;
	}
	public void setTypeclasse(String typeclasse) {
		this.typeclasse = typeclasse;
	}
} 
