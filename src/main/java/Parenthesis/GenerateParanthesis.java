package Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        dfs(n, 0,0, sb, res);
        return res;
    }

    private static void dfs(int n, int left, int right,StringBuilder sb, List<String> res  ){
        if(left ==n && right == n){
            res.add(sb.toString());
            return;
        }

        if(right < left){
            sb.append(")");
            dfs(n, left, right+1, sb, res);
            sb.setLength(sb.length() - 1);
        }

        if(left < n){
            sb.append('(');
            dfs(n, left+1, right, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        res.forEach(x -> System.out.println(x));
    }


}
