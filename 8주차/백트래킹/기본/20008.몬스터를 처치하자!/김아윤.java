import java.util.*;
import java.io.*;

public class 김아윤 {
	static int n;
	static int HP;
	
	static Skill[] skills;
	static int[] times;	// 스킬을 사용할 수 있는 시간을 저장할 배열 
	
	static int min;
	
	static class Skill{
		int time;
		int damage;
		
		Skill(int time, int damage){
			this.time=time;
			this.damage=damage;
		}
	}
	
	static public void main(String args[]) throws IOException{
		input();
		go(HP, 0);
		System.out.println(min);
	}
	
	static void go(int HP, int curTime) {
		if(HP<=0) {
			min = Math.min(min, curTime);
			return;
		}
		
		boolean possibleAttack = false;	// 공격 가능 여부 체크하는 변수 
		for(int i=0;i<n;i++) {
			if(times[i]>curTime) {
				continue;
			}
			
			possibleAttack = true;
			int prevTime = times[i];	// 현재 상태 저장해놓기
			
			times[i]=curTime+skills[i].time;
			go(HP-skills[i].damage, curTime+1);
			times[i]=prevTime;	// 재귀 끝난 후, 기존 상태 복원해주기 
		}
		if(!possibleAttack) {	// 공격이 불가능한 경우 
			go(HP, curTime+1);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		HP = Integer.parseInt(st.nextToken());
		
		skills = new Skill[n];
		times = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			skills[i] = new Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		min = Integer.MAX_VALUE;
	}
}
