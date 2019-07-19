/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class CycleStatistics {
    
    private int cycleNumber, vrt,vnrt,vbe;
    private String classType;

    public CycleStatistics(int cycleNumber, int value, String classType, int vrt) {
        this.cycleNumber = cycleNumber;
        this.vrt= vrt;
        this.classType = classType;
    }
    
        public CycleStatistics(int cycleNumber) {
        this.cycleNumber = cycleNumber;
        this.vrt = 0;
        this.classType = "";
    }
    
    public CycleStatistics(int cycleNumber, int value) {
        this.cycleNumber = cycleNumber;
        this.vrt = value;
        this.classType = "";
    }

    public CycleStatistics() {
        this.cycleNumber = 0;
        this.vrt = 0;
        this.vbe=0;
        this.vnrt=0;
        this.classType = "";
    }

    public int getCycleNumber() {
        return cycleNumber;
    }

   

    public int getVrt() {
		return vrt;
	}

	public void setVrt(int vrt) {
		this.vrt = vrt;
	}

	public int getVnrt() {
		return vnrt;
	}

	public void setVnrt(int vnrt) {
		this.vnrt = vnrt;
	}

	public int getVbe() {
		return vbe;
	}

	public void setVbe(int vbe) {
		this.vbe = vbe;
	}

	public void setCycleNumber(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

 

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
    
    
    
    
    
}
