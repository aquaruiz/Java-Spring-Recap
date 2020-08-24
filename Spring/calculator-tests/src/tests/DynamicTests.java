package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import entity.Calculator;

class DynamicTests {
	private Calculator calc;
	
	@BeforeEach
	void setCalculator() {
		calc = new Calculator(1.0, 1.0, "-");
	}
	
	@TestFactory
	Collection<DynamicTest> testsFromColllection() {
		return Arrays.asList(
					dynamicTest("assert 0 == 0", () -> assertEquals(0, calc.calculateResult(), 0.01)),
					dynamicTest("assert 0 == 1", () -> assertEquals(1, calc.calculateResult(), 0.01)),
					dynamicTest("assert 0 == 0", () -> assertEquals(0, calc.calculateResult(), 0.01))

				);
	}

}
