package leetcode;

/**
 * @Classname IntToRoman
 * @Description TODO
 * @Date 2019/10/23 15:10
 * @Created by 14241
 */
public class IntToRoman {
    public static void main(String[] args) {
        int num=58;
        System.out.println(intToRoman(num));

    }
    public static String intToRoman(int num){
        String result = "";
        int[] integer = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;num!=0;i++){
            while(num>=integer[i]){
                result+=roman[i];
                num-=integer[i];
            }
        }
        return result;
    }
}
