package list.Arraylist;

public class ArrayList<E> implements ListInterface<E>{
    private E item[];
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public ArrayList() {
        item = (E[]) new Object [DEFAULT_CAPACITY];
        numItems=0;
    }

    public ArrayList(int n) {
        item = (E[]) new Object[n];
        numItems=0;
    }

    // [알고리즘 5-1] 구현: 배열 리스트의 k번째 자리에 원소 x 삽입하기
    @Override
    public void add(int i, E x) {
        if ( i < 0 || i > numItems ){
            System.out.println("잘못된 입력입니다.");
            return;
        } else {
            for (int k = numItems - 1; k >= i; k--)
                item[k + 1] = item[k]; 	// 우시프트
            item[i] = x;
            numItems++;
        }
    }

    // [알고리즘 5-2] 구현: 배열 리스트의 맨 뒤에 원소 추가하기
    @Override
    public void append(E x) {
        if( numItems >= item.length ){
            System.out.println("잘못된 입력입니다.");
            return;
        } else {
            item[numItems++] = x;
        }
    }

    // [알고리즘 5-3] 구현: 배열 리스트의 k번째 원소 삭제하기
    @Override
    public E remove(int i) {
        if( isEmpty() || i < 0 || i >= numItems ){
            System.out.println("잘못된 입력입니다.");
            return null;
        } else {
            E tmp = item[i];
            for (int k = i; i<=numItems-2; i++)
                item[i] = item[i+1];
            numItems--;
            return tmp;
        }
    }

    // [알고리즘 5-4] 구현: 배열 리스트에서 원소 x 삭제하기
    @Override
    public boolean removeItem(E X) {
        int k = 0;
        while (k <= numItems - 1 && ((Comparable)item[k]).compareTo(X) != 0)
            k++;
        if (k == numItems)
            return false;
        else{
            for (int i = k; i <= numItems - 2; i++)
                item[i] = item[i + 1];
            numItems--;
            return true;
        }
    }

    // [알고리즘 5-5] 구현: 배열 리스트의 i번째 원소 알려주기
    @Override
    public E get(int i) {
        if(i >= 0 && i <= numItems-1)
            return item[i];
        else
            System.out.println("잘못된 입력입니다.");
            return null;
    }

    // [알고리즘 5-6] 구현: 배열 리스트의 i번째 원소를 x로 대체하기
    @Override
    public void set(int i, E x) {
        if(i >= 0 && i <= numItems-1)
            item[i] = x;
        else
            System.out.println("잘못된 입력입니다.");
    }

    // [알고리즘 5-7] 구현: 원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E x) {
        int k = 0;
        for(int i = k; i< numItems; i++)
            if (((Comparable)item[i]).compareTo(x) == 0)
                return i;

        return NOT_FOUND;
    }

    // [알고리즘 5-8(1)] 구현: 배열 리스트의 총 원소 수 알려주기
    @Override
    public int len() {
        return numItems;
    }

    // [알고리즘 5-8(2)] 구현: 배열 리스트가 비었는지 알려주기
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // [알고리즘 5-8(3)] 구현: 배열 리스트 깨끗이 청소하기
    @Override
    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }
}
