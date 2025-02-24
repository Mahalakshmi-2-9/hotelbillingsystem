public class PriceList {
    public static Item[] getVegMenu() {
        return new Item[] {
            new Item("Paneer Butter Masala", 180, true,false),
            new Item("Veg Biryani", 120, true,false),
            new Item("Gobi Manchurian", 150, true,false),
            new Item("Paneer Veg Fried Rice", 120, true, false),
        };
    }

    public static Item[] getNonVegMenu() {
        return new Item[] {
            new Item("Chicken Biryani", 150, false,true),
            new Item("Mutton Biryani", 200, false,true),
            new Item("Chicken Tandoori", 225, false,true),
            new Item("Chicken Fried Rice", 160, false,true),
        };
    }
}
