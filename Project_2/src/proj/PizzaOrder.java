package proj;
//Moath Wajeeh Abdalbaqi
//1210125
//S11
import java.util.*;
public class  PizzaOrder implements Comparable<PizzaOrder>{
private String customerName;
private Date dateOrderd= new Date();
 // to call it by its name 
 final static int SMALL=1, MEDIUM=2, LARGE=3;
 
 private int size;
 private int numberOfToppings;
	private double toppingPrice;
	 
	
	PizzaOrder(){}
  PizzaOrder(String customerName,int size,int numberOfToppings,double toppingPrice){
  	this.customerName=customerName;
  	   this.size=size;
  	  this.numberOfToppings=numberOfToppings;
  	   this.toppingPrice=toppingPrice;
  	   
  }
  
  
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDateOrderd() {
		return dateOrderd;
	}
	public void setDateOrderd(Date dateOrderd) {
		this.dateOrderd = dateOrderd;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumberOfToppings() {
		return numberOfToppings;
	}
	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}
	public double getToppingPrice() {
		return toppingPrice;
	}
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	
	
	@Override
	public String toString() {
		return "\nCustomerName= " + customerName + "\nDateOrderd= " + dateOrderd + "\nNumberOfToppings= "
				+ numberOfToppings + "\nToppingPrice= "+toppingPrice;
	}
	//calculating pizza price
  public double calculateOrderPrice() {
  	double price= (this.numberOfToppings*this.toppingPrice)*this.size;
  	
  	
  	return price;
  }
  
  public String printOrderInfo() {
//  	System.out.println("name->"+this.customerName+" price->"+calculateOrderPrice());
	  return "Name->"+this.customerName+"---- Price->"+calculateOrderPrice()+"\n";
  }
  // this i think to override the original CompareTo function to compare by a specific things such as orders price 
  public int compareTo(PizzaOrder gg) {
  	return Double.compare(this.calculateOrderPrice(), gg.calculateOrderPrice());
  }
  
  
}
