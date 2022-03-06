import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.setAddButtonActionListener(new addButtonActionListener());
        view.setSubstractButtonActionListener(new subtractButtonActionListener());
        view.setDivideButtonActionListener(new divideButtonActionListener());
        view.setMultiplyButtonActionListener(new multiplyButtonActionListener());
        view.setDeriveButtonActionListener(new deriveButtonActionListener());
        view.setIntegrateButtonActionListener(new integrateButtonActionListener());
    }

    private void setViewError(String error){
        view.setError(error);
    }

    private void manageOperation(int operation){
        if(Polynomial.isPolynomial(view.getTermOne())){
            model.setP1(new Polynomial(view.getTermOne()));
        }
        else{
            setViewError("Primul polinom introdus nu este in format corect");
            return;
        }
        if (operation == Model.ADD || operation == Model.SUBTRACT || operation == Model.MULTIPLY || operation == Model.DIVIDE) {
            if(Polynomial.isPolynomial(view.getTermTwo())){
                model.setP2(new Polynomial(view.getTermTwo()));
            }
            else{
                setViewError("Al doilea polinom introdus nu este in format corect");
                return;
            }
        }
        setViewError("");
        if(operation == Model.DIVIDE){
            Polynomial[] result = model.getDivisionResult();
            view.setResult("Result = " + result[0].toString() + " Remainder = " + result[1].toString());
        }
        else{
            Polynomial result = model.getResult(operation);
            view.setResult(result.toString());
        }
    }

    private class addButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            manageOperation(Model.ADD);
        }
    }
    private class subtractButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            manageOperation(Model.SUBTRACT);
        }
    }

    private class multiplyButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            manageOperation(Model.MULTIPLY);
        }
    }
    private class divideButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            manageOperation(Model.DIVIDE);
        }
    }
    private class deriveButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            manageOperation(Model.DERIVE);
        }
    }
    private class integrateButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            manageOperation(Model.INTEGRATE);
        }
    }
}
