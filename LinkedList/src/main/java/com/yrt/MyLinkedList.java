package com.yrt;
public class MyLinkedList {
    int val;
    MyLinkedList next;
    MyLinkedList prev;
    public MyLinkedList (){

    }
    public MyLinkedList(int val) {
        this.val = val;
    }


    public int get(int index) {
        MyLinkedList cur = this;
        int flag = 0;

        while(cur.next!=null){
            if(flag == index)
                return cur.val;
            }

        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList cur = new MyLinkedList(val);
        cur.next = this;
        this.prev = cur;
//        this = this.prev;
    }

    public void addAtTail(int val) {
        MyLinkedList node = new MyLinkedList(val);
        this.next = node;
        node.prev = this;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList cur =  this;
        int flag = 0 ;
        while(cur.next!=null){
            if(flag == index){
                MyLinkedList insertNode = new MyLinkedList(val);
                cur.prev.next = insertNode;
                insertNode.next = cur;
            }
            flag++;
        }

    }

    public void deleteAtIndex(int index) {
        MyLinkedList dummy = new MyLinkedList();
        dummy.next = this;
        MyLinkedList cur = dummy;

        int flag = -1;
        while(cur.next!=null){
            if(flag == index){
                cur.prev = cur.next;
            }
            flag ++ ;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */