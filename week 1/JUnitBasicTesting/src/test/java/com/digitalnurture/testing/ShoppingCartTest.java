package com.digitalnurture.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ShoppingCartTest {

    private ShoppingCart cart;

    // Set up the test fixture
    @Before
    public void setUp() {
        cart = new ShoppingCart();
        cart.addItem("Apple");
        cart.addItem("Banana");
    }

    // Tear down the test fixture
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
