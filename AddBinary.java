package leetcode;

/**
 * @Classname AddBinary
 * @Description TODO
 * @Date 2020/1/3 15:31
 * @Created by 14241
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a,b));

    }
    public static String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder sb=new StringBuilder();
        int carry=0;
        while(i>=0||j>=0){
            int sum=carry;
            if(j>=0){
                sum+=b.charAt(j--)-'0';
            }
            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }
            sb.append(sum%2);
            carry=sum/2;

        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();


    }
}
