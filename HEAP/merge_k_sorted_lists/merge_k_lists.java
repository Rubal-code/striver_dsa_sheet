/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        PriorityQueue<ListNode>minheap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists){
            if(list!=null){
                minheap.add(list);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!minheap.isEmpty()){
            ListNode smallest=minheap.poll();
            tail.next=smallest;
            tail=tail.next;
            if(smallest.next!=null){
                minheap.add(smallest.next);
            }
        }
        return dummy.next;
    }
}