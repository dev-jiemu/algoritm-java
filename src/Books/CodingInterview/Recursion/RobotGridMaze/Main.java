package src.Books.CodingInterview.Recursion.RobotGridMaze;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /* R - 로봇, # - 미로, T - 도달 위치
        (m, n) +           +
               |R| | | | | |
               |R|R| | | | |
               |#|R|R|R|R| |
               |#|#|#|#|R| |
               | | | | |R| |
               | | | | |R|T|
               +           + (0, 0)
        */

        Set<Point> path = new LinkedHashSet<>();

        boolean[][] maze  = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;

        RobotGrid.computePath(5, 5, maze, path);

        System.out.println("Computed path (plain recursion):");
        path.forEach(System.out::println);

        Set<Point> visited = new HashSet<>();

        // 메모이제이션
        RobotGrid.computePath(5, 5, maze, path, visited);

        System.out.println("\nComputed path (Memoization):");
        path.forEach(System.out::println);
    }
}
