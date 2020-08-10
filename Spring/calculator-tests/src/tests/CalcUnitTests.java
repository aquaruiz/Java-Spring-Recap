package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Calculator;

public class CalcUnitTests {
	private Calculator calc;
	
	public CalcUnitTests() {
		calc = new Calculator();
	}
	
	@BeforeEach
//	@Before
	void setCalculator() {
		calc.setLeftOperand(1.0);	
		calc.setRightOperand(1.0);	
	}
	
    @Test
    @DisplayName("1 minus 1 should return 0")
    void subtractTwoPossitiveNumbers() {
    	calc.setOperator("-");
		double result = calc.calculateResult();
        assertEquals(0.0, result, 0.01);
        assertEquals("-", calc.getOperator());
    }
    
    @Test
    @DisplayName("5 divide by 1 should return 5")
    void divideTwoPossitiveNumbers() {
    	calc.setOperator("/");
    	calc.setLeftOperand(5.0);
		double result = calc.calculateResult();
        assertEquals(5.0, result, 0.01);
        assertEquals("/", calc.getOperator(), "it is division");
    }
    
    @Test
    @DisplayName("raise exception to be thrown")
    void raiseException() {
    	calc.setOperator("/");
    	calc.setRightOperand(0.0);
    	assertThrows(IllegalArgumentException.class, calc::calculateResult);
    }

    @Test
    @DisplayName("test with assumption")
    void pplaceAssumption() {
    	calc.setOperator("/");
    	calc.setRightOperand(0.0);
    	assumeTrue(calc.getOperator().equals(""));
    	assertThrows(IllegalArgumentException.class, calc::calculateResult);
    }

    
}
