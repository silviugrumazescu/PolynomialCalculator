public class Monomial {
    private int degree, power;

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Monomial(int degree, int power){
        this.degree = degree;
        this.power = power;
    }

}
