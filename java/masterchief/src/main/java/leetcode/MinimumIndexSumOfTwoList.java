package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = getMap(list1);
        Map<String, Integer> map2 = getMap(list2);
        int minSum = Integer.MAX_VALUE;
        Map<Integer, List<String>> idxSumRestMap = new HashMap<>();
        for (String restaurant : list1) {
            if (map2.containsKey(restaurant)) {
                // this restaurant is in both list
                int idxSum = map1.get(restaurant) + map2.get(restaurant);
                if (!idxSumRestMap.containsKey(idxSum)) {
                    idxSumRestMap.put(idxSum, new ArrayList<>());
                }
                idxSumRestMap.get(idxSum).add(restaurant);
            }
        }
        int minKey = idxSumRestMap.keySet().stream()
                .mapToInt(Integer::valueOf).min().getAsInt();
        List<String> strings = idxSumRestMap.get(minKey);
        String[] result = strings.toArray(new String[]{});
        return result;
    }

    private Map<String, Integer> getMap(String[] list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (!map.containsKey(list[i])) {
                map.put(list[i], i);
            }
        }
        return map;
    }
}
