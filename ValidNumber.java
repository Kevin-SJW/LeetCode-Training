package leetcode;

/**
 * @Classname ValidNumber
 * @Description TODO
 * @Date 2020/1/1 15:40
 * @Created by 14241
 */
public class ValidNumber {
    public static void main(String[] args) {
        String s = "99e2.5";
        System.out.println(isNumber(s));

    }

    public static boolean isNumber(String s) {
        // 处理非法长度的字符串
        if (s == null || s.length() == 0) {
            return false;
        }
        //设定返回标记，初始值为true
        boolean flag = true;
        //去空格
        s = s.trim();
        try {
            //使用了Double类的parseDouble方法，将所给的字符串转换为double类型的数
            double d = Double.parseDouble(s);
            //判断浮点数，标志位为 f，或者 D
            if (s.charAt(s.length() - 1) == 'f' || s.charAt(s.length() - 1) == 'D') {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;

    }
}
