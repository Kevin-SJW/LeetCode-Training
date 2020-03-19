package leetcode;

/**
 * @Classname ExcelSheetColumnNumber
 * @Description TODO
 * @Date 2020/3/19 15:21
 * @Created by 14241
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s="AB";
        System.out.println(titleToNumber(s));

    }
    public static int titleToNumber(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum=sum*26+s.charAt(i)-64;

        }
        return sum;
    }
}
