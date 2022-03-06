import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialParseTest {

    @org.junit.jupiter.api.Test
    void test1(){
        ArrayList<Monomial> term1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(2,2f), // 2x^2+3x+1
                new Monomial(1,3f),
                new Monomial(0, 1f)));

        assertEquals(new Polynomial("2x^2+3x+1"), new Polynomial(term1));
    }

    @org.junit.jupiter.api.Test
    void test2(){
        ArrayList<Monomial> term1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(340,-1f), // -x^340-234.43
                new Monomial(0,-234.43f)));

        assertEquals(new Polynomial("-x^340-234.43"), new Polynomial(term1));
    }

    @org.junit.jupiter.api.Test
    void test3(){
        ArrayList<Monomial> term1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1,-1f), // -x-20x^2
                new Monomial(2,-20f)));

        assertEquals(new Polynomial("-x-20x^2"), new Polynomial(term1));
    }

    @org.junit.jupiter.api.Test
    void test4(){
        ArrayList<Monomial> term1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(0,5f))); // 5

        assertEquals(new Polynomial("5"), new Polynomial(term1));
    }




}
