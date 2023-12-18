package stack;


public class PostfixEval {

    private static int evaluate(String postfix) {
        int A, B;
        LinkedStack<Integer> s = new LinkedStack<>();
        // 이전의 변수가 숫자인가?
        boolean prevIsDigit = false;

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (Character.isDigit(ch)) {
                // 숫자가 1단위의 숫자가 아닌 경우
                if (prevIsDigit == true) {
                    int tmp = s.pop();
                    tmp = tmp * 10 + (ch - '0');
                    s.push(tmp);
                } else s.push(ch - '0');
                prevIsDigit = true;
                // 연산자라면
            } else if (isOperator(ch)) {
                A = s.pop();
                B = s.pop();
                int val = operation(A, B, ch);
                s.push(val);
                prevIsDigit = false;
                // 둘 다 아닌 공백이면
            } else {
                prevIsDigit = false;
            }
        }
        return s.pop();
    }

    private static int operation(int a, int b, char ch){
        int val = 0;
        switch (ch){
            case '+':
                val = b + a;
                break;

            case '-':
                val = b - a;
                break;

            case '*':
                val = b * a;
                break;

            case '/':
                val = b / a ;
                break;
        }
        return val;
    }

    private static boolean isOperator(char ch){
        return (ch == '+' || ch == '-' || ch =='*' || ch == '/');
    }

}
