package com.shao.progkievua.homework.lecture8.listqueue;

import java.util.Random;

public class StackRunner {
    public static void main(String[] args) {
        DynamicStack<Integer> dynamicStack = new DynamicStack<>();
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        DynamicQueue<Integer> dynamicQueue = new DynamicQueue<>();
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        createArray(dynamicStack);
        System.out.println(dynamicStack);
        removeElements(dynamicStack, dynamicStack.size() / 2);
        System.out.println(dynamicStack);

        createArray(linkedStack);
        System.out.println(linkedStack);
        removeElements(linkedStack, linkedStack.size() / 2);
        System.out.println(linkedStack);

        createArray(linkedListStack);
        System.out.println(linkedListStack);
        removeElements(linkedListStack, linkedListStack.size() / 2);
        System.out.println(linkedListStack);

        createArray(dynamicQueue);
        System.out.println(dynamicQueue);
        removeElements(dynamicQueue, dynamicQueue.size() / 2);
        System.out.println(dynamicQueue);

        createArray(linkedQueue);
        System.out.println(linkedQueue);
        removeElements(linkedQueue, linkedQueue.size() / 2);
        System.out.println(linkedQueue);

        createArray(linkedListQueue);
        System.out.println(linkedListQueue);
        removeElements(linkedListQueue, linkedListQueue.size() / 2);
        System.out.println(linkedListQueue);
    }

    private static void removeElements(Stack stack, int toDel) {
        for (int i = 0; i < toDel; i++) {
            stack.pop();
        }
    }

    private static void removeElements(Queue stack, int toDel) {
        for (int i = 0; i < toDel; i++) {
            stack.remove();
        }
    }

    private static void createArray(Stack stack) {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(20) + 10; i++) {
            stack.push(random.nextInt(100));
        }
    }

    private static void createArray(Queue stack) {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(20) + 10; i++) {
            stack.offer(random.nextInt(100));
        }
    }
}
