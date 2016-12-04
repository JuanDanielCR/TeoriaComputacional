package automata.protocolo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DiagramaProtocolo extends JFrame{
    private final JPanel contentPane;
    public DiagramaProtocolo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
    }
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        g.setColor(Color.black);
        g.drawOval (250, 150, 300, 300);
        g.drawArc(560, 225, 80, 80,-90,250);
        g.drawLine(100,300,200,300);
        g.setColor(Color.blue);
        g.drawOval(200, 250, 100, 100);
        g.drawOval(210, 260, 80, 80);
        g.drawOval(500, 250, 100, 100);
        g.drawLine(350,400,350,500);
        g.drawLine(350,400,450,400);
        g.drawLine(450,400,450,500);
        g.drawLine(350,500,450,500);
        g.fillOval(190, 295, 10, 10);
        g.fillOval(595, 300, 10, 10);
        g.fillOval(255, 345, 10, 10);
        g.fillOval(535, 243, 10, 10);
        g.fillOval(447, 435, 10, 10);
        JLabel titulo= new JLabel();
        JLabel texto3 = new JLabel();
        JLabel texto4 = new JLabel();
        JLabel texto5 = new JLabel();
        JLabel texto6 = new JLabel();
        JLabel texto7 = new JLabel();
        JLabel texto8 = new JLabel();
        JLabel et1 = new JLabel();
        JLabel et2 = new JLabel();
        titulo.setText("Autómata 3 Protocolo");
        titulo.setBounds(260, 0, 500, 50);
        contentPane.add(titulo);
        texto3.setText("ON/OFF");
        texto3.setBounds(200, 350, 100, 50);
        contentPane.add(texto3);
        texto4.setText("ACK");
        texto4.setBounds(500, 350, 200, 50);
        contentPane.add(texto4);
        texto5.setText("q0");
        texto5.setBounds(220, 240, 200, 50);
        contentPane.add(texto5);
        texto6.setText("q1");
        texto6.setBounds(520, 240, 200, 50);
        contentPane.add(texto6);
        texto7.setText("A");
        texto7.setBounds(380, 380, 200, 50);
        contentPane.add(texto7);
        texto8.setText("Start");
        texto8.setBounds(100, 230, 200, 50);
        contentPane.add(texto8);
        et1.setText("DATA IN");
        et1.setBounds(350,70,200,50);
        contentPane.add(et1);
        et2.setText("TIME OUT");
        et2.setBounds(600,150,200,50);
        contentPane.add(et2);
    }
}