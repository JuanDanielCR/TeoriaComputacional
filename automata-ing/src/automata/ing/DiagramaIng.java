package automata.ing;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class DiagramaIng  extends JFrame{
    private final JPanel contentPane;
    public DiagramaIng() {
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
        g.drawLine(10,300,100,300); g.drawLine(500,300,550,300);
        g.drawLine(200,300,250,300);g.drawLine(350,300,400,300);
        //Asi mismo
        g.drawArc(130, 230, 80, 80,-45,200);g.drawArc(280, 230, 80, 80,-45,200);
        //Retorno mas de 1
        g.drawLine(600,250,600,150); g.drawLine(160,100,600,150);
        g.drawLine(600,350,600,400); g.drawLine(300,450,600,400);
        
        //vetical
        g.drawLine(160,260,160,100); g.drawLine(300,360,300,450);
        
        g.drawLine(450,250,450,180); g.drawLine(170,150,450,180);
        
        g.drawLine(170,255,170,150); g.drawLine(450,350,450,420);
        g.drawLine(310,400,450,420);
        g.drawLine(310,350,310,400);
        
        g.drawLine(150,250,150,215);
        g.drawLine(300,250,300,215);
        g.drawLine(150,215,300,215);
        
        g.drawOval(100, 250, 100, 100);
        g.drawOval(250, 250, 100, 100);
        g.drawOval(400, 250, 100, 100);
        g.drawOval(560, 260, 80, 80);
        g.drawOval(550, 250, 100, 100);
        //Flechas
        g.setColor(Color.green);
        g.fillOval(145, 245, 10, 10);
        g.fillOval(155, 245, 10, 10);
        g.fillOval(165, 245, 10, 10);
        g.fillOval(295, 350, 10, 10);
        g.fillOval(305, 350, 10, 10);
        g.fillOval(545, 295, 10, 10);
        g.fillOval(245, 295, 10, 10);
        g.fillOval(395, 295, 10, 10);
        g.fillOval(95, 295, 10, 10);
        g.fillOval(130, 245, 10, 10);
        g.fillOval(280, 245, 10, 10);
        
        //Etiquetas
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
        JLabel f9 = new JLabel();
        JLabel f10 = new JLabel();
        
        top.setText("Diagrama automata -ing");
        top.setBounds(200, 0, 500, 50);
        estado0.setText("q0");
        estado0.setBounds(130, 240, 50, 50);
        inicio.setText("Start");
        inicio.setBounds(40, 220, 100, 50);
        estado1.setText("q1");
        estado1.setBounds(280, 240, 50, 50);
        estado2.setText("q2");
        estado2.setBounds(430, 240, 50, 50);
        estado3.setText("q3");
        estado3.setBounds(580, 240, 50, 50);
        f1.setText("n");
        f1.setBounds(370,220,50,50);
        f2.setText("i");
        f2.setBounds(400,420,50,50);
        f3.setText("i");
        f3.setBounds(215,220,50,50);
        f4.setText("g");
        f4.setBounds(520,220,50,50);
        f5.setText("i");
        f5.setBounds(400,360,50,50);
        f6.setText("not i or g");
        f6.setBounds(270,80,200,50);
        f7.setText("not i");
        f7.setBounds(270,30,100,50);
        f8.setText("not i or n");
        f8.setBounds(220,135,200,50);
        f9.setText("not i");
        f9.setBounds(170,135,200,50);
        f10.setText("i");
        f10.setBounds(330,165,200,50);
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
        contentPane.add(f9);
        contentPane.add(f10);
    }
}