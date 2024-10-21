// Target Interface
interface PaymentProcessor {
    void pay(String amount);
}

// Adaptee Class
class StripePayment {
    public void makePayment(String amount) {
        System.out.println("Payment of " + amount + " made through Stripe.");
    }
}

// Adapter Class
class StripePaymentAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripePaymentAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void pay(String amount) {
        stripePayment.makePayment(amount);
    }
}

// Existing Class
class PayPalPayment implements PaymentProcessor {
    @Override
    public void pay(String amount) {
        System.out.println("Payment of " + amount + " made through PayPal.");
    }
}

// Client Class
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using the existing PayPal payment system
        PaymentProcessor payPalPayment = new PayPalPayment();
        payPalPayment.pay("100 USD");

        // Using the new Stripe payment system through the adapter
        StripePayment stripePayment = new StripePayment();
        PaymentProcessor stripePaymentAdapter = new StripePaymentAdapter(stripePayment);
        stripePaymentAdapter.pay("200 USD");
    }
}
