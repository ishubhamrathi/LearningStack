package LLD.VendingMachine.impl;

import LLD.VendingMachine.State;
import LLD.VendingMachine.VendingMachine;

import java.util.ArrayList;

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
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click on insert coin button");
    }
}
