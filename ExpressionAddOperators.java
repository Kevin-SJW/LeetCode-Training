package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ExpressionAddOperators
 * @Description TODO
 * @Date 2020/4/17 15:48
 * @Created by 14241
 */
public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num,target));

    }
    public static List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        if (num == null || num.length() == 0)
            return ret;
        helper(ret, "", num, target, 0, 0, 0);
        return ret;
    }

    /**
     * 问题是取数字的时候可能 超过int的范围，用long来处理
     * @param ret
     * @param path
     * @param num
     * @param target
     * @param pos
     * @param curRes
     * @param preNum
     */
    public static void helper(List<String> ret, String path, String num,
                       int target, int pos, long curRes, long preNum) {
        if (pos == num.length()) {
            if (target == curRes)
                ret.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // 得到当前截出的数
            // 对于前导为0的数予以排除，pos为第一位
            if (i != pos && num.charAt(pos) == '0')
                return;
            long curNum = Long.valueOf(num.substring(pos, i + 1));
            // 处理前导的另一种方法，当前substring长度和curNum长度不等说明有前导0
            // 处理前导0的情况比如“105”，5一种结果是1*05
            // if (num.substring(pos, i + 1).length() !=
            // String.valueOf(curNum).length())

            // return;
            // 如果不是第一个字母时，可以加运算符，否则只加数字
            if (pos == 0) {
                helper(ret, path + curNum, num, target,
                        i + 1, curNum, curNum);
            } else {
                helper(ret, path + "+" + curNum, num, target,
                        i + 1, curRes + curNum, curNum);

                helper(ret, path + "-" + curNum, num, target,
                        i + 1, curRes - curNum, -curNum);
                // 注意乘法，因为之前加了preNum，本次要减去！
                helper(ret, path + "*" + curNum, num, target,
                        i + 1, curRes - preNum + preNum * curNum,
                        preNum * curNum);
                // if(curNum != 0) helper(ret, num, path + "/" + cur, i+1,
                // curRes-preNum+preNum/curNum, target, preNum/curNum);
            }
        }
    }


}
