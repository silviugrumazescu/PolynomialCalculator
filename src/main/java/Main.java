import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model,view);
    }
}
