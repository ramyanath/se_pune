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


public class lenierwav extends JPanel implements ActionListener
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
            
            
            
            
            double y = 50 * sin(x*2*(3.1415926/200)+fi);
            int Y = (int)y;
            int X = (int)x;
            g.drawLine(X,350-Y,X,350-Y);
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
    lenierwav an = new lenierwav();
    JFrame jf = new JFrame();
    jf.setTitle ("Movement of a Box");
    jf.setSize(800, 800);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(an);
}
}