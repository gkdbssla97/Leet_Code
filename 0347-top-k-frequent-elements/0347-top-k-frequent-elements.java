class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new LinkedHashMap<>();
        // LFU랑 똑같노 ㅋㅋ
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.freq, o1.freq));
        for(int num : nums) {
            if(map.containsKey(num)) {
                Node node = map.get(num);
                node.freq++;
                pq.remove(node);
                pq.offer(node);
            } else {
                Node node = new Node(num, 1);
                map.put(num, node);
                pq.offer(node);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while(k-- > 0) {
            res[idx++] = pq.poll().key;
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