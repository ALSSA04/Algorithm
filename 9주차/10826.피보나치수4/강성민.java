import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main_10826_강성민 {
    static BigDecimal []fiboArr;
    static BigDecimal fibo(int n){
        
        if(fiboArr[n]!=null)return fiboArr[n];
        
        return fiboArr[n]=fibo(n-1).add(fibo(n-2));

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        if(N!=0)fiboArr=new BigDecimal[N+1];
        else fiboArr=new BigDecimal[2];
        
        fiboArr[0]=BigDecimal.ZERO;
        fiboArr[1]=BigDecimal.ONE;
        System.out.println(fibo(N));

    }
}
