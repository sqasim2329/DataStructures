package com.data.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
	
	 private final int[][] directions = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 },
				{ -1, 2 }, { -1, -2 } };
	    
	    public int minKnightMoves(int x, int y) {
	        
			int nMoves = 0;
			Queue<int[]> q = new LinkedList<>();
			boolean visited[][] = new boolean[301][301];

			x = Math.abs(x);
			y = Math.abs(y);
			
			if (x == 1 && y == 1)
				return 2;

			q.add(new int[] { 0, 0 });
			visited[0][0] = true;

			while (!q.isEmpty()) {
				int size = q.size();

				for (int i = 0; i < size; i++) {
					int[] p = q.poll();

					if (p[0] == x && p[1] == y)
						return nMoves;

					for (int j = 0; j < directions.length; j++) {
						int newX = p[0] + directions[j][0];
						int newY = p[1] + directions[j][1];
						if (newX < 0 || newX > 300 || newY < 0 || newY > 300)
							continue;

						if (!visited[newX][newY]) {
							q.add(new int[] { newX, newY });
							visited[newX][newY] = true;
						}
					}
				}
				nMoves++;
			}
			return -1;
	    }

}
