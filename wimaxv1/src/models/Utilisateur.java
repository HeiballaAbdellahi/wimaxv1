	package models;

public class Utilisateur {
		
		private int id ;
		private int cdma;
		private int nbrbackoff;
		private String classe ;
		private int delai;
		private double fileSize ;
		private int nbrs;
		private boolean susces;
		private boolean reject;
		private boolean drap;

		
		public Utilisateur(int id) {
		    this.nbrs=0;
			this.classe="";
			this.id = id;
			this.cdma=0;
			this.nbrbackoff=0;
			this.delai=0;
			this.fileSize=0;
			this.susces=false;
			this.reject=false;
			this.drap=false;

			
		}
		
		
	

	 public Utilisateur(String c,int i,int cd,int bf,int d ,double f,int nbrs)	{
		    this.classe=c;
			this.id = i;
			this.cdma=cd;
			this.nbrbackoff=bf;
			this.delai=d;
			this.fileSize=f;
			this.nbrs=nbrs;
			this.susces=false;
			this.reject=false;
			this.drap=false;

	 }
		
	
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCdma() {
			return cdma;
		}
		public void setCdma(int cdma) {
			this.cdma = cdma;
		}
		public int getNbrbackoff() {
			return nbrbackoff;
		}
		public void setNbrbackoff(int nbrbackoff) {
			this.nbrbackoff = nbrbackoff;
		}
		
		
		public int getDelai() {
			return delai;
		}
		public void setDelai(int delai) {
			this.delai = delai;
		}
	
		
		public double getFileSize() {
			return fileSize;
		}

		public void setFileSize(double fileSize) {
			this.fileSize = fileSize;
		}
		
		
		
		 public void suppUser(){
		        this.cdma = 0;
		        this.classe="";
		        this.delai = 0;
		        this.nbrbackoff = 0;
		        this.fileSize=0;
		        this.susces=false;
		        
		        
		    }





		public String getClasse() {
			return classe;
		}





		public void setClasse(String classe) {
			this.classe = classe;
		}


		public int getNbrs() {
			return nbrs;
		}


		public void setNbrs(int nbrs) {
			this.nbrs = nbrs;
		}




		public boolean isSusces() {
			return susces;
		}




		public void setSusces(boolean susces) {
			this.susces = susces;
		}




		public boolean isReject() {
			return reject;
		}




		public void setReject(boolean reject) {
			this.reject = reject;
		}




		public boolean isDrap() {
			return drap;
		}




		public void setDrap(boolean drap) {
			this.drap = drap;
		}

	
	}
