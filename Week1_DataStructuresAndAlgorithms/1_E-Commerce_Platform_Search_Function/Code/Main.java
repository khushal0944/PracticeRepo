import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Main {
    // Linear Search by productId
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId)
                return p;
        }
        return null;
    }

    // Binary Search by productId (array must be sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId)
                return products[mid];
            else if (products[mid].productId < targetId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(102, "Shoes", "Footwear"),
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "T-shirt", "Clothing"),
                new Product(108, "Headphones", "Electronics"),
        };

        // Linear Search
        Product found1 = linearSearch(products, 101);
        System.out.println("Linear Search " + (found1 != null ? "Found : " + found1.productName : "Product Not found"));

        // For binary search: sort the array by productId
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Using Binary Search
        Product found2 = binarySearch(products, 104);
        System.out.println("Binary Search " + (found2 != null ? "Found : " + found2.productName : "Product Not found"));
    }
}
