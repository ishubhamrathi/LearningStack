package LLD.Splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<User, Balance> userBalanceMap;
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        userBalanceMap = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }
}
