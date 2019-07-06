package wimax.view;


import java.util.Arrays;
import java.util.List;

import Gestionusers.ControllerUsers;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import models.CycleStatistics;


public class controller {











	@FXML
	private BorderPane yy;

	@FXML
	private TextField poolressources;

	@FXML
	private TextField nbrUsers;

	@FXML
	private TextField nbrCycle;

	@FXML
	private TextField cdmaRT;

	@FXML
	private TextField cdmaNRT;

	@FXML
	private TextField cdmaBE;

	@FXML
	private TextField R;

	@FXML
	private TextField NRTbf;

	@FXML
	private TextField BEbf;

	@FXML
	private Button Start;

	@FXML
	private Button totComm;

	@FXML
	private TextField resTotComm;

	@FXML
	private Button seccComm;

	@FXML
	private TextField resSuccComm;

	@FXML
	private Button fieldComm;

	@FXML
	private TextField resFieldComm;

	@FXML
	private Button collComm;

	@FXML
	private TextField resCollComm;

	@FXML
	private TextField backComm;

	 @FXML
	 private TextField cycle;
	
	
	 @FXML
	 private StackedBarChart<String, Number> chart12;


	@FXML
	private CategoryAxis x;

	@FXML
	private NumberAxis y;

	@FXML
	private PieChart piechart1;
	
	
	@FXML
    private LineChart<String , Number> chart1;

    @FXML
    private CategoryAxis x1;

    @FXML
    private NumberAxis x2;


	@FXML
	private void handleButton2Action(ActionEvent event) {


	}
	
	  @FXML
	    void stat(ActionEvent event) {
		  chart12.getData().clear();
		  
			int rp=Integer.parseInt(poolressources.getText());
			int nbrusers=Integer.parseInt(nbrUsers.getText());
			int nbrC=Integer.parseInt(nbrCycle.getText());
			int cdmaRTl=Integer.parseInt(cdmaRT.getText());
			int cdmaNRTl=Integer.parseInt(cdmaNRT.getText());
			int cdmaBEl=Integer.parseInt(cdmaBE.getText());
			int cycle1= Integer.parseInt(cycle.getText());

			int RTbfl=Integer.parseInt(R.getText());
			int NRTbfl=Integer.parseInt(NRTbf.getText());
			int BEbfl=Integer.parseInt(BEbf.getText());


			ControllerUsers con =new ControllerUsers(nbrusers,rp, cdmaRTl, cdmaNRTl, cdmaBEl,RTbfl,NRTbfl,BEbfl,nbrC);


			con.classeuser(nbrC);
			con.clalcule();
			con.Collision(nbrC);

			
			
			con.GestionRessource();	

			
			
			
			
			
			
			
			
			


//			ChartL1.getData().clear();
			XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

			 String 	cyc = "Cycle : "+cycle.getText();
		     

		    
		     x.setLabel("Cycle/Users");
		     
		     CycleStatistics st []=new CycleStatistics[nbrusers];
		     int val1=0,val2=0,val3=0;

				for(int a=0;a<nbrusers;a++) {
					
					st[a]=new CycleStatistics();
//					System.out.print(con.statistique[a].getNumcycle()+"**");
						if(con.statistique[a].getNumcycle()==cycle1) {
							
							if(con.statistique[a].getTypeclasse().equals("Real Time")) {
								val1++;

								
							}
							
							if(con.statistique[a].getTypeclasse().equals("Non Real Time")) {
								val2++;
							}
							
							if(con.statistique[a].getTypeclasse().equals("Best Effort")) {
								val3++;

							}
						}
							
					
					 
				}

		     
		    
		     x.setCategories(FXCollections.<String>observableArrayList( Arrays.asList(cyc,"")));

	             
	            
	        
				System.out.println(val1);
				System.out.println();
				System.out.println(val2);
				System.out.println();
				System.out.println(val3);

		    	 
		    	 final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
	    		 final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
	    		 final XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();

		    	 y.setLabel("Value");
			        series1.setName("Real Time");
			        series1.getData().add(new XYChart.Data<String, Number>(cyc, val1));
			        
			        series2.setName("Non Real Time");
			        series2.getData().add(new XYChart.Data<String, Number>(cyc,val2));
			        
			        
			        series3.setName("Best Effort");
			        series3.getData().add(new XYChart.Data<String, Number>(cyc, val3));
			        
			        
			        
			       
			        
			        
			        chart12.getData().addAll(series1, series2, series3);
				
		 	
		     
	    }
	
	
	
	
	
	 
	

	@FXML
	private void ButtonClearAction(ActionEvent event) {
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList();
		piechart1.setTitle("");
		piechart1.setData(pieChartData);
		chart12.getData().clear();
		chart1.getData().clear();
		resSuccComm.setText("00");
		resCollComm.setText("00");
		backComm.setText("00");
		resTotComm.setText("00");
		resFieldComm.setText("00");

	}


