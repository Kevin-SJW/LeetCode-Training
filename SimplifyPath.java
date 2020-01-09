package leetcode;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname SimplifyPath
 * @Description TODO
 * @Date 2020/1/9 15:38
 * @Created by 14241
 * Given an absolute path for a file (Unix-style),
 * simplify it. Or in other words, convert it to the canonical path.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path="/home//foo/";
        System.out.println(simplifyPath(path));

    }
    public static String simplifyPath(String path) {
            if(path.length()==0){
                return "";
            }
            if(path.length()==1){
                return "/";
            }
            Stack<String> stack=new Stack();
            String[] strings=path.split("/");
            for(int i=0;i<strings.length;i++){
                String str=strings[i];
                if(str.equals('.')||str.equals("")){
                    continue;
                }
                else if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.push(str);
                    }
                }else{
                    stack.push(str);
                }
            }
            if(stack.isEmpty()){
                return "/";
            }
            String res="";
            while(!stack.isEmpty()){
                res="/"+stack.pop()+res;
            }
            return res;
    }
}
