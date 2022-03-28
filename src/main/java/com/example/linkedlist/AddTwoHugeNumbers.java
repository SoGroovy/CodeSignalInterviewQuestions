package com.example.linkedlist;

public class AddTwoHugeNumbers {
    public static void main(String[] args) {
        int[] arrayA = {90, 91, 92};
        int[] arrayB = {50, 51, 52, 53, 54};
        int[] arrayX = {1};
        int[] arrayY = {9998, 9999, 9999, 9999};
//        com.example.linkedlist.ListNode<Integer> a = createListNode(8);
//        com.example.linkedlist.ListNode<Integer> b = createListNode(10);
//        com.example.linkedlist.ListNode<Integer> sum = sumOfDifferentLengths(a, b);
//        displayListNode(a);
//        displayListNode(b);
//        displayListNode(sum);
        ListNode<Integer> a = createListNode(arrayX);
        ListNode<Integer> aRev = reverse(a);

        ListNode<Integer> b = createListNode(arrayY);
        ListNode<Integer> bRev = reverse(b);

        ListNode<Integer> sum1 = sumOfDifferentLengths(aRev, bRev);
        displayListNode(a);
        displayListNode(b);
        displayListNode(sum1);
        ListNode<Integer> sumRev = reverse(sum1);
        displayListNode(sumRev);
    }

    public static ListNode<Integer> createListNode(int listNodeLength) {
        ListNode<Integer> l1 = new ListNode<>(0);
        ListNode<Integer> current = l1;
        int count = 0;
        while (count < listNodeLength) {
            current.next = new ListNode<Integer>((int) (Math.random() * 100));
            count++;
            current = current.next;
        }
        return l1.next;
    }

    public static ListNode<Integer> createListNode(int[] a) {
        ListNode<Integer> list = new ListNode<>(0);
        ListNode<Integer> p = list;
        for (int i = 0; i < a.length; i++) {
            p.next = new ListNode<Integer>(a[i]);
            p = p.next;
        }
        return list.next;
    }

    public static ListNode<Integer> reverse(ListNode<Integer> x) {
        ListNode<Integer> list = null;
        ListNode<Integer> p = x;
        ListNode<Integer> front;

        while (p != null) {
            front = new ListNode<Integer>(p.value);
            front.next = list;
            p = p.next;
            list = front;
        }
        return list;
    }

    public static void displayListNode(ListNode<Integer> list) {
        while (list != null) {
            System.out.print(list.value);
            if (Integer.toString(list.value).length() == 5) {
                System.out.print(" ");
            } else if (Integer.toString(list.value).length() == 4) {
                System.out.print("  ");
            } else if (Integer.toString(list.value).length() == 3) {
                System.out.print("   ");
            } else if (Integer.toString(list.value).length() == 2) {
                System.out.print("    ");
            } else {
                System.out.print("     ");
            }
            list = list.next;
        }
        System.out.println();
    }

    public static ListNode<Integer> sumOfListNodeWithFixedLength(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> list = new ListNode<>(0);
        ListNode<Integer> current = list;
        int carry = 0;
        int maxNumbers = 0;
        ListNode<Integer> p = a;
        while (p != null) {
            if (Integer.toString(a.value).length() > maxNumbers) {
                maxNumbers = Integer.toString(a.value).length();
            }
            p = p.next;
        }

        while (a != null && b != null) {
            if (carry == 1) {
                current.next = new ListNode<Integer>(a.value + b.value + 1);
            } else {
                current.next = new ListNode<Integer>(a.value + b.value);
            }
            current = current.next;
//            if (current.value > (int)Math.pow(10.0, maxNumbers + 1)) {
            if (current.value > (int)Math.pow(10.0, maxNumbers)) {
                current.value -= (int) Math.pow(10.0, maxNumbers);
                carry = 1;
            } else {
                carry = 0;
            }
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            current.next = new ListNode<Integer>(a.value);
            if (carry == 1) {
                current = current.next;
                current.value = current.value + 1;
            }
        }

        if (b != null) {
            current.next = new ListNode<Integer>(b.value);
            if (carry == 1) {
                current = current.next;
                current.value = current.value + 1;
            }
        }

        if (current.next == null && carry == 1) {
            current.next = new ListNode<Integer>(1);
        }
        return list.next;
    }

