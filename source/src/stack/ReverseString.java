package stack;

public class ReverseString {

    public static void main(String[] args) {
        String input = "tomato is vegetable";
        String output = reverse(input);

        System.out.println("Input string = " + input);
        System.out.println("Output string = " + output);
    }


    private static String reverse(String s) {

        ArrayStack<Character> re = new ArrayStack<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            re.push(s.charAt(i));
        }
        String result = "";

        while(!re.isEmpty()){
            result = result + re.pop();
        }
        return result;
    }
}
