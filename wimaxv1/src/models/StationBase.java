package models;

import java.util.Random;

import Gestionusers.*;

public class StationBase {

	private int id;
	private String name;
	int RP;
	public StationBase(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.RP = 950;
	}

	public void GestionRessource(ControllerUsers controller){

		int rt[]=new int[controller.users.length];
		int be[]=new int[controller.users.length];
		int nrt[]=new int[controller.users.length];

		int a=0,b=0,c=0;
		for(int j=0; j<controller.users.length ;j++) {

			if(controller.users[j].getClasse().equals("Real Time")) 
				rt[j]=j;
			a++;

			if(controller.users[j].getClasse().equals("Non Real Time"))
				nrt[j]=j;	
			b++;

			if(controller.users[j].getClasse().equals("Best Effort"))
				be[j]=j;
			c++;
		}



		

		
		boolean tst=true;	
		while(tst) {
			int capacity = RP ;
			int d = new Random().nextInt(a)+1;
			int e = new Random().nextInt(b)+1;
			int f = new Random().nextInt(c)+1;
            int k=new Random().nextInt(a+b+c)+1;
			int cap1=capacity-(d*10);
			int cap2=cap1/e+f;
			
			if(cap1<0) {
				System.out.println("insuffisante capacity  ");
			}
				
			
	     	
			for(int i=0; i < k; i++){
					
					
				if(controller.users[i].getFileSize()>=0 && controller.users[i].getClasse().equals("Real Time")) {
				controller.users[i].setFileSize(controller.users[i].getFileSize() - 10);
				 a--;
				}
				
				if(controller.users[i].getFileSize()>0&&controller.users[i].getClasse().equals("Non Real Time")) {
				controller.users[i].setFileSize(controller.users[i].getFileSize() - cap2);
				b--;
				}
				
				if(controller.users[i].getFileSize()>0&&controller.users[i].getClasse().equals("Best Effort")) {
				controller.users[i].setFileSize(controller.users[i].getFileSize() - cap2);
				c--;
				}
				
				
				if(controller.users[i].getFileSize()<=0)
					controller.users[i].suppUser();
				
				
				if(controller.users[i].getClasse().equals("")) {
					
				}

			}
			
			
			int t=0;

			for(int i=0; i < controller.users.length; i++){
				if(controller.users[i].getFileSize()<=0)
                  t++;
				
			     }
			   
			if (t==controller.users.length) {
				tst=false;
			}
		
		
		}


		

		
			
		
	}

}