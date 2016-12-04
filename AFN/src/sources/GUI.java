package sources;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
@SuppressWarnings("serial")
public class GUI  extends JFrame{
    private final JPanel contentPane;
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 5, 10, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,800);
    }  
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        g.setColor(Color.blue);
        //Lineas union rectas
        g.drawLine(500,300,550,300);
        g.drawLine(200,300,250,300);
        g.drawLine(350,300,400,300);
        //Asi mismo
        g.drawArc(280, 230, 80, 80,-45,200);
        

        //Ciruculos
        g.drawOval(250, 250, 100, 100);
        g.drawOval(400, 250, 100, 100);
        g.drawOval(560, 260, 80, 80);
        g.drawOval(550, 250, 100, 100);
        
        //Flechas
        g.setColor(Color.green);

        g.fillOval(545, 295, 10, 10);
        g.fillOval(245, 295, 10, 10);
        g.fillOval(395, 295, 10, 10);
        g.fillOval(280, 245, 10, 10);
        
        //Etiquetas
        JLabel top= new JLabel();

        JLabel estado1 = new JLabel();
        JLabel estado2 = new JLabel();
        JLabel estado3= new JLabel();
        JLabel f1 = new JLabel();
        JLabel f3 = new JLabel();
        JLabel f4 = new JLabel();
        JLabel f5 = new JLabel();

        
        top.setText("Diagrama AFN");
        top.setBounds(200, 0, 500, 50);

        estado1.setText("q0");
        estado1.setBounds(280, 240, 50, 50);
        estado2.setText("q1");
        estado2.setBounds(430, 240, 50, 50);
        estado3.setText("q2");
        estado3.setBounds(580, 240, 50, 50);
        f1.setText("0");
        f1.setBounds(370,220,50,50);
        f3.setText("Start");
        f3.setBounds(215,220,50,50);
        f4.setText("1");
        f4.setBounds(520,220,50,50);
        f5.setText("0,1");
        f5.setBounds(320,160,50,50);
        
        //Adding components
        contentPane.add(top);
        contentPane.add(estado1);
        contentPane.add(estado2);
        contentPane.add(estado3);
        contentPane.add(f1);
        contentPane.add(f3);
        contentPane.add(f4);
        contentPane.add(f5);

    }
}