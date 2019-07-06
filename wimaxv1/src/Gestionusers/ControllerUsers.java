package Gestionusers;



import java.util.Random;

import models.*;


public class ControllerUsers {

	public Utilisateur users[] ;


	public STAT statistique[];



	public int RTL,NRTL,BEL;
	public int RTBFL,NRTBFL,BEBFL ;
	public int clss[]=new int [3];
	public int stat[];
	public int usersNumber ,rp;



	public ControllerUsers(int nbr,int rp, int rt,int nrt,int be,int RT,int NRT, int BE,int nbrC) {
		super();
		usersNumber=nbr;
		users=new Utilisateur[nbr];
		statistique=new STAT[nbr];
		stat=new int[nbrC];

		this.rp=rp;

		this.RTL=rt ;
		this.NRTL=nrt;
		this.BEL=be;

		this.RTBFL=RT;
		this.NRTBFL=NRT;
		this.BEBFL=BE;

		this.clss[0]=0;
		this.clss[1]=0;
		this.clss[2]=0;
	}






	public void classeuser( int cycleNumber){
		Random rand = new Random();


		for(int i=0;i<this.users.length;i++) {
			this.users[i]=new Utilisateur(i);
			int cr1 = rand.nextInt(3);
			this.statistique[i]=new STAT();
			if(cr1==0) {
				this.users[i]=new Utilisateur("Real Time",i,rand.nextInt(RTL+1),RTBFL,0,40,4);
				this.statistique[i].setTypeclasse("Real Time");

			}

			else if(cr1==1) {
				this.users[i]=new Utilisateur("Non Real Time",i,(rand.nextInt(NRTL+1)+RTL),NRTBFL,0,1750,0);
				this.statistique[i].setTypeclasse("Non Real Time");


			}

			else {
				this.users[i]=new Utilisateur("Best Effort",i,(rand.nextInt(BEL+1)+RTL+NRTL),BEBFL,0,1750,0);
				this.statistique[i].setTypeclasse("Best Effort");
			}



		}
	}


	public void Collision(int cycleNumber){


		
		for(int l = 0; l<cycleNumber;l++){
			
			Random rand = new Random();
			int tst=2*(rand.nextInt(users.length/10)+1);
            

			for(int i = 0; i<users.length;i++){
				
				
				
				if((tst>=0&&!this.users[i].isSusces()&&!this.users[i].isReject())&&this.users[i].getDelai()==0) {
					tst--;
					   
					for(int j = 0; j<users.length;j++){
						if((tst>=0&&!this.users[j].isSusces()&&!this.users[j].isReject())&&this.users[i].getDelai()==0) {
						
					    if(this.users[j].getDelai()>0) {
							this.users[j].setDelai(this.users[j].getDelai()-1);
							tst--;
						}

						int a =this.users[i].getCdma();
						int b =this.users[j].getCdma();
						
						boolean b1=this.users[j].isSusces();
						boolean b2=this.users[j].isReject();
						boolean b3=this.users[i].getClasse().equals(this.users[j].getClasse());
						boolean b4=this.users[j].getDelai()==0;
						boolean b5=this.users[j].getNbrbackoff()>0;

					   if(a==b && i!=j&&!b1&&!b2&&b3&&b4&&b5){
							this.users[j].setNbrbackoff(this.users[j].getNbrbackoff() - 1);
							this.users[i].setNbrbackoff(this.users[i].getNbrbackoff() - 1);

							this.statistique[i].setColl(this.statistique[i].getColl()+1);
							this.statistique[j].setColl(this.statistique[j].getColl()+1);
	                        

							if(this.users[j].getClasse().equals("Real Time")) {
		                        int cd=rand.nextInt(RTL+1);
		                        int cd1=rand.nextInt(RTL+1);
		                        users[j].setCdma(cd);
		                        users[i].setCdma(cd1);

		                    }
		                
		                
		                    if(this.users[j].getClasse().equals("Non Real Time")) {
		                        int cd=rand.nextInt(NRTL+1)+RTL;
		                        int cd1=rand.nextInt(NRTL+1)+RTL;
		                        users[j].setCdma(cd);
		                        users[i].setCdma(cd1);
		                    }


		                    if(this.users[j].getClasse().equals("Best Effort")) {
		                        int cd=rand.nextInt(BEL)+NRTL+RTL+1;
		                        int cd1=rand.nextInt(BEL)+NRTL+RTL+1;

		                        users[j].setCdma(cd);
		                        users[i].setCdma(cd1);
		                    }
							
							
		                    
		                    if(this.users[j].getNbrbackoff()>0 ){
		                        int delai =new Random().nextInt(usersNumber/10)+ 1;
		                        this.users[j].setDelai(delai);
		                        this.statistique[j].setBf(this.statistique[j].getBf()+1);
		                        
		                    }
		                    
		                    if(this.users[i].getNbrbackoff()>0 ){
		                        int delai =new Random().nextInt(usersNumber/10)+ 1;
		                        this.users[i].setDelai(delai);
		                        this.statistique[i].setBf(this.statistique[i].getBf()+1);
		                        
		                    }
		                    
							}
					   
					    if(this.users[i].getNbrbackoff()<=0)
	                         {
						   this.users[i].setReject(true);
						   this.statistique[i].setReject(1);
						   this.statistique[i].setNumcycle(-2);

					         }
					   
					 
					   
						
					   else if(b3&&a!=b&&this.users[i].getDelai()==0&&!this.users[i].isReject()&&!users[i].isDrap()){
						   this.users[i].setSusces(true);
						   this.statistique[i].setNumcycle(l);
						   this.users[i].setDrap(true);
						   
					     }
					   
					   
						}
					
					
				}//end for j
						
					 if(this.users[i].getNbrbackoff()<=0)
                           {
				   this.users[i].setReject(true);
				   this.statistique[i].setReject(1);
				   this.statistique[i].setNumcycle(-1);
			         }

				
				
				}
				 
				}//end for i 
			
			
			
				
			}//end cycle
		
		
		
		}//function fin 

	
	
