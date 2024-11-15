
package calculadorasimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraSimple extends JFrame implements ActionListener {
    private JTextField pantalla;
    private double num1, num2, resultado;
    private char operador;

    public CalculadoraSimple() {
        setTitle("Calculadora Simple");
        setSize(300, 400);
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4));

        String[] botones = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", "+", "C"};
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.addActionListener(this);
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.equals("C")) {
            pantalla.setText("");
        } else if (comando.equals("=")) {
            num2 = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '*': resultado = num1 * num2; break;
                case '/': resultado = num1 / num2; break;
            }
            pantalla.setText(String.valueOf(resultado));
        } else {
            num1 = Double.parseDouble(pantalla.getText());
            operador = comando.charAt(0);
            pantalla.setText("");
        }
    }

    public static void main(String[] args) {
        CalculadoraSimple calculadora = new CalculadoraSimple();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.setVisible(true);
    }
}
