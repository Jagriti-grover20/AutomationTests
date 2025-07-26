package com.framework;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for mathematical calculator
 */
@DisplayName("Mathematical Calculator Tests")
public class MathematicalCalculator {

    @BeforeAll
    static void setup() {
        System.out.println("Starting Mathematical Calculator Test Suite...");
    }

    @AfterAll
    static void teardown() {
        System.out.println("Completed all calculator tests.");
    }

    @Test
    @DisplayName("Test Addition of Two Numbers")
    void testAddition() {
        int result = add(2, 2);
        assertEquals(4, result, "Addition failed: 2 + 2 should be 4");
    }

    @Test
    @DisplayName("Test Subtraction of Two Numbers")
    void testSubtraction() {
        int result = subtract(5, 3);
        assertEquals(2, result, "Subtraction failed: 5 - 3 should be 2");
    }

    @Test
    @DisplayName("Test Multiplication of Two Numbers")
    void testMultiplication() {
        int result = multiply(3, 4);
        assertEquals(12, result, "Multiplication failed: 3 * 4 should be 12");
    }

    @Test
    @DisplayName("Test Division of Two Numbers")
    void testDivision() {
        int result = divide(10, 2);
        assertEquals(5, result, "Division failed: 10 / 2 should be 5");
    }

    @Test
    @DisplayName("Test Division by Zero Throws Exception")
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> divide(5, 0),
                "Division by zero should throw ArithmeticException"
        );
        assertEquals("Cannot divide by zero", exception.getMessage(), "Expected custom exception message");
    }

    // ---------- Calculator Methods ----------

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}