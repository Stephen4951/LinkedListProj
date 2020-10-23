package test;

import collection.list.LinkedList;
import collection.list.List;
import scores.Score;

public class TestMain {
	
	public static void main(String[] args) {
		
		List<String> names = new LinkedList<>();
		
		names.add("홍길동");
		System.out.println("첫 노드 데이터: " + names.get(0));
		
		names.add("쌈아치");
        System.out.println("두번째 노드 데이터: " + names.get(1));

        names.insert(1, "꾸라야");
        System.out.println("names = " + names);
        
        String removedData1 = names.removeFirst();
        System.out.println("removeData1: " + removedData1);
        System.out.println("names: " + names);
        
        String removeData2 = names.remove(1);
        System.out.println("removeData2: " + removeData2);
        System.out.println("names: " + names);
        
        Score score = new Score("1111", 100, 99);
        System.out.println("score: " + score);

		
	}

}
