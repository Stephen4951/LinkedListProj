package collection.list;

//연결리스트를 구성하는 Node
class Node<E> {
	private E element; //저장 데이터
	private Node<E> next; //다음 노드를 연결할 링크
	
	protected Node() {}

	protected Node(E element) {
		this.element = element;
	}

	protected Node(E element, Node<E> next) {
		this.element = element;
		this.next = next;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public Node<E> getNext() {
		return next;
	}

	@Override
	public String toString() {
		return "element=" + element;
	}
}



public class LinkedList<E> implements List<E> {
	
	private Node<E> head; //연결리스트 첫번째 노드
	private Node<E> tail; //연결리스트 마지막 노드
	private int size;
	
	
	//맨 앞에 삽입
	@Override
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); //연결할 새 노드 생성
		newNode.setNext(head); //기존의 헤드노드를 새 노드의 다음 노드로 지정.
		this.head = newNode; //새로운 노드를 헤드노드로 지정.
		size++;
		
		if(head.getNext() == null) { //헤드 노드에 다음 노드가 없다면
			tail = head; //테일 노드에 헤드 노드를 설정.
		}	
	}

	//맨 뒤에 삽입
	@Override
	public void add(E e) {
		Node<E> newNode = new Node<>(e); //연결할 새 노드 생성
		if(size == 0) { //연결 리스트에 노드가 하나도 없다면
			addFirst(e); //해당 노드를 첫 노드로 설정.
		} else {
			tail.setNext(newNode); //테일노드의 다음노드로 새로운 노드를 지정.
			tail = newNode; //테일노드를 갱신
			size++; //노드 갯수 추가.
		}	
	}

	//중간에 삽입
	@Override
	public void insert(int index, E e) {
		if(index == 0) {
			addFirst(e); //주어진 인덱스가 0이라면 첫노드로 삽입.
		} else {
			Node<E> newNode = new Node<>(e); //삽입 대상 노드 생성.
			Node<E> preNode = searchNode(index - 1); //삽입 위치 직전 노드를 찾는다.
			Node<E> nextNode = preNode.getNext(); //삽입 위치 직전 노드의 다음 노드를 찾는다.
			
			preNode.setNext(newNode); //직전 노드의 다음 노드로 새 노드를 연결한다.
			newNode.setNext(nextNode); //새 노드의 다음 노드로 기존 직전노드의 다음노드를 연결한다.
			size++;
			
			//새로 추가한 노드의 다음노드가 없으면 마지막 노드이므로 테일노드로 설정.
			if(newNode.getNext() == null) {
				tail = newNode;
			}
		}
	}

	//엘리먼트 가져오기
	@Override
	public E get(int index) {
		return searchNode(index).getElement();
	}

	//리스트 객체 갯수 확인
	@Override
	public int size() {
		return this.size;
	}

	//첫번째 객체 삭제
	@Override
	public E removeFirst() {
		Node<E> temp = head; //첫 노드를 임시노드에 복사해두고
		head = temp.getNext(); //원래 첫 노드의 다음 노드를 헤드노드로 설정.
		
		//삭제 후 리턴할 데이터를 미리 복사해둠.
		E returnData = temp.getElement();
		temp = null; //노드를 삭제;
		size--;
		
		return returnData;
	}

	//중간 객체 삭제
	@Override
	public E remove(int index) {
		if(index == 0) { //첫번째 데이터를 삭제하려 한다면
			return removeFirst();
		}
		
		//삭제 대상 노드의 앞 노드를 찾음
		Node<E> preNode = searchNode(index - 1);
		
		//삭제 대상 노드를 타겟노드로 지정
		Node<E> targetNode = preNode.getNext();
		
		/*
		 - 코드 설명
		  현재 4, 5, 6번 노드가 있다고 가정.
		  내가 삭제하고 싶은 노드는 5번.
		  그럼 preNode는 4번이다. targetNode는 5번이다.
		  우리는 5번을 지운다면 4번과 5번의 링크를 끊고
		  5번과 6번의 링크를 끊은 후 4번과 6번을 연결해야 함.
		  아래 코드는 4번의 다음 노드로 5번의 다음 노드(6번)을 셋팅하는 코드이다.
		 */
		preNode.setNext(targetNode.getNext());
		
		//삭제 데이터 리턴을 위해 데이터 복사
		E returnData = targetNode.getElement();
		if(targetNode == tail) { //만약 삭제대상 노드가 리스트의 마지막 노드라면
			tail = preNode; //삭제 앞 노드를 마지막 노드로 설정.
		}
		
		//타겟 노드 삭제
		targetNode = null;
		size--;
			
		return returnData;
	}
	
	//리스트 출력
	@Override
	public String toString() {
		if(size == 0) {
			return "[]";
		}
		//전체 탐색 시작
		Node<E> temp = head;
		String str = "[";
		
		while(temp.getNext() != null) {
			str += temp.getElement() + ",";
			temp = temp.getNext();
		}
		str += temp.getElement();
		return str + "]";
	}

	// 특정 위치의 노드를 탐색하는 메서드
	private Node<E> searchNode(int index) {
		Node<E> temp = this.head; //첫번째 노드를 임시노드에 저장.
		for(int i=0; i<index; i++) {
			temp = temp.getNext(); //인덱스까지 계속해서 다음 노드를 링크해서 찾는다.
		}
		return temp;
	}
	
	
	
	
	
	
	

}
