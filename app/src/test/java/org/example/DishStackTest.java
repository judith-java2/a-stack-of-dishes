package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DishStackTest {

    private ArrayStack<Dish> stack;
    private final int STACK_CAPACITY = 3;

    @BeforeEach
    public void setUp() {
        stack = new ArrayStack<>(STACK_CAPACITY);
    }

    @Test
    public void testInitialStackIsEmpty() {
        assertEquals(0, stack.size(), "Stack should be empty initially");
        assertNull(stack.peek(), "Peek on empty stack should return null");
        assertNull(stack.pop(), "Pop on empty stack should return null");
    }

    @Test
    public void testPushAndSize() {
        stack.push(new Dish("Dish 1"));
        assertEquals(1, stack.size());
        stack.push(new Dish("Dish 2"));
        assertEquals(2, stack.size());
    }

    @Test
    public void testPeekDoesNotRemove() {
        Dish dish = new Dish("Dish for peek");
        stack.push(dish);
        assertEquals(dish, stack.peek());
        assertEquals(1, stack.size(), "Peek should not remove item");
    }

    @Test
    public void testPopRemovesAndReturnsLastItem() {
        Dish dish1 = new Dish("Dish 1");
        Dish dish2 = new Dish("Dish 2");
        stack.push(dish1);
        stack.push(dish2);

        Dish popped = stack.pop();
        assertEquals(dish2, popped);
        assertEquals(1, stack.size());

        popped = stack.pop();
        assertEquals(dish1, popped);
        assertEquals(0, stack.size());

        assertNull(stack.pop(), "Pop from empty stack should return null");
    }

    @Test
    public void testStackFullPreventsPush() {
        stack.push(new Dish("Dish 1"));
        stack.push(new Dish("Dish 2"));
        stack.push(new Dish("Dish 3"));
        assertEquals(STACK_CAPACITY, stack.size());

        // Capture console output if needed, here just check size doesn't increase
        stack.push(new Dish("Dish 4"));
        assertEquals(STACK_CAPACITY, stack.size(), "Stack size should not increase when full");
    }

    @Test
    public void testClearEmptiesStack() {
        stack.push(new Dish("Dish 1"));
        stack.push(new Dish("Dish 2"));
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    @Test
    public void testPushPopPeekSequence() {
        Dish d1 = new Dish("One fish");
        Dish d2 = new Dish("Two fish");
        Dish d3 = new Dish("Red fish");

        stack.push(d1);
        stack.push(d2);
        stack.push(d3);

        assertEquals(3, stack.size());

        assertEquals(d3, stack.peek());

        assertEquals(d3, stack.pop());
        assertEquals(2, stack.size());

        assertEquals(d2, stack.peek());

        stack.clear();
        assertEquals(0, stack.size());
    }
}
