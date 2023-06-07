package proj;



//Moath Wajeeh Abdalbaqi
//1210125
//S11
public class Seated extends PizzaOrder {
	private double serviceCharge;
	 private int numberOfPeople;
	
	
	public Seated() {}
	public Seated(String customerName,int size,int numberOfToppings,double toppingPrice,double serviceCharge,int numberOfPeople) {
		super(customerName,size, numberOfToppings, toppingPrice);
		 this.serviceCharge=serviceCharge;
		  this.numberOfPeople=numberOfPeople;
	}
	@Override
	public String toString() {
		return super.toString()+"Seated [serviceCharge=" + serviceCharge + ", numberOfPeople=" + numberOfPeople + "]";
	}
	@Override
	 // adding these value to orders price
	public double calculateOrderPrice(){
		double pr=super.calculateOrderPrice();
	     return pr+=serviceCharge * numberOfPeople;
		
	}
	 
}
