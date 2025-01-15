import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen implements ActionListener {


    JTextField textField = new JTextField();

    Font caFont = new Font("Arial", Font.BOLD, 20);
    JPanel panelGui;
    JFrame screenUser = new JFrame("Calculator");
    JButton[] numButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton multButton, addButton, subButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    boolean verEq = false;

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    public Screen() {
        ImageIcon imageIcon = new ImageIcon("C:\\Programaçao\\Calculadora\\icons\\calculatoricon.png");

        screenUser.setIconImage(imageIcon.getImage());
        screenUser.setLayout(null);
        screenUser.setLocation(400, 400);

        screenUser.setSize(420, 550);
        screenUser.setResizable(false);
        screenUser.getContentPane().setBackground(new Color(0, 0, 0));
        screenUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TextField
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(caFont);
        textField.setEditable(false);
        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(new Color(255, 255, 255));
        screenUser.add(textField);

        // Panel
        panelGui = new JPanel();
        panelGui.setVisible(true);
        panelGui.setBounds(50, 100, 300, 300);
        panelGui.setLayout(new GridLayout(4, 4, 10, 10));
        panelGui.setBackground(new Color(0, 0, 0));
        screenUser.add(panelGui);

        //Button 
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        clrButton = new JButton("clear");
        delButton = new JButton("delete");
        negButton = new JButton("(-)");
        eqButton = new JButton("=");

        //Panel
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(caFont);
            numButtons[i].setFocusable(false);
        }

//        addButton.addActionListener(this);
//        negButton.addActionListener(this);
//        delButton.addActionListener(this);
//        clrButton.addActionListener(this);
//        eqButton.addActionListener(this);

        panelGui.add(numButtons[0]);
        panelGui.add(numButtons[1]);
        panelGui.add(numButtons[2]);
        panelGui.add(addButton);
        panelGui.add(numButtons[3]);
        panelGui.add(numButtons[4]);
        panelGui.add(numButtons[5]);
        panelGui.add(subButton);
        panelGui.add(numButtons[6]);
        panelGui.add(numButtons[7]);
        panelGui.add(numButtons[8]);
        panelGui.add(divButton);
        panelGui.add(numButtons[9]);

        panelGui.add(negButton);
        panelGui.add(multButton);
        panelGui.add(eqButton);


        screenUser.add(delButton);
        screenUser.add(decButton);
        screenUser.add(clrButton);
        clrButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        decButton.setBounds(250, 430, 100, 50);
        clrButton.setFont(new Font("Arial", Font.ITALIC, 15));
        screenUser.setVisible(true);


        /*Adding funcionality for buttons*/
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = negButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        functionButtons[8] = eqButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
//            if ((i != 6) && (i != 7)) {
            functionButtons[i].setFont(caFont);
//            }
            functionButtons[i].setFocusable(false);
        }


//        functionButtons[6].setFont(new Font("Arial", Font.ITALIC, 15));
//        functionButtons[7].setFont(new Font("Arial", Font.ITALIC, 15));


    }

    Double aux;

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {

                textField.setText(textField.getText().concat(String.valueOf(i)));
            }


        }

        // add button action
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            aux = result;
            if (operator == '+') {
                result = num1 + num2;
                System.out.println(result);
                System.out.println("sout ");
                num2 = result;
            }
            if (operator == '-') {

                result = num1 - num2;
                System.out.println(num2);
                num2 = result;

                //  num1 = result;

            }
            if (operator == '*') {


                result = num1 * num2;
                System.out.println(result);
                num2 = result;



            }
            textField.setText(String.valueOf(result));
        }
        // delete button
        if (e.getSource() == clrButton) {
            textField.setText("");
            result = 0;

        }
        if (e.getSource() == delButton) {
            String getText = textField.getText();
            int i = getText.length();
            i--;

            getText = getText.substring(0, i);
            System.out.println(getText);
            textField.setText(getText);

            num1 = 0;
            num2 = 0;


        }
          Double temp = 0.0;
        if(e.getSource() == negButton){
             temp = Double.parseDouble(textField.getText());
             temp *= -1;
             textField.setText(String.valueOf(temp));

        }
        String charTemp = ".";
        String subs = "";

        if(e.getSource() == decButton){
            subs = textField.getText()+charTemp;
            textField.setText(subs);
        }



    }


}