    public static ListNode<Integer> sumOfDifferentLengths(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> list = new ListNode<>(0);
        ListNode<Integer> current = list;
        int carry = 0;
        int maxNumbers = 0;
        ListNode<Integer> p = a;
        while (p != null) {
            if (Integer.toString(p.value).length() > maxNumbers) {
                maxNumbers = Integer.toString(p.value).length();
            }
            p = p.next;
        }

        ListNode<Integer> v = b;
        while (v != null) {
            if (Integer.toString(v.value).length() > maxNumbers) {
                maxNumbers = Integer.toString(v.value).length();
            }
            v = v.next;
        }

        while (a != null && b != null) {
            if (carry == 1) {
                current.next = new ListNode<Integer>(a.value + b.value + 1);
            } else {
                current.next = new ListNode<Integer>(a.value + b.value);
            }
            current = current.next;
            if (current.value >= Math.pow(10.0, maxNumbers)) {
                current.value -= (int) Math.pow(10.0, maxNumbers);
                carry = 1;
            } else {
                carry = 0;
            }
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            if (carry == 1) {
                current.next = new ListNode<Integer>(a.value + 1);
                carry = 0;
            } else {
                current.next = new ListNode<Integer>(a.value);
            }
            current = current.next;
            if (current.value >= Math.pow(10.0, maxNumbers)) {
                current.value -= (int) Math.pow(10.0, maxNumbers);
                carry = 1;
            } else {
                carry = 0;
            }
            a = a.next;
        }

        while (b != null) {
            if (carry == 1) {
                current.next = new ListNode<Integer>(b.value + 1);
                carry = 0;
            } else {
                current.next = new ListNode<Integer>(b.value);
            }
            current = current.next;
            if (current.value >= Math.pow(10.0, maxNumbers)) {
                current.value -= (int) Math.pow(10.0, maxNumbers);
                carry = 1;
            } else {
                carry = 0;
            }
            b = b.next;
        }
        if (current.next == null && carry == 1) {
            current.next = new ListNode<Integer>(1);
        }
        return list.next;
    }

    public static ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> aRev = reverse(a);
        ListNode<Integer> bRev = reverse(b);
        ListNode<Integer> list = new ListNode<>(0);
        ListNode<Integer> current = list;
        int carry = 0;
        int maxNumbers = 0;
        ListNode<Integer> p = aRev;
        while (p != null) {
            if (Integer.toString(p.value).length() > maxNumbers) {
                maxNumbers = Integer.toString(p.value).length();
            }
            p = p.next;
        }

        p = bRev;
        while (p != null) {
            if (Integer.toString(p.value).length() > maxNumbers) {
                maxNumbers = Integer.toString(p.value).length();
            }
            p = p.next;
        }

        while (aRev != null && bRev != null) {
            if (carry == 1) {
                current.next = new ListNode<Integer>(aRev.value + bRev.value + 1);
            } else {
                current.next = new ListNode<Integer>(aRev.value + bRev.value);
            }
            current = current.next;
            if (current.value >= Math.pow(10.0, maxNumbers )) {
                current.value -= (int) Math.pow(10.0, maxNumbers);
                carry = 1;
            } else {
                carry = 0;
            }
            aRev = aRev.next;
            bRev = bRev.next;
        }

        if (aRev != null) {
            current.next = aRev;
            if (carry == 1) {
                current = current.next;
                current.value = current.value + 1;
            }
        }

        if (bRev != null) {
            current.next = bRev;
            if (carry == 1) {
                current = current.next;
                current.value = current.value + 1;
            }
        }
        if (current.next == null && carry == 1) {
            current.next = new ListNode<Integer>(1);
        }
        return list.next;
    }


}
