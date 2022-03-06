public class Monomial implements Comparable<Monomial>{
    private int degree;
    private float coeff;

    public int getDegree() {
        return degree;
    }

    public float getCoeff() {
        return coeff;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setDegree(String expression){
        String trimmedExp = expression.replaceAll("\\^", "");
        this.setDegree(Integer.parseInt(trimmedExp));
    }

    public void setCoeff(float coeff) {
        this.coeff = coeff;
    }

    public void setCoeff(String expression){
        if(expression.charAt(0) == '-'){
            if(expression.length() == 1){
                this.setCoeff(-1.0f);
            }
            else {
                String trimmedExp = expression.replaceAll("-", "");
                this.setCoeff((-1.0f)*Float.parseFloat(trimmedExp));
            }
        }
        else{
            if(expression.charAt(0) == '+' && expression.length() == 1){
                this.setCoeff(1.0f);
            }
            else {
                String trimmedExp = expression.replaceAll("\\+", "");
                this.setCoeff(Float.parseFloat(expression));
            }
        }
    }

    public Monomial(int degree, float coeff){
        this.degree = degree;
        this.coeff = coeff;
    }

    public Monomial(String expression){ // avem 5 cazuri: coeff x^pow, x^pow, coeff^x, coeff, x
        if(expression.equals("x")){
            this.setCoeff(1.0f);
            this.setDegree(1);
        }
        else if(expression.contains("x")){
            String splitExp[] = splitExpression(expression);
            if(splitExp.length == 2){ // coeff*x^pow
                this.setCoeff(splitExp[0]);
                this.setDegree(splitExp[1]);
            }
            else if(splitExp.length == 1){
                if(splitExp[0].contains("^")){ // x^pow
                    this.setDegree(splitExp[0]);
                    this.setCoeff(1.0f);
                }
                else {// coeff*x
                    this.setCoeff(splitExp[0]);
                    this.setDegree(1);
                }
            }
        }
        else{ // coeff
            this.setCoeff(expression);
            this.setDegree(0);
        }
    }

    private String[] splitExpression(String expression){ // se evita cazul in care x este primul caracter si primul string este gol
        String splitExp[];
        if (expression.startsWith("x"))
            splitExp = expression.substring(1).split("x", 0);
        else
            splitExp = expression.split("x", 0);
        return splitExp;
    }

    public int compareTo(Monomial anotherMonomial){
        if(this.getDegree() < anotherMonomial.getDegree())
            return -1;
        else if(this.getDegree() > anotherMonomial.getDegree())
            return 1;
        else{
            if(this.getCoeff() < anotherMonomial.getCoeff())
                return -1;
            else if(this.getCoeff() > anotherMonomial.getCoeff())
                return 1;
            else return 0;
        }
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;

        if(this.getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial)o;
        if(Float.compare(this.getCoeff(), monomial.getCoeff()) == 0){
            if(this.getDegree() == monomial.getDegree())
                return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return 0;
    }



}
