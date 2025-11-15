package com.yrt;

import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedListTest myLinkedListTest = new MyLinkedListTest();
        myLinkedListTest.test();
    }
    public void test()
    {

        //  Your MyLinkedList object will be instantiated and called as such:
          MyLinkedList obj = new MyLinkedList();
            obj.addAtHead(1);


            obj.addAtTail(3);

            obj.addAtIndex(1,2);

        int i = obj.get(1);
        System.out.println("i="+i);

        obj.deleteAtIndex(1);
            obj.get(1);


    }
}
