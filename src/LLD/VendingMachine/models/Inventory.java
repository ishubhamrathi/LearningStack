package LLD.VendingMachine.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
    int itemCount;
    List<ItemShelf> inventory = new ArrayList<>();

    public Inventory(int itemCount) {
        this.itemCount = itemCount;
        for (int i = 0; i<=itemCount; i++) {
            Item item = new Item();
            ItemShelf itemShelf = new ItemShelf();
            inventory.add(itemShelf);
        }
    }


}
