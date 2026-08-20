import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put first node of every list into heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode smallest = pq.poll();

            // Add it to result
            curr.next = smallest;
            curr = curr.next;

            // Add next node from same list
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
