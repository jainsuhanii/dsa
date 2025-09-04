
import java.util.*;

class Cell {
    int x, y, dis;

    Cell(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Knight {

    // check if coordinates are inside the board
    static boolean isInside(int x, int y, int n) {
        return (x >= 1 && x <= n && y >= 1 && y <= n);
    }

    public int moves(int[] KnightPos, int[] targetPos, int n) {
        // possible Knight moves
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(KnightPos[0], KnightPos[1], 0));

        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[KnightPos[0]][KnightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell t = q.poll();

            // if we reach target
            if (t.x == targetPos[0] && t.y == targetPos[1]) {
                return t.dis;
            }

            // check all 8 possible moves
            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (isInside(x, y, n) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new Cell(x, y, t.dis + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 30;
        int[] KnightPos = {1, 1};
        int[] targetPos = {30, 30};

        Knight k = new Knight();
        System.out.println(k.moves(KnightPos, targetPos, n));
    }
}
