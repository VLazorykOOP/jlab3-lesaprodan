// Суперклас
class Document {
    private String title;
    private String author;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void Show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}


class Receipt extends Document {
    private String issuer;
    private double amount;

    public Receipt(String title, String author, String issuer, double amount) {
        super(title, author);
        this.issuer = issuer;
        this.amount = amount;
    }

    public void Show() {
        super.Show();
        System.out.println("Issuer: " + issuer);
        System.out.println("Amount: " + amount);
    }
}

class Invoice extends Document {
    private String recipient;
    private double totalAmount;

    public Invoice(String title, String author, String recipient, double totalAmount) {
        super(title, author);
        this.recipient = recipient;
        this.totalAmount = totalAmount;
    }

    public void Show() {
        super.Show();
        System.out.println("Recipient: " + recipient);
        System.out.println("Total Amount: " + totalAmount);
    }
}
//
class Waybill extends Document {
    private String sender;
    private String receiver;

    public Waybill(String title, String author, String sender, String receiver) {
        super(title, author);
        this.sender = sender;
        this.receiver = receiver;
    }

    public void Show() {
        super.Show();
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
    }
}
class Bill extends Document {
    private String customer;
    private double amountDue;

    public Bill(String title, String author, String customer, double amountDue) {
        super(title, author);
        this.customer = customer;
        this.amountDue = amountDue;
    }

    public void Show() {
        super.Show();
        System.out.println("Customer: " + customer);
        System.out.println("Amount Due: " + amountDue);
    }
}

public class lab3 {
    public static void main(String[] args) {
        Document[] documents = new Document[4];
        documents[0] = new Receipt("Receipt 1", "John", "Company A", 100.0);
        documents[1] = new Invoice("Invoice 1", "Jane", "Company B", 500.0);
        documents[2] = new Waybill("Waybill 1", "Mike", "Company C", "Company D");
        documents[3] = new Bill("Bill 1", "Sarah", "Customer X", 2000.0);

        for (Document document : documents) {
            document.Show();
            System.out.println("-------------------");
        }
    }
}
