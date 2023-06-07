package proj;
//implemented by:  Moath AbdAlbaqi

import java.util.ArrayList;
import java.util.Collections;

import javax.crypto.CipherInputStream;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DriverFX extends Application {
	ArrayList<PizzaOrder> orders = new ArrayList<>();
		Stage stages ;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		 Pane pa = new Pane();
		  Stage st = new Stage();
		  
		  Scene s = new Scene(pa,300,300);
		   st.setScene(s);
		    st.show();
		  Label la= new Label("Welcome, Welcome!");
		  Button b1 = new Button("Enter the shop.");
		   
		   
		  la.setLayoutX(100);
		  la.setLayoutY(80);
		   b1.setLayoutX(105);
		   b1.setLayoutY(140);
		  
		   
		   pa.getChildren().addAll(la,b1);
		   
		  b1.setOnAction(e->{
			  st.close();
			   stage.show();
		  });
		    
		  
		
				  
		stages = new Stage();
		GridPane gpane = new GridPane();
		gpane.setHgap(15);
		gpane.setVgap(15);
		gpane.add(new Label("Customer Name: "), 0, 0);
		gpane.add(new Label("Order type: "), 0, 1);
		gpane.add(new Label("Pizza size: "), 0, 2);
		gpane.add(new Label("Toppings: "), 0, 3);

		
		
		
		TextField tf1 = new TextField();

		gpane.add(tf1, 1, 0);

		ComboBox<String> cbox = new ComboBox<>();
		cbox.getItems().addAll("Delivery", "Seated", "ToGo");
		 cbox.setValue("ToGo");
		gpane.add(cbox, 1, 1);

		RadioButton rbs = new RadioButton("SMALL");
		rbs.setSelected(true);
		RadioButton rbm = new RadioButton("MEDIUM");
		RadioButton rbl = new RadioButton("LARGE");
		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(rbs, rbm, rbl);
		HBox h = new HBox(20);
		h.getChildren().addAll(rbs, rbm, rbl);
		gpane.add(h, 1, 2);
		
		CheckBox cbon = new CheckBox("Onion");
		CheckBox cbol = new CheckBox("Olive"); 
		CheckBox cbpa = new CheckBox("Green Paper");
		 HBox h2 = new HBox(20);
		 h2.getChildren().addAll(cbon,cbol,cbpa);
		  gpane.add(h2, 1, 3);
		
		  
		  Label tp = new Label("toppingPrice: ");
		   TextField ttp = new TextField("10");
		    gpane.add(tp, 0, 4);
		     gpane.add(ttp, 1, 4);
		    
		 Label orderprice = new Label("Order Price: ");
		  TextField top= new TextField("0.0");
		   gpane.add(orderprice,0,7);
		    gpane.add(top, 1, 7);
		  
		  Label ltriprate = new Label("tripRate: ");
		   TextField ttriprate = new TextField();
		     HBox ht= new HBox();
		      ht.getChildren().addAll(ltriprate,ttriprate);
		  Label lzone = new Label("Zone: ");
		   TextField tzone = new TextField();
		     HBox hz = new HBox();
		      hz.getChildren().addAll(lzone,tzone);
		      VBox v1 = new VBox();
		       v1.getChildren().addAll(ht,hz);
		      
		       
		       Label lservicecharge = new Label("servicecharge");
		        TextField tservicecharge = new TextField();
		         
		          
		        Label lnumberofpeople = new Label("numberofpeople");
		         TextField tnumberofpeople = new TextField();
		          
		          
		          
		      cbox.setOnAction(e->{
		    	  if(cbox.getValue()=="Delivery") {
		    		  gpane.getChildren().remove(lnumberofpeople);
		    		  gpane.getChildren().remove(tnumberofpeople);
		    		  gpane.getChildren().remove(lservicecharge);
		    		  gpane.getChildren().remove(tservicecharge);
		    		  gpane.add(ltriprate, 0, 5);
		    		   gpane.add(lzone, 0, 6);
		    		   gpane.add(ttriprate, 1, 5);
		    		   gpane.add(tzone, 1, 6);
		    		    
		    	  }
		    	  else if (cbox.getValue()=="Seated") {
		    		  gpane.getChildren().remove(ltriprate);
		    		  gpane.getChildren().remove(lzone);
		    		  gpane.getChildren().remove(ttriprate);
		    		  gpane.getChildren().remove(tzone);
		    		  gpane.add(lservicecharge, 0, 5);
		    		   gpane.add(lnumberofpeople, 0, 6);
		    		   gpane.add(tservicecharge, 1, 5);
		    		   gpane.add(tnumberofpeople, 1, 6);
		    	  }
		    	  else if(cbox.getValue()=="ToGo") {
		    		  gpane.getChildren().remove(ltriprate);
		    		  gpane.getChildren().remove(lzone);
		    		  gpane.getChildren().remove(ttriprate);
		    		  gpane.getChildren().remove(tzone);
		    		  gpane.getChildren().remove(lnumberofpeople);
		    		  gpane.getChildren().remove(tnumberofpeople);
		    		  gpane.getChildren().remove(lservicecharge);
		    		  gpane.getChildren().remove(tservicecharge);
		    	  }
		    	  
		      });
		      
		 // String name = tf1.getText();
		  
		  
		  Button btprice = new Button("ProcessOrder");
		   Button btprint = new Button("PrintOrders");
		    Button btreset = new Button("Reset");
		    HBox h3 = new HBox(20);
		     h3.getChildren().addAll(btprice,btprint,btreset);
		     gpane.add(h3, 1,8);
		       
		     
		     btprice.setOnAction(e->{
		    	 
		    	int size =1;
		    	 int numberoftopping=0;
		    	
		    	 if (rbs.isSelected()) size =1;
		    	 else if(rbm.isSelected())size = 2;
		    	 else if (rbl.isSelected())size = 3;
		    	 
		    	 if(cbon.isSelected()&&cbol.isSelected()&&cbpa.isSelected())numberoftopping=3;
		    	 else if(cbon.isSelected()==false&&cbol.isSelected()==false&&cbpa.isSelected()==false)numberoftopping=0;
		    	 else if((cbon.isSelected()==true&&cbol.isSelected()==false&&cbpa.isSelected()==false)||(cbon.isSelected()==false&&cbol.isSelected()==true&&cbpa.isSelected()==false)||(cbon.isSelected()==false&&cbol.isSelected()==false&&cbpa.isSelected()==true))
		    	  numberoftopping=1;
		    	 else numberoftopping=2;
		    	 cbox.getValue();  
		    	// orders.add(new PizzaOrder(tf1.getText(),size , numberoftopping, Double.parseDouble(tp.getText())));
		    	  if(cbox.getValue()=="ToGo") {
		    		  orders.add(new ToGo(tf1.getText(),size , numberoftopping, Double.parseDouble(ttp.getText())));
		    	  }
		    	  else if(cbox.getValue()=="Seated"){
		    		  orders.add(new Seated(tf1.getText(),size , numberoftopping, Double.parseDouble(ttp.getText()),Double.parseDouble(tservicecharge.getText()),Integer.parseInt(tnumberofpeople.getText())));
		    	  }
		    	  else {
		    		  orders.add(new Delivery(tf1.getText(),size , numberoftopping, Double.parseDouble(ttp.getText()),Double.parseDouble(ttriprate.getText()),Integer.parseInt(tzone.getText())));
		    	  }
		    	  top.setText(""+orders.get(orders.size()-1).calculateOrderPrice());
		    	  
		     });
		     
		     btprint.setOnAction(e->{
		    	 Pane pane1 = new Pane();
		    	 
		    	 ArrayList<PizzaOrder> temparr = new ArrayList<>();//I can sort the original one no problem.........
		    	  temparr = orders;
		    	   Collections.sort(temparr);
		    	    Label templabel = new Label();
		    	    
		    	    
		    	    String tempstr ="";
		    	     for(int i=0;i<temparr.size();i++)
		    	    	  tempstr += temparr.get(i).printOrderInfo();
		    	   templabel.setText(tempstr);
		    	  pane1.getChildren().addAll(templabel);
		    	  Scene scenes= new Scene(pane1,200,300);
		    	 stages.setScene(scenes);
		    	  stages.show();
		    	 
		     });
		     
		     btreset.setOnAction(e->{
		    	  tf1.setText(" ");
		    	   cbox.setValue("ToGo");
		    	   rbs.setSelected(true);
		    	  cbon.setSelected(false);
		    	  cbol.setSelected(false);
		    	  cbpa.setSelected(false);
		    	   top.setText("0.0");
		    	   ArrayList<PizzaOrder> arr = new ArrayList<>();
		    	   orders=arr;
		     });
		  
		  Label fin= new Label("MoathPizzas©");
		   gpane.add(fin, 0, 14);
		   
		 
		   
		    

		Scene scene = new Scene(gpane, 450, 400);
		//stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Pizza Store");
		//stage.show();

	}

}
