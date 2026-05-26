package LLD.Splitwise.models;

import java.util.UUID;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User user;

    public Expense(User user, String description, double expenseAmount) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.user = user;
    }
}
