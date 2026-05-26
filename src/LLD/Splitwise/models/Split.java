package LLD.Splitwise.models;

public class Split {
    User user;
    public double amountOwe;

    public Split(User user, double amountOwe) {
        this.user = user;
        this.amountOwe = amountOwe;
    }
}
