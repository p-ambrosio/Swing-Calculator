import javax.swing.*;
import static java.lang.Math.sqrt;

public class Calculations extends Inputs{
    private double result = 0;
    private String operator= "";
    private boolean opPressed=false;

    Calculations(){
        for(JButton btn : buttonArray) {
            if (btn == null) {
                continue;
            }
            String text = btn.getText();
            btn.addActionListener(e -> handleCalc(text));
        }
    }

    private void handleCalc(String text){
        if (text.matches("[+\\-x÷]")) {
            result= Double.parseDouble(getCurrent());
            operator = text;
            opPressed= true;
            setCurrent("");

        } else if (text.equals("√")) { //Special case ignores =
            double a = Double.parseDouble(getCurrent());
            double res = Math.sqrt(a);
            setCurrent(String.valueOf(res));
            displayLabel.setText(getCurrent());

        } else if (text.equals("=")) {
            if (operator.isEmpty()|| getCurrent().isEmpty()) return; //Avoid crashes of missing a or b
            double b = Double.parseDouble(getCurrent());
            double res = computing(result, b, operator);
            setCurrent(String.valueOf(res));
            displayLabel.setText(getCurrent());
            operator = "";
            opPressed = false;
        }
    }

    public double computing (double a, double b, String operator){
        switch (operator){
            case "+": result = a+b; break;
            case "-": result = a-b; break;
            case "x": result = a*b; break;
            case "÷": result = b != 0 ? a / b : Double.NaN; break; //Cant divide by 0 obviously
            case "√": result = sqrt(a); break;
            default: return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculations();
    }


}
