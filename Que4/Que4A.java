package Que4;

import java.security.Key;
import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {

        int startI = 0;
        int startJ = 0;
        int keysCount = 0;

        String keys = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '@') {
                    startI = i;
                    startJ = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keysCount++;

                }
            }
        }

        return bfs(grid, startI, startJ, new HashSet<>(), "", keysCount);
    }

    public int bfs(String[] grid, int i, int j, Set<String> visited, String state, int keysCount) {

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(i, j, state));
        visited.add(i + " " + j + " " + state);

        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Cell current = queue.poll();
                visited.add(current.i + " " + current.j + " " + current.state);
                // NORTH
                int nextN = current.i - 1;
                if (current.i > 0 &&
                        (grid[nextN].charAt(current.j) == '.' || grid[nextN].charAt(current.j) == '@' ||
                                (grid[nextN].charAt(current.j) >= 'a' && grid[nextN].charAt(current.j) <= 'f'
                                        && state.contains(String.valueOf(grid[nextN].charAt(current.j)))))
                        &&
                        !visited.contains(nextN + " " + current.j + " " + current.state)) {
                    queue.add(new Cell(nextN, current.j, current.state));
                } else if (current.i > 0 &&
                        grid[nextN].charAt(current.j) >= 'A' &&
                        grid[nextN].charAt(current.j) <= 'F'
                        && !visited.contains(nextN + " " + current.j + " " + current.state)) {
                    if (current.state.contains(String.valueOf(grid[nextN].charAt(current.j)).toLowerCase())) {
                        queue.add(new Cell(nextN, current.j, current.state));
                    }
                } else if (current.i > 0 &&
                        grid[nextN].charAt(current.j) >= 'a' &&
                        grid[nextN].charAt(current.j) <= 'f' &&
                        !visited.contains(nextN + " " + current.j + " " + current.state)) {
                    String newState = current.state;
                    if (!current.state.contains(String.valueOf(grid[nextN].charAt(current.j)))) {
                        newState += grid[nextN].charAt(current.j);
                        if (newState.length() == keysCount) {
                            return level;
                        }
                    }
                    queue.add(new Cell(nextN, current.j, newState));
                }

                // SOUTH
                int nextS = current.i + 1;
                if (current.i < grid.length - 1 &&
                        (grid[nextS].charAt(current.j) == '.' || grid[nextS].charAt(current.j) == '@' ||
                                (grid[nextS].charAt(current.j) >= 'a' && grid[nextS].charAt(current.j) <= 'f'
                                        && state.contains(String.valueOf(grid[nextS].charAt(current.j)))))
                        &&
                        !visited.contains(nextS + " " + current.j + " " + current.state)) {
                    queue.add(new Cell(nextS, current.j, current.state));
                } else if (current.i < grid.length - 1 &&
                        grid[nextS].charAt(current.j) >= 'A' &&
                        grid[nextS].charAt(current.j) <= 'F'
                        && !visited.contains(nextS + " " + current.j + " " + current.state)) {
                    if (current.state.contains(String.valueOf(grid[nextS].charAt(current.j)).toLowerCase())) {
                        queue.add(new Cell(nextS, current.j, current.state));
                    }
                } else if (current.i < grid.length - 1 &&
                        grid[nextS].charAt(current.j) >= 'a' &&
                        grid[nextS].charAt(current.j) <= 'f' &&
                        !visited.contains(nextS + " " + current.j + " " + current.state)) {
                    String newState = current.state;
                    if (!current.state.contains(String.valueOf(grid[nextS].charAt(current.j)))) {
                        newState += grid[nextS].charAt(current.j);
                        if (newState.length() == keysCount) {
                            return level;
                        }
                    }
                    queue.add(new Cell(nextS, current.j, newState));
                }

                // EAST
                int nextE = current.j - 1;
                if (current.j > 0 &&
                        (grid[current.i].charAt(nextE) == '.' || grid[current.i].charAt(nextE) == '@' ||
                                (grid[current.i].charAt(nextE) >= 'a' && grid[current.i].charAt(nextE) <= 'f'
                                        && state.contains(String.valueOf(grid[current.i].charAt(nextE)))))
                        &&
                        !visited.contains(current.i + " " + nextE + " " + current.state)) {
                    queue.add(new Cell(current.i, nextE, current.state));
                } else if (current.j > 0 &&
                        grid[current.i].charAt(nextE) >= 'A' &&
                        grid[current.i].charAt(nextE) <= 'F'
                        && !visited.contains(current.i + " " + nextE + " " + current.state)) {
                    if (current.state.contains(String.valueOf(grid[current.i].charAt(nextE)).toLowerCase())) {
                        queue.add(new Cell(current.i, nextE, current.state));
                    }
                } else if (current.j > 0 &&
                        grid[current.i].charAt(nextE) >= 'a' &&
                        grid[current.i].charAt(nextE) <= 'f' &&
                        !visited.contains(current.i + " " + nextE + " " + current.state)) {
                    String newState = current.state;
                    if (!current.state.contains(String.valueOf(grid[current.i].charAt(nextE)))) {
                        newState += grid[current.i].charAt(nextE);
                        if (newState.length() == keysCount) {
                            return level;
                        }
                    }
                    queue.add(new Cell(current.i, nextE, newState));
                }

                int nextW = current.j + 1;
                if (current.j < grid[current.i].length() - 1 &&
                        (grid[current.i].charAt(nextW) == '.' || grid[current.i].charAt(nextW) == '@' ||
                                (grid[current.i].charAt(nextW) >= 'a' && grid[current.i].charAt(nextW) <= 'f'
                                        && state.contains(String.valueOf(grid[current.i].charAt(nextW)))))
                        &&
                        !visited.contains(current.i + " " + nextW + " " + current.state)) {
                    queue.add(new Cell(current.i, nextW, current.state));
                } else if (current.j < grid[current.i].length() - 1 &&
                        grid[current.i].charAt(nextW) >= 'A' &&
                        grid[current.i].charAt(nextW) <= 'F'
                        && !visited.contains(current.i + " " + nextW + " " + current.state)) {
                    if (current.state.contains(String.valueOf(grid[current.i].charAt(nextW)).toLowerCase())) {
                        queue.add(new Cell(current.i, nextW, current.state));
                    }
                } else if (current.j < grid[current.i].length() - 1 &&
                        grid[current.i].charAt(nextW) >= 'a' &&
                        grid[current.i].charAt(nextW) <= 'f' &&
                        !visited.contains(current.i + " " + nextW + " " + current.state)) {
                    String newState = current.state;
                    if (!current.state.contains(String.valueOf(grid[current.i].charAt(nextW)))) {
                        newState += grid[current.i].charAt(nextW);
                        if (newState.length() == keysCount) {
                            return level;
                        }
                    }
                    queue.add(new Cell(current.i, nextW, newState));
                }

            }

        }

        return -1;

    }
}

class Cell {
    int i;
    int j;
    String state = "";

    public Cell(int i, int j, String state) {
        this.i = i;
        this.j = j;
        this.state = state;
    }
}