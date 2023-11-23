package list.Arraylist;

public class IntergerArrayList implements IntegerListInterface{

    private Integer [] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public IntergerArrayList() { 	// 생성자 1
        item = new Integer[DEFAULT_CAPACITY];
        numItems =0;
    }

    public IntergerArrayList(int n) { 	// 생성자 2
        item = new Integer[n];
        numItems =0;
    }

    // [알고리즘 5-1] 구현: 배열 리스트의 k번째 자리에 원소 x 삽입하기
    @Override
    public void add(int index, Integer x) {
        if( index < 0 || index >= item.length || index > numItems ){
            System.out.println("잘못된 입력입니다.");
            return;
        } else {
            for ( int i = numItems-1; i >= index; i-- ) {
                item[i+1] = item[i];
            }
            item[index] = x;
            numItems++;
        }
    }

    // [알고리즘 5-2] 구현: 배열 리스트의 맨 뒤에 원소 추가하기
    @Override
    public void append(Integer x) {
        if( numItems >= item.length ){
            System.out.println("잘못된 입력입니다.");
            return;
        } else {
            item[numItems++] = x;
        }
    }

    // [알고리즘 5-3] 구현: 배열 리스트의 k번째 원소 삭제하기
    @Override
    public Integer remove(int index) {
        if( isEmpty() || index < 0 || index > numItems-1){
            return null;
        } else {
            Integer tmp = item[index];
            for(int i = index; i<=numItems; i++){
                item[i] = item[i+1];
            }
            numItems--;
            return tmp;
        }
    }

    // [알고리즘 5-4] 구현: 배열 리스트에서 원소 x 삭제하기
    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while(k != numItems && item[k].compareTo(x) != 0)
            k++;
        if( k == numItems )
            return false;
        else{
            for (int i = k; i <= numItems-2; i++)
                item[i] = item[i + 1];
            numItems--;
            return true;
        }
    }

    // [알고리즘 5-5] 구현: 배열 리스트의 i번째 원소 알려주기
    @Override
    public Integer
    get(int index) {
        if(index >= 0 && index <= numItems )
            return item[index];
        else return null;
    }

    // [알고리즘 5-6] 구현: 배열 리스트의 i번째 원소를 x로 대체하기
    @Override
    public void set(int index, Integer x) {
        if(index >= 0 && index <= numItems-1 )
            item[index] = x;
        else
            System.out.println("잘못된 입력입니다.");
    }

    // [알고리즘 5-7] 구현: 원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(Integer x) {
        int k = 0;
        while( k != numItems && item[k].compareTo(x) != 0)
            k++;
        if( k == numItems)
            return NOT_FOUND;

        return k;
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
        item = new Integer[item.length];
        numItems = 0;
    }
}
