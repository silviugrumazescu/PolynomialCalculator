public class Model {

    public static final int ADD = 0, SUBTRACT = 1, MULTIPLY = 2, DIVIDE = 3, INTEGRATE = 4, DERIVE = 5;

    private Polynomial p1,p2, result, remainder;
    public Operations operationsManager;

    public Model(){
        operationsManager = new Operations();
    }

    public void setP2(Polynomial p2) {
        this.p2 = p2;
    }
    public void setP1(Polynomial p1) {
        this.p1 = p1;
    }

    public Polynomial getResult(int operation) {
        switch(operation){
            case Model.ADD:
                this.result = operationsManager.addPoly(p1,p2);
                return this.result;
            case Model.SUBTRACT:
                this.result = operationsManager.subtractPoly(p1,p2);
                return this.result;
            case Model.DERIVE:
                this.result = operationsManager.derivePoly(p1);
                return this.result;
            case Model.INTEGRATE:
                this.result = operationsManager.integratePoly(p1);
                return this.result;
            case Model.MULTIPLY:
                this.result = operationsManager.multiplyPoly(p1,p2);
                return this.result;
        }
        return this.result;
    }
    public Polynomial[] getDivisionResult(){
        Polynomial[] divisionResult = operationsManager.dividePoly(p1, p2);
        this.result = divisionResult[0];
        this.remainder = divisionResult[1];
        return divisionResult;
    }
}
