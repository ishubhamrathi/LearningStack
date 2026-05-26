package LLD.VendingMachine.impl;

import LLD.VendingMachine.Coin;
import LLD.VendingMachine.State;
import LLD.VendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        IO.println("Currently vending machine is in idle state");
    }

    public IdleState(VendingMachine machine) throws Exception {
        IO.println("Currently vending machine is in IDLE State!");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
//        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine) throws Exception {

    }

    @Override
    public void choseProduct(VendingMachine machine) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine machine) throws Exception {

    }
}
