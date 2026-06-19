# JUnit Basic Testing Exercises - Final Report

**Project**: JUnit Basic Testing
**Author**: Digital Nurture Participant
**Framework**: Java 11, JUnit 4.13.2

---

## 1. Project File Structure
The project was structured using standard Maven conventions to ensure professional organization.

```text
JUnitBasicTesting/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/digitalnurture/testing/
│   │   ├── Calculator.java       (Exercise 1/2)
│   │   ├── ShoppingCart.java     (Exercise 4)
│   │   └── StringUtils.java      (Exercise 2)
│   └── test/java/com/digitalnurture/testing/
│       ├── AssertionsTest.java   (Exercise 3)
│       ├── CalculatorTest.java   (Exercise 1/2)
│       ├── ShoppingCartTest.java (Exercise 4)
│       └── StringUtilsTest.java  (Exercise 2)
```

---

## 2. Code Implementation (Screenshots / Source)

### Exercise 2: Basic Tests (`StringUtils` & `StringUtilsTest`)

**`StringUtils.java`**
```java
package com.digitalnurture.testing;

public class StringUtils {
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = reverse(input);
        return input.equals(reversed);
    }
}
```

**`StringUtilsTest.java`**
```java
package com.digitalnurture.testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringUtilsTest {
    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("cba", utils.reverse("abc"));
        assertEquals("", utils.reverse(""));
    }

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("racecar"));
        assertFalse(utils.isPalindrome("hello"));
    }
}
```

### Exercise 3: Assertions in JUnit (`AssertionsTest`)

**`AssertionsTest.java`**
```java
package com.digitalnurture.testing;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        // Assert true
        assertTrue(5 > 3);
        // Assert false
        assertFalse(5 < 3);
        // Assert null
        assertNull(null);
        // Assert not null
        assertNotNull(new Object());
    }
}
```

### Exercise 4: AAA Pattern & Setup/Teardown (`ShoppingCartTest`)

**`ShoppingCartTest.java`**
```java
package com.digitalnurture.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        cart.addItem("Apple");
        cart.addItem("Banana");
    }

    @After
    public void tearDown() {
        cart.clear();
        cart = null;
    }

    @Test
    public void testAddItem() {
        // Arrange
        String newItem = "Orange";
        
        // Act
        cart.addItem(newItem);
        
        // Assert
        assertEquals(3, cart.getItemCount());
        assertTrue(cart.contains(newItem));
    }

    @Test
    public void testRemoveItem() {
        // Arrange
        String itemToRemove = "Apple";
        
        // Act
        cart.removeItem(itemToRemove);
        
        // Assert
        assertEquals(1, cart.getItemCount());
        assertFalse(cart.contains(itemToRemove));
    }
}
```

---

## 3. Test Execution Output
All tests run successfully without any failures, proving the correctness of the logic and the setup.

```text
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.digitalnurture.testing.AssertionsTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.043 sec

Running com.digitalnurture.testing.CalculatorTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec

Running com.digitalnurture.testing.ShoppingCartTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec

Running com.digitalnurture.testing.StringUtilsTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec

Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
