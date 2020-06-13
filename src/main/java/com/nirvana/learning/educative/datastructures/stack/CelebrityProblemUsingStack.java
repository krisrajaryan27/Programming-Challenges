package com.nirvana.learning.educative.datastructures.stack;

public class CelebrityProblemUsingStack {
    public static void main(String[] args) {
        int numPeople = 4;
        int[][] party = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        int result = findCelebrity(party, numPeople);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    result);

    }

    public static int findCelebrity(int[][] party, int numPeople) {
        Stack<Integer> stack = new Stack<>(numPeople);
        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }
        while (stack.getCurrentSize() > 1) {
            int person1 = stack.pop();
            int person2 = stack.pop();
            if (knows(party, person1, person2)) {
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }
        int celebrity = stack.pop();
        for (int i = 0; i < numPeople; i++) {
            // If any person doesn't know 'c' or c knows any person, return -1
            if (i != celebrity && (knows(party, celebrity, i) || !knows(party, i, celebrity)))
                return -1;
        }
        return celebrity;
    }

    public static boolean knows(int[][] party, int person1, int person2) {
        return party[person1][person2] == 1;
    }
}
