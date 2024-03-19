import java.util.ArrayList;
import java.util.HashMap;

class _1171RemoveZeroSumConsecutiveNodesfromLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {

        ListNode temp = head;

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer> pf = new ArrayList<>();
        pf.add(temp.val);
        arr.add(temp.val);
        temp = temp.next;

        while (temp != null) {
            pf.add(temp.val + pf.get(pf.size() - 1));
            arr.add(temp.val);
            temp = temp.next;
        }

        if(pf.get(pf.size() - 1).equals(0)){
            return null;
        }

        mp.put(0, -1);
        for (int i = 0; i < pf.size(); ++i) {
            if(mp.containsKey(pf.get(i))){
                for(int j = mp.get(pf.get(i)) + 1; j <= i; ++j){
                    arr.set(j, 0);
                    if(!pf.get(j).equals(pf.get(i))){
                        mp.remove(pf.get(j));
                    }
                }
            } else {
                mp.put(pf.get(i), i);
            }

        }

        

        ListNode ansH = new ListNode();
        ListNode curr = ansH;

        for (int j = 0; j < arr.size(); ++j) {
            if (arr.get(j).equals(0)) {
                continue;
            }
            curr.next = new ListNode(arr.get(j));
            curr = curr.next;
        }

        return ansH.next;
    }

    public static void main(String[] args) {
        // ListNode res = removeZeroSumSublists(createList(new int[] { 5, -3, -4, 1, 6, -2, -5 }));
        // ListNode res = removeZeroSumSublists(createList(new int[] { 1, 3, 2, -3, -2, 5, 5, -5, 1 }));
        // ListNode res = removeZeroSumSublists(createList(new int[] {1,2,-2,2,-2,1,-1,1}));
        // ListNode res = removeZeroSumSublists(createList(new int[] {-4,5,0,1,-4,5,0,-5,-4,0,-3,4,-1,2}));
        // ListNode res = removeZeroSumSublists(createList(new int[] { 1, -1 }));
        ListNode res = removeZeroSumSublists(createList(new int[] { -1,0,2,-2,-2,-1,1,2,0 }));

        printallNodes(res);
    }

    public static void printallNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode createList(int[] items) {

        ListNode head = new ListNode();
        ListNode temp = head;

        for (int n : items) {
            temp.next = new ListNode(n);
            temp = temp.next;
        }

        return head.next;
    }
}