	public boolean findblackList() {
		for(int i=0;i<this.users.length;i++) 
				if(this.users[i].isReject()||this.users[i].isSusces()) {
					return false;
				}
		return true;
	}
	
	
	
	public void clalcule(){

		for(int i=0; i < users.length; i++){

			if((users[i].getClasse().equals("Real Time")))
				this.clss[0]=this.clss[0]+1;

			if((users[i].getClasse().equals("Non Real Time")))
				this.clss[1]=this.clss[1]+1;

			if((users[i].getClasse().equals("Best Effort")))
				this.clss[2]=this.clss[1]+1;




		}



	}




	public void GestionRessource(){

		int rt[]=new int[this.users.length];
		int be[]=new int[this.users.length];
		int nrt[]=new int[this.users.length];
		Random rand = new Random();


		for(int j=0; j<this.users.length ;j++) {

			rt[j]=-1;
			nrt[j]=-1;
			be[j]=-1;
		}



		int a=0,b=0,c=0;
		for(int j=0; j<this.users.length ;j++) {

			if(this.users[j].getClasse().equals("Real Time")) {
				rt[a++]=j;

			}
			else if(this.users[j].getClasse().equals("Non Real Time")) {
				nrt[b++]=j;	

			}


			else if(this.users[j].getClasse().equals("Best Effort")) {
				be[c++]=j;

			}


		}



		a = rand.nextInt(a+1)+1;
		b = rand.nextInt(b+1)+1;
		c = rand.nextInt(c+1)+1;

		int cap1=10*this.rp;


		for(int l=0; l <users.length; l++){


			cap1=cap1-(a*40);
			int cap2=cap1/(b+c+1);

			if(cap1<0) {
				cap1=1000*(a+b+c+1);
				this.GestionRessource();

			}



			for(int i=0; i <a; i++){

				int ind = rt[i];

				if(rt[i]!=-1&&this.users[ind].getFileSize()>0 && this.users[ind].getClasse().equals("Real Time")) {
					this.users[ind].setFileSize(this.users[ind].getFileSize() - 10);
					if(this.users[ind].getFileSize()<=0) {
						this.users[ind].setFileSize(0);
						rt[i]=-1;
					}
				}





			}	

			for(int i=0; i <b; i++){	
				int ind = nrt[i];

				if(nrt[i]!=-1&&this.users[ind].getFileSize()>0 &&this.users[ind].getClasse().equals("Non Real Time")) {
					this.users[ind].setFileSize(this.users[ind].getFileSize() - cap2);
					if(this.users[ind].getFileSize()<=0) {
						this.users[ind].setFileSize(0);
						nrt[i]=-1;
					}
				}





			}



			for(int i=0; i <c; i++){
				int ind = be[i];


				if(be[i]!=-1&&this.users[ind].getFileSize()>0&&this.users[ind].getClasse().equals("Best Effort")) {
					this.users[ind].setFileSize(this.users[ind].getFileSize() - cap2);
					if(this.users[ind].getFileSize()<=0) {
						this.users[ind].setFileSize(0);
						be[i]=-1;
					}
				}




			}






			int t=0;
			for(int i=0; i < this.users.length; i++){
				if(this.users[i].getFileSize()==0)
					t++;

			}



			if (t==this.users.length) {
				break;
			}

			if(t<this.users.length) {
				l--;
			}
		}







	}

	public int findmin() {
		int min=0;
		int pos=0;
		for(int i=0; i < users.length; i++){
			min=this.users[i].getDelai();
			for(int j=i+1; j < users.length-1; j++){
				if(this.users[j].getDelai()<min) {
					min=this.users[j].getDelai();
					pos=j;
				}
			}
		}

		return pos ;

	}






}
