import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    private Operations operation = new Operations();

    @org.junit.jupiter.api.Test
    void addPoly() {

        Polynomial term1 = new Polynomial("2x^2+3x+1");
        Polynomial term2 = new Polynomial("2x^2+3x+1");
        Polynomial expectedResult = new Polynomial("4x^2+6x+2");

        assertEquals(operation.addPoly(term1, term2), expectedResult);

        term1 = new Polynomial("2x^2+3x+1");
        term2 = new Polynomial("5.5+x^20");
        expectedResult = new Polynomial("x^20+2x^2+3x+6.5");

        assertEquals(operation.addPoly(term1, term2), expectedResult);

    }
    @org.junit.jupiter.api.Test
    void subtractPoly() {
        Polynomial term1 = new Polynomial("2x^2+3x+1");
        Polynomial term2 = new Polynomial("2x^2+3x+1");
        Polynomial expectedResult = new Polynomial("0");

        assertEquals(operation.subtractPoly(term1, term2), expectedResult);

        term1 = new Polynomial("2x^2+3x+1");
        term2 = new Polynomial("5+x^20+x^2");
        expectedResult = new Polynomial("-x^20+x^2+3x-4");

        assertEquals(operation.subtractPoly(term1, term2), expectedResult);

    }

    @org.junit.jupiter.api.Test
    void multiplyPoly() {
        Polynomial term1 = new Polynomial("2x^2+3x+1");
        Polynomial term2 = new Polynomial("x");
        Polynomial expectedResult = new Polynomial("2x^3+3x^2+x");

        assertEquals(operation.multiplyPoly(term1, term2), expectedResult);

        term1 = new Polynomial("2x-1");
        term2 = new Polynomial("5x-6");
        expectedResult = new Polynomial("10x^2-17x+6");

        assertEquals(operation.multiplyPoly(term1, term2), expectedResult);
    }

    @org.junit.jupiter.api.Test
    void derivePoly() {
        Polynomial term1 = new Polynomial("2x^2+3x+1");
        Polynomial expectedResult = new Polynomial("4x+3");

        assertEquals(operation.derivePoly(term1), expectedResult);

        term1 = new Polynomial("5");
        expectedResult = new Polynomial("0");

        assertEquals(operation.derivePoly(term1), expectedResult);
    }

    @org.junit.jupiter.api.Test
    void integratePoly() {
        Polynomial term1 = new Polynomial("5");
        Polynomial expectedResult = new Polynomial("5x");

        assertEquals(operation.integratePoly(term1), expectedResult);

        term1 = new Polynomial("6x^5+4x");
        expectedResult = new Polynomial("x^6+2x^2");

        assertEquals(operation.integratePoly(term1), expectedResult);
    }

    @org.junit.jupiter.api.Test
    void dividePoly() {
        Polynomial term1 = new Polynomial("2x^3+7x^2+2x+9");
        Polynomial term2 = new Polynomial("2x+3");
        Polynomial expectedResult = new Polynomial("x^2+2x-2");
        Polynomial expectedRemainder = new Polynomial("15");

        Polynomial[] result = operation.dividePoly(term1, term2);
        assertEquals(result[0], expectedResult);
        assertEquals(result[1],expectedRemainder);

        term1 = new Polynomial("x^4-10x^3+27x^2-46x+28");
        term2 = new Polynomial("x-7");
        expectedResult = new Polynomial("x^3-3x^2+6x-4");
        expectedRemainder = new Polynomial("0");

        result = operation.dividePoly(term1, term2);
        assertEquals(result[0], expectedResult);
        assertEquals(result[1],expectedRemainder);


    }
}