package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P2456 {

    private static class MyType implements Comparable<MyType> {
        private String creator;
        private String id;
        private int view;

        public MyType(String creator, String id, int view) {
            this.creator = creator;
            this.id = id;
            this.view = view;
        }

        @Override
        public int compareTo(MyType o) {
            if (view != o.view) return Integer.compare(o.view, view);
            return id.compareTo(o.id);
        }

        public String getCreator() {
            return creator;
        }

        public String getId() {
            return id;
        }

        public int getView() {
            return view;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> creatorPopularityCount = new HashMap<>();
        int n = creators.length;
        for (int i=0;i<n;++i) {
            String creator = creators[i];
            creatorPopularityCount.put(creator, creatorPopularityCount.getOrDefault(creator, 0) + views[i]);
        }

        Integer maxCreatorPopularity = creatorPopularityCount.values().stream().max(Integer::compareTo).get();
        List<MyType> a = new ArrayList<>();
        for (int i=0;i<n;++i) {
            if (creatorPopularityCount.get(creators[i]).equals(maxCreatorPopularity)) {
                a.add(new MyType(creators[i], ids[i], views[i]));
            }
        }

        a.sort(MyType::compareTo);

        List<List<String>> result = new ArrayList<>();
        Set<String> appearedCreator = new HashSet<>();
        for (MyType entry: a) {
            if (!appearedCreator.contains(entry.getCreator())) {
                result.add(Arrays.asList(entry.getCreator(), entry.getId()));
                appearedCreator.add(entry.getCreator());
            }
        }

        return result;
    }
}
