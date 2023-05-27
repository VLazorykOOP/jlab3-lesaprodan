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

import java.util.Scanner;

abstract class Series {
    protected double firstTerm;
    protected double commonDifferenceOrRatio;

    public abstract double getNthTerm(int n);
    public abstract double getSum(int n);
}

class Linear extends Series {
    public Linear(double firstTerm, double commonDifference) {
        this.firstTerm = firstTerm;
        this.commonDifferenceOrRatio = commonDifference;
    }
    
    @Override
    public double getNthTerm(int n) {
        return firstTerm + (n - 1) * commonDifferenceOrRatio;
    }
    
    @Override
    public double getSum(int n) {
        return (n / 2.0) * (2 * firstTerm + (n - 1) * commonDifferenceOrRatio);
    }
    
    @Override
    public String toString() {
        return "Linear series: first term = " + firstTerm + ", common difference = " + commonDifferenceOrRatio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Linear other = (Linear) obj;
        return Double.compare(other.firstTerm, firstTerm) == 0 && 
               Double.compare(other.commonDifferenceOrRatio, commonDifferenceOrRatio) == 0;
    }
}

class Exponential extends Series {
    public Exponential(double firstTerm, double commonRatio) {
        this.firstTerm = firstTerm;
        this.commonDifferenceOrRatio = commonRatio;
    }
    
    @Override
    public double getNthTerm(int n) {
        return firstTerm * Math.pow(commonDifferenceOrRatio, n - 1);
    }
    
    @Override
    public double getSum(int n) {
        if (commonDifferenceOrRatio == 1) {
            return n * firstTerm;
        } else {
            return firstTerm * (Math.pow(commonDifferenceOrRatio, n) - 1) / (commonDifferenceOrRatio - 1);
        }
    }
    
    @Override
    public String toString() {
        return "Exponential series: first term = " + firstTerm + ", common ratio = " + commonDifferenceOrRatio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Exponential other = (Exponential) obj;
        return Double.compare(other.firstTerm, firstTerm) == 0 && 
               Double.compare(other.commonDifferenceOrRatio, commonDifferenceOrRatio) == 0;
    }
}

public class lab32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first term:");
        double firstTerm = scanner.nextDouble();
        
        System.out.println("Enter the common difference (for linear series) or common ratio (for exponential series):");
        double commonDifferenceOrRatio = scanner.nextDouble();
        
        Series[] seriesArray = new Series[2];
        
        seriesArray[0] = new Linear(firstTerm, commonDifferenceOrRatio);
        seriesArray[1] = new Exponential(firstTerm, commonDifferenceOrRatio);
        
        for (Series series : seriesArray) {
            System.out.println(series.toString());
            System.out.println("Enter the value of n:");
            int n = scanner.nextInt();
            
            System.out.println("Nth term: " + series.getNthTerm(n));
            System.out.println("Sum of the first " + n + " terms: " + series.getSum(n));
            System.out.println();
        }
        
        scanner.close();
    }
}

