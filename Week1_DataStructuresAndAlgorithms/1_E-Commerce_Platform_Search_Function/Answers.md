## Exercise 2: E-commerce Platform Search Function

### 🔹 Big O Notation
- Big O notation expresses the upper limit of an algorithm’s time or space complexity.  
- It shows how performance scales with input size.  
- Used to compare algorithms' efficiency regardless of hardware.  
- Helps identify best choice for large data handling.

### 🔹 Best, Average, and Worst-Case Scenarios for Search Operations

- **Best Case**: The element is found at the first position  
  - Linear Search: O(1)  
  - Binary Search: O(1)

- **Average Case**: The element is somewhere in the middle  
  - Linear Search: O(n)  
  - Binary Search: O(log n)

- **Worst Case**: The element is last or not present  
  - Linear Search: O(n)  
  - Binary Search: O(log n)

---

### 🔹 Compare the Time Complexity of Linear and Binary Search

| Algorithm         | Best Case | Average Case | Worst Case |
| ----------------- | --------- | ------------ | ---------- |
| **Linear Search** | O(1)      | O(n)         | O(n)       |
| **Binary Search** | O(1)      | O(log n)     | O(log n)   |

* **Linear Search** checks each element one by one.
* **Binary Search** repeatedly divides the sorted array and narrows the search range.

---

### 🔹 Which Algorithm Is More Suitable and Why?

* **Binary Search** is more suitable for an e-commerce platform where:

  * The product list is **sorted** (e.g., by `productId`).
  * Fast, frequent searches are required.
  * Time complexity is much better: **O(log n)** compared to **O(n)**.

* Use **Linear Search** only if:

  * Data is **unsorted**, or
  * Search needs to be performed on fields like `productName` or `category` where sorting may not help directly.

**Conclusion**: For optimized search performance in large datasets, **Binary Search** is preferred.
