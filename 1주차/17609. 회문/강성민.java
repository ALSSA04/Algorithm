import java.util.Scanner;
//시간초과
class Main{
    
    static int checkText(char []_text){
        int length=_text.length;
        int cnt=0;
        int finish=(length-1)/2;
        if(length%2==0)finish=length/2;

        for(int i=0;i<finish;i++){
            if(_text[i]==_text[length-1-i]){
                cnt++;
            }else{
                return 2;
            }
        }
        if(cnt==finish)return 0;
        return 2;
    }
    static int checkText(char []_text,int k){
        int length=_text.length-1;
        int cnt=0;
        int finish=(length)/2;
        
        if(length%2==0)finish=length/2;
        for(int start=0,end=length;start<=finish;start++,end--){
            if(start==k)++start;
            if(end==k)--end;
            
            if(_text[start]==_text[end]){
                cnt++;
            }else{
                return 2;
            }
            if(cnt==finish)return 1;    
        }
        
        return 2;
    }
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        
        for(int i=0;i<T;i++){
            char[] plainText=sc.nextLine().toCharArray();
            
            int result=2;
            
            result=checkText(plainText);
            
            if(result==2){
                for(int j=0; j<plainText.length;j++){
                    result=checkText(plainText,j);
                    if(result==1){
                        break;
                    }
                }
            }
            System.out.println(result);
            
        }
    }
}