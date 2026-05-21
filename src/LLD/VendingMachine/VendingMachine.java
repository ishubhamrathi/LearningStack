package LLD.VendingMachine;

import LLD.VendingMachine.impl.IdleState;
import LLD.VendingMachine.models.Inventory;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    Inventory inventory;
    State state;
    List<Coin> coins;

    public VendingMachine() {
        inventory = new Inventory(10);
        state = new IdleState();
        coins = new ArrayList<>();
    }

    public Inventory getInventory() { return this.inventory; }

    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public State getVendingMachineState() { return this.state; }

    public void setVendingMachineState(State state) { this.state = state; }

    public List<Coin> getCoinList() { return this.coins; }

    public void setCoinList(List<Coin> coins) { this.coins = coins; }
}
