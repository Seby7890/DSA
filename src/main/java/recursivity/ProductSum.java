package recursivity;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    //[5,2,[7,-1],3,[6,[-13,8],4]]
    //5+2 + 2 * 6 + 3 - 10
    public static int productSum(List<Object> specialArray, int multiplier) {
        int sum = 0;
        for (Object el : specialArray) {
            if (el instanceof ArrayList) {
                ArrayList<Object> newSpecialArray = (ArrayList<Object>) el;
                sum += productSum(newSpecialArray, multiplier + 1);
            } else {
                sum += (Integer) el;
            }
        }
        return sum * multiplier;
    }

    public static void main(String[] args) {
        List<Object> specialArray = new ArrayList<>();
        List<Integer> firstArray = new ArrayList<>();
        firstArray.add(7);
        firstArray.add(-1);
        specialArray.add(5);
        specialArray.add(2);
        specialArray.add(firstArray);
        System.out.println(productSum(specialArray,1));
    }
}