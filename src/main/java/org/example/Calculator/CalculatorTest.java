package org.example.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {

        // Тесты из Домашнего задания
        assertThat(Calculator.calculatingDiscount(100, 7)).isEqualTo(93);
        assertThat(Calculator.calculatingDiscount(0, 7)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(100, 0)).isEqualTo(100);
        assertThat(Calculator.calculatingDiscount(100, 100)).isEqualTo(0);
//        assertThat(Calculator.calculatingDiscount(100, 7)).isEqualTo(92);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 120))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1, 120))
                .isInstanceOf(ArithmeticException.class);
    }
}
