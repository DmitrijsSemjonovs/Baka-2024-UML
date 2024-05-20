import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void restock(int amount) {
        this.stock += amount;
    }

    public boolean purchase(int amount) {
        if (amount <= this.stock) {
            this.stock -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

class Order {
    private Product product;
    private int quantity;
    private boolean isFulfilled;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.isFulfilled = false;
    }

    public boolean fulfillOrder() {
        if (product.purchase(quantity)) {
            this.isFulfilled = true;
            return true;
        }
        return false;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }
}

class Customer {
    private String name;
    private String email;
    private ArrayList<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        this.orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Store {
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;

    public Store() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addOrder(Order order) {
        if (order.fulfillOrder()) {
            this.orders.add(order);
        } else {
            System.out.println("Order cannot be fulfilled due to insufficient stock.");
        }
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

    public class Test {
    public static void main(String[] args) {
        Store myStore = new Store();
        Product apple = new Product("Apple", 0.99, 100);
        Product banana = new Product("Banana", 0.59, 150);
        myStore.addProduct(apple);
        myStore.addProduct(banana);

        Customer john = new Customer("John Doe", "john@example.com");
        myStore.addCustomer(john);

        Order johnsOrder = new Order(apple, 5);
        john.placeOrder(johnsOrder);
        myStore.addOrder(johnsOrder);

        for (Order order : myStore.getOrders()) {
            System.out.println("Order for " + order.getProduct().getName() + " x " + order.getQuantity() + " is " + (order.isFulfilled() ? "" : "not ") + "fulfilled");
        }


    }
}
