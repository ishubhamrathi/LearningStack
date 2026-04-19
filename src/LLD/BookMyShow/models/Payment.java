package LLD.BookMyShow.models;

public class Payment {
    private static int idCounter = 1;

    private final int paymentId;
    private final double amount;
    private final PaymentStatus paymentStatus;

    public Payment(double amount, PaymentStatus paymentStatus) {
        this.paymentId = idCounter++;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
