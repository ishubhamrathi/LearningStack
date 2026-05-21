package LLD.VendingMachine.models;

public class ItemShelf {
    int code;
    Item item;
    boolean soldOut;

    public int getCode() { return  this.code; }

    public void setCode(int code) { this.code = code; }

    public Item getItem() {return  this.item; }

    public void setItem(Item item) {this.item = item; }

    public boolean isSoldOut() { return this.soldOut; }

    public void setSoldOut(boolean soldOut) { this.soldOut = soldOut; }
}
