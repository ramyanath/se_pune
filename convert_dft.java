class convert
{
    int y;
int arr[] = new int[900];
    void input()
    {
        try{
            File myFile = new File("input.txt");
            int i=0;
            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine())
            {
                arr[i]  = sc.nextInt();
                i+=1;
            }
            sc.close();
            }catch(Exception e){ }
        
    }

        
    void mix()
    {
        for(double x=0;x<=899;x=x+0.5)
        {
            
            double y = amp * sin(x*2*(3.1415926/freq)+ phase );
            int Y = (int)y;
            int X = (int)x;
            store[X] = Y;
            
            
        }
    }
    void out() throws FileNotFoundException
    {
        PrintWriter strfile = new PrintWriter("mix.txt");
        for(int i=0 ; i<=899 ; i++)
        {
            strfile.print(store[i]+"\n");
        }
        strfile.close();
    }

}
public class convert_dft {
    
}
