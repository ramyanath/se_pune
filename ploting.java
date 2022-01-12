import javax.swing.JFrame;
import java.awt.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

class curv 
{
    double amp , freq  ;
    public  int []store = new int[900] ;
    int br =0;
    int fun()
    {
        int r ;
        int rtn=1;
        if(br >= 9)
        {br =0;}
        int arr[] = {0,1,0,1,1,1,0,1,1,0};
        for(r=1;r<=9;r+=1)
        {
            
            rtn = arr[r];
            br+=1;
            if(r==br)
            {
                return rtn;
            }
        }
        
        return rtn;
        
    }
    curv()
    {
        for(int i=0 ; i<=899 ; i++)
        {
            
            store[i] = fun();

        }
    }
    curv(int a , int b )
    {
        amp = a;
        freq = b;
        
    }
    void getval()
    {
        for(double x=0;x<=899;x=x+0.5)
        {
            
            double y = amp * sin(x*(3.1415926/100)*freq);
            int Y = (int)y;
            int X = (int)x;
            store[X] = Y;
            
            
        }
    }
    void add(curv pass)
    {
        for(int i=0 ; i<=899 ; i++)
        {
            
            store[i] += pass.store[i];
        }
    }
    void save() throws FileNotFoundException
    {
        PrintWriter strfile = new PrintWriter("ramya.txt");
        for(int i=0 ; i<=899 ; i++)
        {
            strfile.println(store[i]);
        }
        strfile.close();
    }
    
    
}
class SinX extends Component 
{
    
    
    public void paint(Graphics g) 
    {
        

        int arr[] = new int[900];
        try{
            File myFile = new File("ramya.txt");
            int i=0;
            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine())
            {
                arr[i]  = sc.nextInt();
                i+=1;
            }
            sc.close();
            }catch(Exception e){ }
        g.drawLine(0,350,900,350); // x-axis
        
        g.setColor(Color.red);

        
        
        for(double x=0;x<=899;x=x+1)
        {
            double y = 50 * sin(x*(3.1415926/100)*2);
            
            int X = (int)x;
            int Y =  arr[X];
            g.drawLine(X,350-Y,X,350-Y);
        }
    }
}

public class ploting
{
    public static void main(String[]args) 
    {
        curv dc = new curv();
        curv wav1 = new curv(100,1);
        curv wav2 = new curv(70,2);
        curv wav3 = new curv(50,3);
        wav1.getval();
        wav2.getval();
        wav3.getval();
        wav1.add(dc);
        wav1.add(wav2);
        wav1.add(wav3);
        try{
        wav1.save();
        } catch(Exception e){}
        

        JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setTitle("mix wave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new SinX());
        frame.setVisible(true);
        
    }
}
