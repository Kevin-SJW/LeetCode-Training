package leetcode;

/**
 * @Classname EditDistance
 * @Description TODO
 * @Date 2020/1/10 15:49
 * @Created by 14241
 * Given two words word1 and word2,
 * find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
    public static int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] cos=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            cos[i][0]=1;
        }
        for(int i=1;i<=len2;i++){
            cos[0][i]=1;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cos[i][j]=cos[i-1][j-1];
                }else{
                    cos[i][j]=findMin(cos[i-1][j-1],cos[i][j-1],cos[i-1][j]);
                    cos[i][j]+=1;
                }
            }
        }
        return cos[len1][len2];

    }

    public static int findMin(int a, int b, int c) { //找到三个数中的最小值
        int min=a<b?a:b;
        min=min<c?min:c;
        return min;
    }


}
