package lib;

import java.util.List;

public class CompareHelper{
    public static boolean listEqual(List x, List y){
        if (x.size() != y.size()) return false;
        for (int i=0;i<x.size();++i){
            if (!x.get(i).equals(y.get(i))) return false;
        }
        return true;
    }
}
