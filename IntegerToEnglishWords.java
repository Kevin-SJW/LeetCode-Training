package leetcode;

/**
 * @Classname IntegerToEnglishWords
 * @Description TODO
 * @Date 2020/4/15 16:14
 * @Created by 14241
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num=123;
        System.out.println(numberToWords(num));

    }

    static String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] decade = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] big = {"Billion", "Million", "Thousand", ""};

    public static String numberToWords(int num) {
        //特判0。
        if (num == 0) return small[0];
        String res = "";
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j++) {
            if (num >= i) {
                res += part(num / i) + big[j] + ' ';
                num %= i;
            }
        }
        while (res.charAt(res.length() - 1) == ' ') res = res.substring(0, res.length() - 1);
        return res;
    }

    static String part(int num) {
        String res = "";
        if (num >= 100) {
            //此处需要注意Hundred前后都有空格
            res += small[num / 100] + " Hundred ";
            num %= 100;
        }
        if (num == 0) return res;
        //小于20的，可以直接加
        if (num >= 20) {
            res += decade[num / 10] + ' ';
            num %= 10;
        }
        if (num == 0) return res;
        res += small[num] + ' ';
        return res;
    }
}
