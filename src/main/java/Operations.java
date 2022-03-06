import java.util.*;

public class Operations {
    public Polynomial addPoly(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        for (Monomial m : p1.getMonomialsList()) {
            result.getMonomialsList().add(new Monomial(m.getDegree(), m.getCoeff()));
        }
        ArrayList<Monomial> l2 = p2.getMonomialsList();
        for (Monomial m2 : l2){
            boolean added = false;
            for(Monomial m1 : result.getMonomialsList()){
                if(m1.getDegree() == m2.getDegree()){
                    m1.setCoeff(m1.getCoeff() + m2.getCoeff());
                    added = true;
                    break;
                }
            }
            if(!added){ // adaugam polinomul la finalul listei
                result.getMonomialsList().add(m2);
            }
        }
        result.sortPoly();
        return result;
    }
    public Polynomial subtractPoly(Polynomial p1, Polynomial p2){ // p1 - p2
        Polynomial result = new Polynomial();
        for(Monomial m : p1.getMonomialsList()){
            result.getMonomialsList().add(new Monomial(m.getDegree(), m.getCoeff()));
        }
        for (Monomial m2 : p2.getMonomialsList()){
            boolean added = false;
            for(Monomial m1 : result.getMonomialsList()){
                if(m1.getDegree() == m2.getDegree()){
                    m1.setCoeff(m1.getCoeff() - m2.getCoeff());
                    added = true;
                    break;
                }
            }
            if(!added){ // adaugam polinomul la finalul listei
                m2.setCoeff((-1) * m2.getCoeff());
                result.getMonomialsList().add(m2);
            }
        }
        result.removeZeroCoeffTerms();
        result.sortPoly();
        return result;
    }
    public Polynomial multiplyPoly(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        for(Monomial m2 : p2.getMonomialsList()) {
            for (Monomial m1 : p1.getMonomialsList()) {
                Monomial productMonomial = new Monomial(0,0);

                productMonomial.setDegree(m1.getDegree() + m2.getDegree());
                productMonomial.setCoeff(m1.getCoeff() * m2.getCoeff());
                result.getMonomialsList().add(productMonomial);
            }
        }
        result.mergeSameDegreeTerms();
        result.sortPoly();
        return result;
    }

    public Polynomial derivePoly(Polynomial p){
        Polynomial result = new Polynomial();
        for (Monomial m : p.getMonomialsList()) {
            result.getMonomialsList().add(new Monomial(m.getDegree(), m.getCoeff()));
        }
        int idx = 0;
        while(idx < result.getMonomialsList().size()){
            if(result.getMonomialsList().get(idx).getDegree() == 0){
                result.getMonomialsList().remove(idx);
            }
            else{
                idx++;
            }
        }
        for(Monomial m: result.getMonomialsList()){
            m.setCoeff(m.getDegree() * m.getCoeff());
            m.setDegree(m.getDegree() - 1);
        }
        result.sortPoly();
        return result;
    }
    public Polynomial integratePoly(Polynomial p){
        Polynomial result = new Polynomial();
        for (Monomial m : p.getMonomialsList()) {
            result.getMonomialsList().add(new Monomial(m.getDegree(), m.getCoeff()));
        }
        for(Monomial m: result.getMonomialsList()){
            m.setDegree(m.getDegree() + 1);
            m.setCoeff(m.getCoeff()/m.getDegree());
        }
        result.sortPoly();
        return result;
    }

    public Polynomial[] dividePoly(Polynomial p1, Polynomial p2){
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        p1.sortPoly(); p2.sortPoly();
        Polynomial divident, divizor;
        if(p1.getMonomialsList().get(0).getDegree() > p2.getMonomialsList().get(0).getDegree()){
            divident = p1;
            divizor = p2;
        }
        else {
            divident = p2;
            divizor = p1;
        }
        while(!divident.getMonomialsList().isEmpty() && divident.getTopMonomial().getDegree() >= divizor.getTopMonomial().getDegree()) {
            Monomial primaImpartire = new Monomial(divident.getTopMonomial().getDegree() - divizor.getTopMonomial().getDegree(),
                    divident.getTopMonomial().getCoeff() / divizor.getTopMonomial().getCoeff());
            result.add(primaImpartire);
            Polynomial deScazut = multiplyPoly(divizor, new Polynomial(new ArrayList<Monomial>(Arrays.asList(primaImpartire))));
            Polynomial rest = subtractPoly(divident, deScazut);
            divident = rest;
        }
        Polynomial polResult = new Polynomial(result);
        polResult.sortPoly();
        divident.sortPoly();
        return new Polynomial[] {polResult, divident};
    }
}
