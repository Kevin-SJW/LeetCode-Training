package leetcode;

/**
 * @Classname ExcelSheetColumnTitle
 * @Description TODO
 * @Date 2020/3/18 15:36
 * @Created by 14241
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int n=28;
        System.out.println(convertToTitle(n));

    }
    public static String convertToTitle(int n) {
        String s="";
        while(n!=0){
            int temp=(n-1)%26;
            s=(char)('A'+temp)+s;
            n=(n-1)%26;
        }
        return s;

    }
}
