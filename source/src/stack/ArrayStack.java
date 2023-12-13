package stack;

public class ArrayStack<E> implements StackInterface<E> {
    // 스택으로 사용할 배열
    private E stack[];
    // 스택의 탑 인덱스
    private int topIndex;
    // 배열 생성에 값을 넣어주지 않았을 경우 들어갈 크기 디폴트값
    private static final int DEFAULT_CAPACITY = 64;
    // 임의의 에러 값
    private E ERROR = null;

    ArrayStack(){ // 생성자1
        stack = (E[])new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    ArrayStack(int n){ // 생성자2
        stack =(E[])new Object[n];
        topIndex = -1;
    }

    // 배열이기 때문에 데이터 추가시 공간이 남는지 확인필요
    public boolean isFull() {
        return (topIndex == stack.length - 1);
    }

    // 데이터 추가
    @Override
    public void push(E newItem) {
        if(isFull()) {
            System.out.println("추가 공간이 없습니다.");
            return;
        }
        stack[++topIndex] = newItem;
    }


    // 데이터 삭제
    @Override
    public E pop() {
        if(isEmpty()){
            return ERROR;
        }

        return  stack[topIndex--];
    }

    // 탑 원소 알려주기
    @Override
    public E top() {
        if(isEmpty()){
            return ERROR;
        }

        return stack[topIndex];
    }

    // 비었는가 확인
    @Override
    public boolean isEmpty() {
        return (topIndex < 0);
    }

    //  데이터 전부 없애기
    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }
}
