package com.yrt;

import java.util.*;

public class FrameDemo1 {

    public static void recursion(int count) {
        System.out.println(count);
        recursion(count + 1);
    }

    public static void main(String[] args) {

        recursion(0);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.getFirst();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.get(1);

        List<Integer> list = new LinkedList<>();
        list.get(1);

    }
}
