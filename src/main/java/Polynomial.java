import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomialsList;
    private static String POLYNOMREGEX = "^([-+]?([0-9]*\\.?[0-9]+)?(x(\\^[+]?[0-9]+)?)?)+";
    private static String MONOMREGEX = "[-+]?([0-9]*\\.?[0-9]+)?(x(\\^[+]?[0-9]+)?)?";

    final float THRESHOLD = 0.0001f;

    public Polynomial(){monomialsList = new ArrayList<Monomial>();}
    public Polynomial(ArrayList<Monomial> monomialsList){
        this.monomialsList = monomialsList;
        this.sortPoly();
    }
    public Polynomial(String expression){
        monomialsList = new ArrayList<Monomial>();
        Pattern pattern = Pattern.compile(MONOMREGEX);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            if(matcher.group() != null && matcher.group(0) != "") {
                monomialsList.add(new Monomial(matcher.group(0)));
            }
        }
        this.removeZeroCoeffTerms();
        this.sortPoly();
    }

    public ArrayList<Monomial> getMonomialsList() {
        return monomialsList;
    }
    public void setMonomialsList(ArrayList<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }

    public String toString(){
        String msg = "";
        for (Monomial m : monomialsList){
            if(m.getCoeff() > 0f) {
                msg += "+" + String.format("%.2f ",m.getCoeff());
            }
            else if(m.getCoeff() < 0){
                msg += String.format("%.2f ", m.getCoeff());
            }
            if(m.getDegree() != 0){
                msg += "x";
                if(m.getDegree() > 0){
                    msg+= "^" + m.getDegree();
                }
            }
        }
        return msg;
    }

    public static boolean isPolynomial(String expression){
        if(expression.isEmpty()) return false;
        expression.replaceAll("\\s+", "");
        if(expression.matches(POLYNOMREGEX))
            return true;
        else
            return false;
    }

    public void removeZeroCoeffTerms(){
        int idx = 0;
        while(idx < monomialsList.size()){
            if(Math.abs(monomialsList.get(idx).getCoeff()) < THRESHOLD)
                monomialsList.remove(idx);
            else
                idx++;
        }
    }

    public void mergeSameDegreeTerms(){
        int idx = 0;
        while(idx < monomialsList.size()){
            int idy = idx+1;
            while(idy < monomialsList.size()){
                if(monomialsList.get(idx).getDegree() == monomialsList.get(idy).getDegree()){
                    float currentCoeff = monomialsList.get(idx).getCoeff();
                    float toBeAddedCoeff = monomialsList.get(idy).getCoeff();
                    monomialsList.get(idx).setCoeff(currentCoeff + toBeAddedCoeff);
                    monomialsList.remove(idy);
                }
                else{
                    idy++;
                }
            }
            idx++;
        }
    }

    public void sortPoly(){
        //Collections.sort(monomialsList);
        Collections.sort(monomialsList, Collections.reverseOrder());
    }

    public Monomial getTopMonomial(){
        if(!getMonomialsList().isEmpty())
            return this.getMonomialsList().get(0);
        else
            return null;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;

        if(this.getClass() != o.getClass()) return false;
        Polynomial polynomial = (Polynomial)o;

        if(this.getMonomialsList().size() != polynomial.getMonomialsList().size())
            return false;

        ArrayList<Monomial> thisList = this.getMonomialsList();
        ArrayList<Monomial> comparedList = polynomial.getMonomialsList();
        int idx = 0;
        while(idx < thisList.size()){
            if(!thisList.get(idx).equals(comparedList.get(idx))){
                return false;
            }
            idx++;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return 0;
    }
}
