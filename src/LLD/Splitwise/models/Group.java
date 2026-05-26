package LLD.Splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;

    public Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
    }
}
