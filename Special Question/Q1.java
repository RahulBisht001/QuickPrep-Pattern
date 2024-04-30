/*
 * Geek wants to create a string from the characters of string str
 * of size n but he wants to make sure that no character appears more than k
 * times consecutively in the new string. Find the lexographically largest
 * string geek could create
 * 
 * 
 * Note: : Using all the characters from s is
 */

/*
 * input :
 * n = 5
 * k = 2
 * string s = zzaaa
 * 
 * output : zzaa
 */

//? Source : Geeksforgeeks weekly contest 145 medium problem

import java.util.HashMap;
import java.util.PriorityQueue;

class Node {
    int freq;
    char ch;

    public Node(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
}

class Solution {
    public static String createString(int n, int k, String s) {

        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.ch - a.ch);

        for (char key : map.keySet())
            pq.add(new Node(map.get(key), key));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int freq = curr.freq;
            int val = k;

            while (val > 0 && freq > 0) {
                res.append(curr.ch);
                val--;
                freq--;
            }

            if (freq != 0) {
                if (!pq.isEmpty()) {
                    Node second = pq.poll();
                    res.append(second.ch);
                    second.freq--;

                    if (second.freq > 0) {
                        pq.add(new Node(second.freq, second.ch));
                    }
                    pq.add(new Node(freq, curr.ch));
                }
            }

        }

        return res.toString();
    }
}