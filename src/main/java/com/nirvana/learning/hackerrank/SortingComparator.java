package com.nirvana.learning.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=virtusa
 *
 * @author Krishna Verma
 */
public class SortingComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int scoreDesc = o2.score - o1.score;
        int nameAsc = o1.name.compareTo(o2.name);
        return scoreDesc == 0 ? nameAsc : scoreDesc;
    }
}

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() &&
                Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
