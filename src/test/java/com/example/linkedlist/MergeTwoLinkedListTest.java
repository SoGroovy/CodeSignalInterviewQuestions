package com.example.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class MergeTwoLinkedListTest {
    @Test
    public void mergeTwoLinkedList() {

        int[] arrayA = {1, 2, 3};
        int[] arrayB = {4, 5, 6};
        ListNode<Integer> a = AddTwoHugeNumbers.createListNode(arrayA);
        ListNode<Integer> b = AddTwoHugeNumbers.createListNode(arrayB);

        ListNode<Integer> merged = MergeTwoLinkedList.mergeTwoLinkedList(a, b);
        ListNode<Integer> pMerged = merged;
        List<Integer> expectedResults = new ArrayList<>(6);
        for (int i = 0; i < 6; i++  ) {
            expectedResults.set(i, i + 1);
        }
        List<Integer> actualResults = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
             actualResults.set(i, pMerged.value);
             pMerged = pMerged.next;
        }

        assertEquals(expectedResults, actualResults);
    }

}