/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Jpanel;
import javax.swing.Timer;*/
import static java.lang.Math.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class testAnim extends JPanel implements ActionListener
{

    Timer tm = new Timer(100, this);
    
    int X , Y;
    double fi=0;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.RED);
        for(int x=0;x<=360;x=x+1)
        {
            
            
            
            // here small x is thita and capital X is value of x
            double y = (30+(30*cos(x*2))+10*cos(x*9)) * sin(x+fi);
            double tmp1 = (30+(30*cos(x*2))+10*cos(x*9)) * cos(x+fi);
            
            Y = (int)y;
            X = (int)tmp1;
            g.drawLine(400+X,400-Y,400+X,400-Y);
        }

        tm.start();
    }



public void actionPerformed(ActionEvent e)
{

    

    fi = fi + 0.25;
    repaint();
}

public static void main(String[] args)
{
    testAnim an = new testAnim();
    JFrame jf = new JFrame();
    jf.setTitle ("Movement of a Box");
    jf.setSize(800, 800);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(an);
}
}