package baekjoon;

import java.util.*;

class 박희준 {
    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        }
        
        countList.get(1).add(N);
        
        for(int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);
            
            for(int j = 1; j <= i; j++) {
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);
                
                for(int preNum : preSet) {
                    for(int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);
                        
                        if(preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }
                    }
                }
            }
            
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for(Set<Integer> sub : countList) {
            if(sub.contains(number)) {
                return countList.indexOf(sub);
            }
        }
        
        return -1;
    }
}