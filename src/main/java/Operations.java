import java.util.ArrayList;
import java.util.Iterator;

public class Operations {

    public void addPoly(Polynomial p1, Polynomial p2){
        // consideram ca polinoamele sunt sortate dupa puteri
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        Iterator<Monomial> iter1 = p1.getMonomialsList().iterator();
        Iterator<Monomial> iter2 = p2.getMonomialsList().iterator();
        while(iter1.hasNext() && iter2.hasNext()){
            Monomial m1 = iter1.next();

        }
    }

}
