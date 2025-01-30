import java.util.Scanner;
//부분점수 50점
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        char []lit=new char[2*N+1];
        for(int i=0;i<2*N+1;i++){
            if(i%2==0){
                lit[i]='I';
            }else{
                lit[i]='O';
            }
        }
        
        int cnt=0;
        int len=Integer.parseInt(sc.nextLine());
        char []text=sc.nextLine().toCharArray();
        for(int a=0;a<=len-(2*N+1);a++){
            for(int b=0;b<2*N+1;b++){
                if(text[a+b]!=lit[b]){
                    break;
                }
                if(b==2*N){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);   
    }
}
