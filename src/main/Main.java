package main;

import java.util.Scanner;

import collection.list.LinkedList;
import collection.list.List;
import scores.Score;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Score> scoreList = new LinkedList<>();
		
		while(true) {
			System.out.println("\n**** 새로운 정보를 입력합니다. ****");
			System.out.println("# 계속하시려면 Enter, 취소하시려면 *을 입력하세요.");
			String continueFlag = sc.nextLine();
			if(continueFlag.equals("*")) break;
			
			System.out.print("학번: ");
			String studentId = sc.next();
			System.out.print("국어점수: ");
			int koreanScore = sc.nextInt();
			System.out.println("영어점수: ");
			int englishScore = sc.nextInt();
			sc.nextLine();
			System.out.println("======================================");
			
			scoreList.add(new Score(studentId, koreanScore, englishScore));
			
		}
		
		System.out.println("***** Score 리스트 출력 *****");
		for(int i=0; i<scoreList.size(); i++) {
			System.out.print(scoreList.get(i) + "->");
		}
		System.out.println("null");
		
	}

}









