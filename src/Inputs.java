import javax.swing.*;

public class Inputs extends Display{

    private String current = "";
    private boolean result = false;

    Inputs(){
        for(JButton btn : buttonArray){
            if(btn==null){
                continue;
            }
            String text = btn.getText();
            btn.addActionListener(e -> handleInput(text));
        }
    }

    private void handleInput(String text){
        if(text.matches("[0-9]")|| text.equals(".")){ //Numbers
            if (result) { current = ""; result = false; }
            // prevent multiple decimals
            if (text.equals(".") && current.contains(".")) return;
            current += text;
            displayLabel.setText(current);
        }else if(text.equals("Del")){ //Delete
            if(!current.isEmpty()){
                current= current.substring(0, current.length()-1);
                displayLabel.setText(current.isEmpty() ? "0" : current);
            }
        }else if(text.equals("C")){ //Clear
            current = "";
            displayLabel.setText("0");
        }else if(text.equals("+/-")){ //Positive or negative
            if (!current.isEmpty() && !current.equals("0")) {
                if (current.startsWith("-")) current = current.substring(1);
                else current = "-" + current;
                displayLabel.setText(current);
            }
        }
    }

    public String getCurrent(){
        return current;
    }
    public void setCurrent(String value){
        current = value;
        result = true;
    }

    public static void main(String[] args){
        new Inputs();
    }

}
