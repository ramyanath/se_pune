
import java.awt.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

class dft
{
    private static final double M_PI = 3.14;

    public static void main(String args[])
    {
    // startTime
    int arr[] = new int[900];
    double outwv[] = new double[900];
    int len = 0;
    try{
        File myFile = new File("input.txt");
        int i=0;
        Scanner sc = new Scanner(myFile);
        while(sc.hasNextLine())
        {
            arr[i]  = sc.nextInt();
            i+=1;
            len+=1;
        }
        sc.close();
        }catch(Exception e){ }
        
    // freopen("output1.txt","w",stdout);
    // #endif
    
    // vector<double> mixed_wave;
    // vector<pair<double,double>> frequency_wave;

    // taking input of total number of inputs of the signal
    int n=len;
    //cin>>n;

    // input of signal
    // FOR(i,0,n){
    //     double k;
    //     cin>>k;

    //     // storing the given wave in mixed_wave vector
    //     mixed_wave.pb(k);
    // }
    
    for(double j=0;j<100;j++){
        
        double kx=0,ky=0;
        
        // finding the integration of whole wave, here it will be sum of discrete values
        // kx stores the sum of real part of that complex number and 
        // ky stores the sum of imaginary part of that complex number

        for(int i=0;i<n;i++){
            double x= arr[i]*cos(2.0*M_PI*j/(double)(n)*i);
            double y= -arr[i]*sin(2.0*M_PI*j/(double)(n)*i);
            
            kx+=x;
            ky+=y;
        }

        // storing data in frequency_wave for processing
        // here we are storing the magnitutde of that complex number 
         // that is sqrt( x^2 + y^2 )
        outwv[(int)j] =(int) ( 2*sqrt(kx*kx+ky*ky)/(double)n );
    }


    // fstream fout;

    // plotting the waves in csv file
    // fout.open("freq_wave_plot.csv", ios::out |ofstream::trunc);

    // printing the signal
    try {
        
    PrintWriter strfile = new PrintWriter("mix.txt");
    for(int i=0 ; i<=899 ; i++)
    {
        strfile.print(outwv[i]+"\n");
    }
    strfile.close();
    } catch (Exception e) {
    //TODO: handle exception
    }
    // endTime
    
    }
}