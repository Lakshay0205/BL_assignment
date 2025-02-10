abstract class Product implements Taxable {
    private String productname;
    private double price;
    private int productId;

    public Product(String productName, double price, int productId) {
        this.productname = productName;
        this.price = price;
        this.productId = productId;
    }

    public void getName(String productName) {
        this.productname = productName;
    }

    public String getName() {
        return productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return productId;
    }

    abstract double calculateDiscount();

    public double finalPrice() {
        return getPrice() - calculateDiscount()+ getTaxDetails();
    }

    public void displayDetails() {
        System.out.println("Product Name: " + productname);
        System.out.println("Product Id: " + productId);
        System.out.println("Product Price: " + finalPrice());
    }
}

class Electronics extends Product implements Taxable {
    private String productBrand;
    private double discount;
    private double tax;

    public Electronics(String productName, double price, int productId, String productBrand, double discount, double tax) {
        super(productName, price, productId);
        this.productBrand = productBrand;
        this.discount = discount;
        this.tax = tax;
    }

    public double calculateTax() {
        return getPrice() * getTaxDetails() / 100;
    }

    public double getTaxDetails() {
        return tax;
    }

    public void setBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getBrand() {
        return productBrand;
    }

    double calculateDiscount() {
        return getPrice() * getDiscount() / 100;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Product Brand: " + productBrand);
    }
}

class Clothing extends Product implements Taxable {
    private String clothBrand;
    private double discount;
    private double tax;

    public Clothing(String productName, double price, int productId, String clothBrand, double discount, double tax) {
        super(productName, price, productId);
        this.clothBrand = clothBrand;
        this.discount = discount;
        this.tax = tax;
    }

    public double calculateTax() {
        return getPrice() * getTaxDetails() / 100;
    }

    public double getTaxDetails() {
        return tax;
    }

    public void setBrand(String clothBrand) {
        this.clothBrand = clothBrand;
    }

    public String getBrand() {
        return clothBrand;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    double calculateDiscount() {
        return getPrice() * getDiscount() / 100;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Cloth Brand: " + clothBrand);
    }
}

interface Taxable {
    public double calculateTax();
    public double getTaxDetails();
}



public class ECommerce {
    public static void main(String[] args) {
        Clothing product = new Clothing("T-Shirt", 100.0, 1, "Nike", 10.0, 15.0);

        product.displayDetails();
    }
}