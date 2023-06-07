package proj;



//Moath Wajeeh Abdalbaqi
//1210125
//S11
public class Delivery extends PizzaOrder {
private double tripRate;
 private int zone;
	
 //construtors
 public Delivery() {}
 public Delivery(String customerName,int size,int numberOfToppings,double toppingPrice,double tripRate, int zone){
	   super(customerName,size, numberOfToppings, toppingPrice);
	   this.tripRate=tripRate;
	    this.zone=zone;
 }
 //setter and getters to this class
public double getTripRate() {
	return tripRate;
}
public void setTripRate(double tripRate) {
	this.tripRate = tripRate;
}
public int getZone() {
	return zone;
}
public void setZone(int zone) {
	this.zone = zone;
}

@Override
public String toString() {
	// this super is to call the original tostring in the superClass
	return super.toString()+"\nTripRate= " + tripRate + "\nZone= "+zone;
}
 /********************/
@Override
 public double calculateOrderPrice() {
	   double pr=super.calculateOrderPrice();
	   return pr+=((tripRate/100)* pr * zone);
 }
 

}

