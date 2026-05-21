package LLD.VendingMachine.models;

public class Item {
    ItemType type;
    int price;

    public Item(ItemType itemType, int price) {
        this.type = itemType;
        this.price = price;
    }

    public int getPrice() { return this.price; }

    public ItemType getType() { return this.type; }

}
