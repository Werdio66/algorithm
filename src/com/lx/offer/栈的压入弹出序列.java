package com.lx.offer;

import java.util.LinkedList;

/**
 * @author Werdio丶
 * @since 2021-02-05 09:33:46
 */
public class 栈的压入弹出序列 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (i < pushed.length){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && (stack.peekFirst() == popped[j])){
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
