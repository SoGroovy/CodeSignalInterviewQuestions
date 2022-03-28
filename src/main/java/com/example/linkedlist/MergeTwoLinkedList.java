package com.example.linkedlist;


public class MergeTwoLinkedList {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3};
        int[] arrayB = {4, 5, 6};
        ListNode<Integer> a = AddTwoHugeNumbers.createListNode(arrayA);
        ListNode<Integer> b = AddTwoHugeNumbers.createListNode(arrayB);

        ListNode<Integer> merged = MergeTwoLinkedList.mergeTwoLinkedList(a, b);
        AddTwoHugeNumbers.displayListNode(merged);
    }
// why is this code slower? It's correct, but slow
//    public static ListNode<Integer> mergeTwoLinkedList(ListNode<Integer> l1, ListNode<Integer> l2) {
//        ListNode<Integer> mergedList = new ListNode<>(0);
//        ListNode<Integer> pList = mergedList;
//        ListNode<Integer> pA = l1;
//        ListNode<Integer> pB = l2;
//         while (pA != null && pB != null) {
//            if (pA.value < pB.value) {
//                pList.next = new ListNode<>(pA.value);
//                pA = pA.next;
//                pList = pList.next;
//            } else if (pB.value < pA.value) {
//                pList.next = new ListNode<>(pB.value);
//                pB = pB.next;
//                pList = pList.next;
//            } else if (pA.value == pB.value) {
//                pList.next = new ListNode<>(pA.value);
//                pList = pList.next;
//                pA = pA.next;
//                pList.next = new ListNode<>(pB.value);
//                pList = pList.next;
//                pB = pB.next;
//            }
//        }
//
//         while (pA != null) {
//             pList.next = pA;
//             pList = pList.next;
//             pA = pA.next;
//         }
//
//        while (pB != null) {
//            pList.next = pB;
//            pList = pList.next;
//            pB = pB.next;
//        }
//
//        return mergedList.next;
//    }

    static ListNode<Integer> mergeTwoLinkedList(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> mergedList = new ListNode<Integer>(0);
        ListNode<Integer> pList = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                pList.next = l1;
                l1 = l1.next;

            } else {
                pList.next = l2;
                l2 = l2.next;

            }
            pList = pList.next;
        }

        if (l1 != null) {
            pList.next = l1;
        }

        if (l2 != null) {
            pList.next = l2;
        }

        return mergedList.next;
    }
}
