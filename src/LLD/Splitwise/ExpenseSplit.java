package LLD.Splitwise;

import LLD.Splitwise.models.Split;

import java.util.List;

public interface ExpenseSplit {

    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
