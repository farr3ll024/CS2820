package Production;



import java.util.ArrayList;
import java.util.Random;

 


/* public class Order {
	 
	 public static ArrayList<String> OrderItem = new ArrayList();
	 
 
	  
	  String address;
	  OrderItem[] orderitems;
	  boolean isFilled;
	  /**
	   * @author Ted Herman
	   * @param addr is a shipping address for the order
	   * @param items is an array of OrderItem objects
	   */
	  /*public Order(String addr,OrderItem[] items) {
		address = addr;
		orderitems = items;
		isFilled = false;
	    }
	  }

*/

/* @author Ruben Chavez
 * 
 * last modified 11-14-16
 * @param String shipping address, ArrayList<String> of items ordered;
 * 
 * This will get item and shelf numbers for the items in the list of items from inventory;
 * It will give the Robot a shelf number to bring the picker,fetchItem();
 * pick and add it to the bin,
 * and tell the Robot that the shelf is ready to be taken away.  
 * Tell the belt that the bin is ready. 
 * 
 *  
 * 
 * 
 * 
 */
public class Order implements Clock, Document {

	
	//String buyerName;
	String shippingAddress;
	//int itemNumber;
	//int priorityValue;
	int shelfNumber;
	public ArrayList<String> orderItems = new ArrayList<String>();
	public ArrayList<Integer> orderNumbers = new ArrayList<Integer>();
	public ArrayList<String> orderBin = new ArrayList<String>();
	public ArrayList<Integer> shelfNumbers = new ArrayList<Integer>();
	public Boolean binFilled = false;
	public Boolean shelfReady = false;
	
	
	public Order(String address, ArrayList<String> items){
		
		//this.buyerName = name;
		this.shippingAddress = address;
		//this.itemNumber = item;
		//this.priorityValue = priority;
		//this.shelfNumber = shelf;
		
		//create list of items
		for (String item : items){
			this.orderItems.add(item);
		}
		
		//this.orderItems = items;
		
		
		int orderLength = items.size();
	}
	
	public ArrayList<Integer> getItemInfo(){
		for (String item : orderItems){
			// will get the item numbers for each item 
			//orderNumbers.add(Inventory.item.itemNumber);  Need a callable inventory list
			//shelfNumbers.add(Inventory.item.shelfNumber);
		}
            return null;
	}
	
	//add item to bin and set shelfReady to true so Robot can pick it up
	public void addToBin(String item){
		if (shelfReady == true){	
			orderBin.add(item);
			}
			shelfReady = false;
		}
	
	
	
	
	//shelfReady = True means it has been picked
	public Boolean shelfReady(){
		return shelfReady;
	}
		
		
	public Boolean binFilled(){
		if (orderBin.size() == orderItems.size()){
		binFilled = true;	
		}
		else binFilled = false;
		
		return binFilled;
	}
	
	/*int getValue(){
		//return InventoryList.shippingValue;
		return priorityValue;
	}*/
	
	/*int getItemNumber(){
		//return InventoryList.itemNumber;
		return itemNumber;
	
	}*/
	
	int getShelfNumber(){
		//return itemNumber.shelfNumber;
		return shelfNumber;
	}
	
	String getShippingAddress(){
		return shippingAddress;
	}
	
	public String randomAddress() {
		//this.R = R;
		String FirstName = randomFirstName();
		String LastName = randomLastName();
		String StreetNumber = new Integer(randomStreetNumber()).toString();
		String StreetName = randomStreetName();
		String City = randomCity();
		String State = randomState();
		String ZipCode = randomZip();
		String Address = FirstName + " " +
		  LastName + "\n" + StreetNumber + " " +
		  StreetName + "\n" + City + " " + State + ZipCode;
		return Address;
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a string containing a random street name
	   */
	  private String randomStreetName() {
		final String[] baseNames = {"Park Street",
				"Main Street", "Washington Boulevard",
				"Third Street", "Park Road",
				"Maple Street", "Hill Road"};
		
		//Random rand = null;
		Random ran = new Random(); 
		int x = ran.nextInt(baseNames.length);
		//int rn = rand.nextInt(baseNames.length);
		return baseNames[x];
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return an integer in the range [1,999] for street address
	   */
	  private int randomStreetNumber () {
		Random ran = new Random(); 
		int x = ran.nextInt(998);
		  return x;
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a random first name for an address
	   */
	  private String randomFirstName() {
		final String[] baseFirstNames = {"Dakota", "Emma",
				"Julian", "Nigella", "Will", "Asti", "Lee",
				"Pat", "Mavis", "Jerome", "Lilly", "Tess"};
		Random ran = new Random(); 
		int x = ran.nextInt(baseFirstNames.length);
		return baseFirstNames[x];
		}
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a random last name for an address
	   */
	  private String randomLastName() {
		final String[] baseLastNames = {"Parker","Mason",
					"Smith","Wright","Jefferson","Iqbal",
					"Owens","Lafleur","Metselen","Vinceroy",
					"Saville","Troitski","Andrews"};
		Random ran = new Random(); 
		int x = ran.nextInt(baseLastNames.length);
		return baseLastNames[x];
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a random city name
	   */
	  private String randomState() {
		final String[] baseState = {"IA","NE","MO",
					"IL","KS","MN","SD","AR","OK","TX"};
		Random ran = new Random(); 
		int x = ran.nextInt(baseState.length);
		return baseState[x];
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a random state code (two letters)
	   */
	  private String randomCity() {
		final String[] baseCity = {"Springfield","Clinton",
					"Madison","Franklin","Chester","Marion",
					"Greenville","Salem","Anytown","Hope"};
		Random ran = new Random(); 
		int x = ran.nextInt(baseCity.length);
		return baseCity[x];
	    }
	  /**
	   * @author Ruben Chavez modified from Ted Herman.MockOrders
	   * @return a random state code (two letters)
	   */
	  private String randomZip() {
	    String ZipCode = "";
	    Random ran = new Random(); 
		int x = ran.nextInt(10);
	    for (int i=0; i<6; i++) 
	    	
	      ZipCode += "0123456789".charAt(x);
	    return ZipCode;
	  }
}
	/*private static ArrayList<String> shippingAddressList = new ArrayList<String>();
		string addressNumber = order.mailingAddress;*/
//}*/