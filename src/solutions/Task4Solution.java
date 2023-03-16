package solutions;


public class Task4Solution {
    public static String add(String a, String b){
        byte rem = 0;
        char temp;

        StringBuilder sum = new StringBuilder();
        int i = 0;
        while(i <  a.length() && i < b.length()){

            temp = (char)(a.charAt(a.length() - 1 - i) + b.charAt(b.length() - 1 - i) - 2 * '0' + rem);
            sum.append((char)(temp % 2 + '0'));
            rem = (byte)(temp / 2);
            i++;
        }
        while(i < a.length()){
            temp = (char)(a.charAt(a.length() - 1 - i) - 2 * '0' + rem);
            sum.append((char)(temp % 2 + '0'));
            rem = (byte)(temp / 2);
            i++;
        }

        while(i < b.length()){
            temp = (char)(b.charAt(b.length() - 1 - i) - 2 * '0' + rem);
            sum.append((char)(temp % 2 + '0'));
            rem = (byte)(temp / 2);
            i++;
        }
        if(rem != 0){
            sum.append('1');
        }
        return sum.reverse().toString();
    }
}
