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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = Arrays.stream(nums)  // convert to IntStream
                         .boxed()       // box to Integer
                         .collect(Collectors.toSet());
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        ListNode temp=head;
        while(temp!=null){
            if(!set.contains(temp.val)) {
                curr.next=new ListNode(temp.val);
                curr=curr.next;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}
