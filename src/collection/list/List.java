package collection.list;

public interface List<E> {

	//객체 맨 앞에 추가
	void addFirst(E e);
	
	//객체 맨 뒤에 추가
	void add(E e);
	
	//객체 삽입
	void insert(int index, E e);
	
	//객체 조회
	E get(int index);
	
	//객체 갯수 조회
	int size();
	
	//처음 객체 삭제
	E removeFirst();
	
	//중간 객체 삭제
	E remove(int index);
	
}
