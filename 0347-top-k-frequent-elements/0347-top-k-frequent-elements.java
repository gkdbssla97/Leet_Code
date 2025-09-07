class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer, Node> map = new LinkedHashMap<>();
        // // LFU랑 똑같노 ㅋㅋ
        // PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.freq, o1.freq));
        // for(int num : nums) {
        //     if(map.containsKey(num)) {
        //         Node node = map.get(num);
        //         node.freq++;
        //         pq.remove(node);
        //         pq.offer(node);
        //     } else {
        //         Node node = new Node(num, 1);
        //         map.put(num, node);
        //         pq.offer(node);
        //     }
        // }
        // int[] res = new int[k];
        // int idx = 0;
        // while(k-- > 0) {
        //     res[idx++] = pq.poll().key;
        // }
        // return res;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // LFU랑 똑같노 ㅋㅋ
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.freq, o2.freq));
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int _k = entry.getKey();
            int _v = entry.getValue();
            Node node = new Node(_k, _v);
            pq.offer(node);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = k - 1;  // Min-Heap은 오름차순이므로 뒤에서부터 채움
        while (!pq.isEmpty()) {
            res[idx--] = pq.poll().key;
        }

        return res;
    }

    static class Node {
        int key, freq;

        Node(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
}