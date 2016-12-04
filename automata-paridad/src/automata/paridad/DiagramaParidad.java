package automata.paridad;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;

public class DiagramaParidad extends JFrame{
     private final JPanel contentPane;
    public DiagramaParidad() {
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
        //Circulos
        g.drawOval(250, 400, 100, 100);
        g.drawOval(250, 250, 100, 100);
        g.drawOval(120, 400, 100, 100);
        g.drawOval(120, 250, 100, 100);
        g.drawOval(130, 260, 80, 80);
        //lineas horizontales
        g.drawLine(220,300,250,300);
        g.fillOval(245, 295, 10, 10);
        
        g.drawLine(215,305,252,305);
        g.fillOval(214, 302, 10, 10);
        
        //horizontaes abajo
        g.drawLine(220,450,250,450);
        g.fillOval(212,447, 10, 10);
        
        g.drawLine(222,445,250,445);
        g.fillOval(248,438, 10, 10);
        
        //lineas verticales
        g.drawLine(165,350,165,400);
        g.fillOval(160, 348, 10, 10);
        
        g.drawLine(175,350,175,400);
        g.fillOval(170, 396, 10, 10);
        
        g.drawLine(300,350,300,400);
        g.fillOval(295, 396, 10, 10);
        
        g.drawLine(310,350,310,400);
        g.fillOval(305, 346, 10, 10);
        
        //start line
        g.drawLine(80,300,120,300);
        g.fillOval(116, 296, 10, 10);
        //labels
        JLabel top= new JLabel();
        JLabel estado0 = new JLabel();
        JLabel estado1 = new JLabel();
        JLabel estado2 = new JLabel();
        JLabel estado3= new JLabel();
        JLabel inicio =new JLabel();
        JLabel f1 = new JLabel();
        JLabel f2 = new JLabel();
        JLabel f3 = new JLabel();
        JLabel f4 = new JLabel();
        JLabel f5 = new JLabel();
        JLabel f6 = new JLabel();
        JLabel f7 = new JLabel();
        JLabel f8 = new JLabel();
        
        top.setText("Diagrama automata paridad");
        top.setBounds(200, 0, 500, 50);
        inicio.setText("Start");
        inicio.setBounds(70, 230, 100, 50);
        estado0.setText("q0");
        estado0.setBounds(150, 240, 50, 50);
        estado1.setText("q1");
        estado1.setBounds(280, 240, 50, 50);
        estado2.setText("q2");
        estado2.setBounds(150, 400, 50, 50);
        estado3.setText("q3");
        estado3.setBounds(280, 400, 50, 50);
        f1.setText("0");
        f1.setBounds(220,230,50,50);
        f2.setText("0");
        f2.setBounds(220,260,50,50);
        f3.setText("0");
        f3.setBounds(220,380,50,50);
        f4.setText("0");
        f4.setBounds(220,405,50,50);
        
        f5.setText("1");
        f5.setBounds(150,330,50,50);
        f6.setText("1");
        f6.setBounds(170,330,200,50);
        
        f7.setText("1");
        f7.setBounds(280,330,100,50);
        f8.setText("1");
        f8.setBounds(310,330,200,50);
        
        contentPane.add(top);
        contentPane.add(estado0);
        contentPane.add(inicio);
        contentPane.add(estado1);
        contentPane.add(estado2);
        contentPane.add(estado3);
        contentPane.add(f1);
        contentPane.add(f3);
        contentPane.add(f4);
        contentPane.add(f2);
        contentPane.add(f5);
        contentPane.add(f6);
        contentPane.add(f7);
        contentPane.add(f8);
    }
}