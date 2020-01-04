package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname TextJustification
 * @Description TODO
 * @Date 2020/1/4 15:21
 * @Created by 14241
 *
 * Given an array of words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 */
public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth=16;
        System.out.println(fullJustify(words,maxWidth));


    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<String>();
        StringBuilder line = new StringBuilder();
        int blanknum = 0;
        int wordnum = 0;
        int remainer = 0;
        int index = 0;
        for(String i : words){
            if(line.length()==0){
                line.append(i);
            }else if(line.length()+1+i.length()<=maxWidth){
                line.append(" ");
                line.append(i);
            }else{
                if(wordnum==1){
                    while(line.length()<maxWidth){
                        line.append(" ");
                    }
                }else{
                    blanknum = (maxWidth - line.length())/(wordnum-1);
                    remainer = (maxWidth - line.length())%(wordnum-1);
                    line.delete(0, line.length());
                    for(int k=index-wordnum;k<index;k++){
                        line.append(words[k]);
                        if(line.length()<maxWidth){
                            for(int j=0;j<(k-index+wordnum<remainer?blanknum+2:blanknum+1);j++){
                                line.append(" ");
                            }
                        }
                    }
                }
                res.add(line.toString());
                line.delete(0,line.length());
                line.append(i);
                wordnum=0;
            }
            index++;
            wordnum++;
        }
        while(line.length()<maxWidth){
            line.append(" ");
        }
        res.add(line.toString());
        return res;
    }
}
