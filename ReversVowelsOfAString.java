package leetcode;

/**
 * @Classname ReversVowelsOfAString
 * @Description TODO
 * @Date 2020/6/2 15:20
 * @Created by Administrator
 */
public class ReversVowelsOfAString {
    public static void main(String[] args) {
        String s="hello";
        System.out.println(reverseVowels(s));

    }
    public static String reverseVowels(String s) {
        String vowels="aeuioAEUIO";
        char[] c=s.toCharArray();
        int i=0;
        int j=s.length()-i-1;
        while(i<j){
            while(i<j&&!vowels.contains(c[i]+"")){
                i++;
            }
            while(i<j&&!vowels.contains(c[j]+"")){
                j--;
            }
            if(i<j){
                char temp=c[i];
                c[i++]=c[j];
                c[j--]=temp;
            }
        }
        return new String(c);
    }
}
