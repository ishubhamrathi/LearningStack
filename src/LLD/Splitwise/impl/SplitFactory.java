package LLD.Splitwise.impl;

import LLD.Splitwise.ExpenseSplit;
import LLD.Splitwise.models.ExpenseSplitType;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnEqualExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> null;
        };
    }
}
