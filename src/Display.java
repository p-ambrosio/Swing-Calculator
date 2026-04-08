import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Display {
    private final int width = 700;
    private final int height = 1080;
    JButton[] buttonArray = new JButton[20];

    // Backgrounds
    Color mainBack     = new Color(40, 44, 52);      // One Dark base
    Color displayBack  = new Color(33, 37, 43);      // darker panel
    Color buttonBack_D = new Color(50, 55, 65);      // elevated surface
    Color buttonBack_P = new Color(62, 68, 80);      // pressed state

    // Text
    Color primary      = new Color(171, 178, 191);   // One Dark fg white

    // Actionsz
    Color buttonEqual_D = new Color(80, 161, 79);    // One Dark green
    Color buttonEqual_P = new Color(57, 120, 56);    // pressed green
    Color operators_D   = new Color(209, 154, 102);  // One Dark orange
    Color operators_P   = new Color(166, 115, 66);   // pressed orange

    // Utility
    Color delete_clear  = new Color(224, 108, 117);  // One Dark red
    Color clear_P       = new Color(180, 74, 84);    // pressed red
    Color border        = new Color(60, 66, 78);     // subtle blue-grey border

    JFrame frame = new JFrame("Calculator");
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel displayLabel = new JLabel("0");

    Display() {
        //FRAME
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(mainBack);

        //DISPLAY
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(displayBack);
        displayPanel.setBorder(new LineBorder(border, 2));
        displayPanel.setPreferredSize(new Dimension(width, 200));

        displayLabel.setForeground(primary);
        displayLabel.setFont(new Font("Segoe UI", Font.BOLD, 64));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        displayPanel.add(displayLabel, BorderLayout.CENTER);

        //BUTTON
        buttonPanel.setLayout(new GridLayout(5, 4, 20, 20));
        buttonPanel.setBackground(mainBack);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] buttons = {
                "C", "Del", "√", "÷",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };
        int i = 0;
        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel());
                continue;
            }

            JButton btn = new JButton(text);
            styleButton(btn, text);
            buttonPanel.add(btn);
            buttonArray[i++] = btn;
        }

        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    //BUTTON STYLING
    private void styleButton(JButton btn, String text) {
        btn.setFont(new Font("Arial", Font.BOLD, 32));
        btn.setFocusPainted(false);
        btn.setBorder(new LineBorder(border, 5));
        btn.setForeground(primary);

        // Default colors
        btn.setBackground(buttonBack_D);

        // Special buttons
        if (text.equals("=")) {
            btn.setBackground(buttonEqual_D);
        } else if (text.matches("[+\\-x÷√]")) {
            btn.setBackground(operators_D);
        } else if (text.equals("C") || text.equals("Del")) {
            btn.setBackground(delete_clear);
        }


        // Press effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (text.equals("=")) btn.setBackground(buttonEqual_P);
                else if (text.matches("[+\\-x÷√]")) btn.setBackground(operators_P);
                else if (text.equals("C") || text.equals("Del")) btn.setBackground(clear_P);
                else btn.setBackground(buttonBack_P);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (text.equals("=")) btn.setBackground(buttonEqual_D);
                else if (text.matches("[+\\-x÷√]")) btn.setBackground(operators_D);
                else if (text.equals("C") || text.equals("Del")) btn.setBackground(delete_clear);
                else btn.setBackground(buttonBack_D);
            }
        });
    }




    public static void main(String[] args) {
        new Display();
    }
}
