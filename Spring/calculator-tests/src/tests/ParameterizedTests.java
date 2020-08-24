package tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import entity.Calculator;

class ParameterizedTests {
	private Calculator calc;
	
	@BeforeEach
	void setCalculator() {
		calc = new Calculator(1.0, 1.0, "-");
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {2, 3, 4})
//	@EnumSource
//	@CsvSource
	void testsWithParams(double operand) {
		calc.setRightOperand(operand);
		assertNotEquals(1.0, calc.getRightOperand());
	}
}
