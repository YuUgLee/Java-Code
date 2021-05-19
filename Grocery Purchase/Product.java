
public class Product {
	
	private String productSKU;
	private String productName;
	private String productSize;
	private double productPrice;
	
	/**
	 * creates a Product object with given name, size, and price
	 * @param productSKU - the SKU Number of this product
	 * @param productName - the name of this product 
	 * @param productSize - the size of this product as a string
	 * @param productPrice  - the price of this product as a double
	 * **/
	public Product(String productSKU, String productName, String productSize, double productPrice) {
		this.productSKU = productSKU;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}
	
	/**
	 * gets the name of the product
	 * @return the name as a String
	 * */
	public String getName() {
		return this.productName;
	}

	/***
	 * gets the SKU number of this product
	 * @return returns the number as a string
	 */
	public String getSKU() {
		return this.productSKU;
	}
	/***
	 * gets the size of product
	 * @return returns the size
	 */
	public String getSize() {
		return this.productSize;
	}

	/**
	 * gets the unit price
	 * @return the price
	 */
	public double getPrice() {
		return this.productPrice;
	}
	
	/**
	 * overrides toString() so that an object of this class is printed with the name, size, and price
	 * */
	public String toString() {
		return String.format("%-30s%-10s$%-10.2f", this.productName.substring(0, Math.min(25, this.productName.length())), 
				this.productSize.substring(0, Math.min(5, this.productSize.length())), 
				this.productPrice); 
	}
	
	/**
	 * overrides equals() so that two Product objects are considered equal if the
	 * strings representing their SKU numbers are equal
	 * */
	public boolean equals(Object other) {
		
		Product otherProduct = (Product) other;
		
		if(this.productSKU.equals(otherProduct.getSKU())) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("--------------PRODUCT TESTER-----------------");
		Product p = new Product("12354","Cookies", "12 dz", 3.50);
		System.out.println("Printing object: "+p);
		System.out.println("Expected: Cookies                       12 dz     $3.50");
	}

}
