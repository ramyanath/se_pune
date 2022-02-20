import javax.swing.JFrame;
import java.awt.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

// this program contains only the unit of the wave wrapped over the circle

class SinX extends Component 
{
    
    
    public void paint(Graphics g) 
    {
        int sv[][]=new int[2][900];

        int amplitude = 40 , freq = 2;
        g.drawLine(0,400,800,400); // x-axis
        
        g.setColor(Color.black);

        int X=0;
       int Y=0;

        for(int x=0;x<=360;x=x+1)
        {
            
            
            
            // here small x is thita and capital X is value of x
            double y = (amplitude+(amplitude*cos(x*freq))) * sin(x);
            double tmp1 = (amplitude+(amplitude*cos(x*freq))) * cos(x);
            
            Y = (int)y;
            X = (int)tmp1;
            g.drawLine(400+X,400-Y,400+X,400-Y);
            sv[0][x]=X;  
            sv[1][x]=Y;
            
        }
        for(int x=0;x<=360;x=x+1)
        {
            
            
            
            // here small x is thita and capital X is value of x
            double y = (amplitude+(amplitude*cos(x*freq))+10*cos(x*9)) * sin(x+30);
            double tmp1 = (amplitude+(amplitude*cos(x*freq))+10*cos(x*9)) * cos(x+30);
            
            Y = (int)y;
            X = (int)tmp1;
            g.drawLine(400+X,400-Y,400+X,400-Y);
        }

        // make points thik

        // for(int x=0;x<=359;x=x+1)
        // {
        //     g.drawLine(399+sv[0][x],400-sv[1][x],400+sv[0][x],401-sv[1][x]);
        //     g.drawLine(400+sv[0][x],399+sv[1][x],400+sv[0][x],400+sv[1][x]);
        // }


        //this portion will store the values of x and y of every point index value of array is thita
        // try{
        // PrintWriter stfile = new PrintWriter("exmp.txt");
        // for(int i=0 ; i<=362 ; i++)
        // {
        //     stfile.println(sv[0][i]+","+sv[1][i]);
        // }
        // stfile.close();
        // }
        // catch(Exception e){}
       
    }
}

public class flower
{
    //this portion does nothing but initializing the graphics
    public static void main(String[]args) 
    {
    
        JFrame frame = new JFrame();
        frame.setSize(800,800);
        frame.setTitle("mix wave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new SinX());
        frame.setVisible(true);
        
    }
}


