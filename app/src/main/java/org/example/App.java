package org.example;

public class App {
    public static void main(String[] args) {
        ArrayStack<Dish> stack = new ArrayStack<>(5);

        Dish oneDish = new Dish("A dish with one fish pattern on it");
        Dish twoDish = new Dish("A dish with two fish patterns on it");
        Dish redDish = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        System.out.println("Initial size: " + stack.size()); // Expected: 0

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        System.out.println("Size after pushes: " + stack.size()); // Expected: 4

        Dish peekedDish = stack.peek();
        System.out.println("Peeked dish description: " + (peekedDish != null ? peekedDish.description : "null")); 
        // Expected: "A dish with a blue fish pattern on it"

        Dish poppedDish = stack.pop();
        System.out.println("Popped dish description: " + (poppedDish != null ? poppedDish.description : "null"));
        // Expected: "A dish with a blue fish pattern on it"

        Dish anotherPoppedDish = stack.pop();
        System.out.println("Another popped dish description: " + (anotherPoppedDish != null ? anotherPoppedDish.description : "null"));
        // Expected: "A dish with a red fish pattern on it"

        System.out.println("Final size: " + stack.size()); // Expected: 2

        // Test pushing beyond capacity
        Dish extraDish1 = new Dish("Extra dish 1");
        Dish extraDish2 = new Dish("Extra dish 2");
        Dish extraDish3 = new Dish("Extra dish 3");

        stack.push(extraDish1); // 3rd item
        stack.push(extraDish2); // 4th item
        stack.push(extraDish3); // 5th item (max capacity)
        stack.push(new Dish("Overflow dish")); // Should print stack full message

        System.out.println("Size after filling to max: " + stack.size()); // Expected: 5

        // Test clear method
        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Expected: 0

        // Test popping from empty stack
        stack.pop(); // Should print stack empty message

        // Test peeking from empty stack
        stack.peek(); // Should print stack empty message
    }
}
