public class Item{
    String name;
    double price;
    int quantity;
    boolean isVeg;
    boolean isnonveg;
   
      public Item(String name, double price, boolean isVeg,boolean isnonveg) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.isVeg = isVeg;
        }
    public Item(String string, int i, boolean b) {
		// TODO Auto-generated constructor stub
	}
	public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + "\t" + quantity + "\t\u20B9" + price + "\t\u20B9" + getTotal();
    }
}

