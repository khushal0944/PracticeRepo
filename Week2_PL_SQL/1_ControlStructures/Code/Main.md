## Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
<u>**Question**</u>: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

### Scenerio 1 Code
```plsql
BEGIN
  FOR rec IN (
    SELECT l.LoanID, l.CustomerID, l.InterestRate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.ID
    WHERE c.Age > 60
  )
  LOOP
    UPDATE Loans 
    SET InterestRate = rec.InterestRate - 1
    WHERE LoanID = rec.LoanID;

    DBMS_OUTPUT.PUT_LINE('1% discount applied for ' || rec.Name || 
                         ' (Loan ID: ' || rec.LoanID || 
                         ') = Old Rate: ' || rec.InterestRate || 
                         '% -> New Rate: ' || (rec.InterestRate - 1) || '%');
  END LOOP;

  COMMIT;
END;
```

## Scenario 2: A customer can be promoted to VIP status based on their balance.
<u>**Question**</u>: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.

### Scenerio 2 Code

```plsql
BEGIN
  FOR rec IN (SELECT ID, Name, Balance FROM Customers WHERE Balance > 10000) 
  LOOP
    UPDATE Customers 
    SET IsVIP = 'TRUE' 
    WHERE ID = rec.ID;

    DBMS_OUTPUT.PUT_LINE(rec.Name || ' (Customer ID: ' || rec.ID || ') having Balance ' || rec.Balance ||' has been promoted to VIP status.');
  END LOOP;

  COMMIT;
END;
```

## Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
<u>**Question**</u>: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

### Scenerio 3 Code

```plsql
BEGIN
  FOR rec IN (
    SELECT c.Name, l.LoanID, l.DueDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.ID
    WHERE TRUNC(l.DueDate) BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ID ' || rec.LoanID ||
      ' for customer ' || rec.Name ||
      ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
```