	@FXML
	void function(ActionEvent E) {






		int rp=Integer.parseInt(poolressources.getText());
		int nbrusers=Integer.parseInt(nbrUsers.getText());
		int nbrC=Integer.parseInt(nbrCycle.getText());
		int cdmaRTl=Integer.parseInt(cdmaRT.getText());
		int cdmaNRTl=Integer.parseInt(cdmaNRT.getText());
		int cdmaBEl=Integer.parseInt(cdmaBE.getText());
		int cycle1= Integer.parseInt(cycle.getText());

		int RTbfl=Integer.parseInt(R.getText());
		int NRTbfl=Integer.parseInt(NRTbf.getText());
		int BEbfl=Integer.parseInt(BEbf.getText());


		ControllerUsers con =new ControllerUsers(nbrusers,rp, cdmaRTl, cdmaNRTl, cdmaBEl,RTbfl,NRTbfl,BEbfl,nbrC);


		con.classeuser(nbrC);
		con.clalcule();
		con.Collision(nbrC);

		
		
		con.GestionRessource();	

		
		int colli=0;
		int succ=0;
		int faild=0;
		int backoff=0;
		
		
		for(int a=0;a<nbrusers;a++) {
			
			
			
			
			backoff +=con.statistique[a].getBf();
			faild +=con.statistique[a].getReject();
            colli+=con.statistique[a].getColl();
		}
		
		succ=con.users.length-faild;
		
		String coll=String.valueOf(colli);
		resCollComm.setText(coll);
		
		String bf=String.valueOf(backoff);
		backComm.setText(bf);
		
		String fail=String.valueOf(faild);
		resFieldComm.setText(fail);
				
		String totcomm =String.valueOf(colli+succ+faild);
		resTotComm.setText(totcomm);
		
		String secc=String.valueOf(succ);
		resSuccComm.setText(secc);
		
		
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Real Time", con.clss[0]),
						new PieChart.Data("Non Real Time", con.clss[1]),
						new PieChart.Data("Best Effort", con.clss[2]));

		piechart1.setTitle("Classification  ");
		piechart1.setData(pieChartData);


		chart12.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

		 String 	cyc = "Cycle : "+cycle.getText();
	     

	    
	     x.setLabel("Cycle/Users");
	     
	     CycleStatistics st []=new CycleStatistics[nbrusers];
	     int val1=0,val2=0,val3=0;

			for(int a=0;a<nbrusers;a++) {
				
				st[a]=new CycleStatistics();
					if(con.statistique[a].getNumcycle()==cycle1) {
						
						if(con.statistique[a].getTypeclasse().equals("Real Time")) {
							val1++;

							
						}
						
						if(con.statistique[a].getTypeclasse().equals("Non Real Time")) {
							val2++;
						}
						
						if(con.statistique[a].getTypeclasse().equals("Best Effort")) {
							val3++;

						}
					}
						
				
				 
			}

	     
	    
	     x.setCategories(FXCollections.<String>observableArrayList( Arrays.asList(cyc,"")));

             
            
        
			

	    	 
	    	 final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
    		 final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
    		 final XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();

	    	 y.setLabel("Value");
		        series1.setName("Real Time");
		        series1.getData().add(new XYChart.Data<String, Number>(cyc, val1));
		        
		        series2.setName("Non Real Time");
		        series2.getData().add(new XYChart.Data<String, Number>(cyc,val2));
		        
		        
		        series3.setName("Best Effort");
		        series3.getData().add(new XYChart.Data<String, Number>(cyc, val3));
		        
		        
		        
		       
		        
		        
		        chart12.getData().addAll(series1, series2, series3);
			
	 	
	     
	   

		        x1.setLabel("Cycles ");
		       
		        x2.setLabel("Numbers users");
		        
		        //creating the chart
		     
		        chart1.setTitle("Number of Classes Users /Cycles");

		        XYChart.Series<String, Number> series5 = new XYChart.Series<String, Number>();
		        XYChart.Series<String, Number> series6 = new XYChart.Series<String, Number>();
		        XYChart.Series<String, Number> series7 = new XYChart.Series<String, Number>();

		        series5.setName("Real Time");
		        series6.setName("Non Real Time");
		        series7.setName("Best Effort");

		        
		     for(int j=0;j<nbrC;j++) {
		    	 int a=0,b=0,c=0;
		    	 String ch =String.valueOf(con.statistique[j].getNumcycle());
		        for(int i=0;i<nbrusers;i++) {
		        	if(con.statistique[i].getNumcycle()==j) {
		        		if(con.statistique[i].getTypeclasse().equals("Real Time"))
			        	a++;
		        		if(con.statistique[i].getTypeclasse().equals("Non Real Time"))
			        	b++;
		        		if(con.statistique[i].getTypeclasse().equals("Best Effort"))
			        	c++;
		        	}
		        	
		        }
			        series5.getData().add(new XYChart.Data<String, Number>(ch, a));
			        series6.getData().add(new XYChart.Data<String, Number>(ch, b));
			        series7.getData().add(new XYChart.Data<String, Number>(ch, c));

		       
		     }
		     
		    
		      chart1.getData().addAll(series5,series6,series7);

		   
	       
		
		

		
	    
	 
		
		
		
		Timeline tl = new Timeline();
		tl.getKeyFrames().add(
		new KeyFrame(Duration.millis(500), 
		    new EventHandler<ActionEvent>() {
		        @Override public void handle(ActionEvent actionEvent) {
		            for (Series<String, Number> series : chart12.getData()) {
		                for (Data<String, Number> data : series.getData()) {
		                    data.setExtraValue(Math.random() * 1000);
		                }
		            }
		        }
		     }
		));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.setAutoReverse(true);
		tl.play();
		
		

//		series.setName("Usser Real Time");
//		ChartL1.getData().add(series);

	}
}
