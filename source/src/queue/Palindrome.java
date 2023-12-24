package queue;

import stack.LinkedStack;

public class Palindrome {
    private static boolean isPalindrom(String A) {

        LinkedStack stack = new LinkedStack<>();
        LinkedQueue queue = new LinkedQueue<>();

        for(int i =0; i < A.length(); i++ ) {
            stack.push(A.charAt(i));
            queue.enqueue(A.charAt(i));
        }

        while( !stack.isEmpty() ) {
           if( !(stack.pop() == queue.dequeue()) ){
               break;
           }
        }

        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "lioninoil";
        boolean t = isPalindrom(str);
        System.out.println(t);
    }


}
