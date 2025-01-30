import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String text=sc.nextLine();
        int alpha[]=new int[2];
        
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='a'){
                alpha[0]++;
            }else{
                alpha[1]++;
            }
        }
        int min_alpha=0;
        char char_alpha='a';
        if(alpha[min_alpha]>=alpha[1]){
            min_alpha=1;
            char_alpha='b';
        }
        
        int min_cnt=1000;
        text=text+text.substring(0,alpha[min_alpha]);
        for(int i=0;i<text.length()-alpha[min_alpha];i++){
            String tmp=text.substring(i, i+alpha[min_alpha]);
            int cnt=0;
            for(int j=0;j<tmp.length();j++){
                if(tmp.charAt(j)!=char_alpha){
                    cnt++;
                }
            }
            if(cnt<min_cnt)min_cnt=cnt;
        }
        System.out.println(min_cnt);
    }
}
