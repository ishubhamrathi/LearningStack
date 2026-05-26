package LLD.Splitwise;

import LLD.Splitwise.controller.BalanceSheetController;
import LLD.Splitwise.controller.GroupController;
import LLD.Splitwise.controller.UserController;

public class Main {
    public static void main() {
        UserController userController = new UserController();
        GroupController groupController = new GroupController();
        BalanceSheetController balanceSheetController = new BalanceSheetController();
    }
}
