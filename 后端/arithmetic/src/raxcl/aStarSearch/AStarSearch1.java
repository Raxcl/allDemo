package raxcl.aStarSearch;

import java.util.ArrayList;
import java.util.List;

public class AStarSearch1 {
    public static final int[][] MAZE = {
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 }
    };

    static class Grid{
        public int x;
        public int y;
        public int f; // g+h
        public int g; // 起点到当前位置的格子数
        public int h; // 当前位置到终点的格子数
        public Grid parent;
        public Grid(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void  initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g+1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }
    }

    public static void main(String[] args) {
        //设置起点和终点
        Grid starGrid = new Grid(2, 1);
        Grid endGrid = new Grid(0,6); // todo x 和 y 是不是反了？
        // 历史记录--走过的路径排序
        List<Grid> HisGirdList = new ArrayList<>();
        // 搜索迷宫终点
        Grid resultGrid = aStarSearch(starGrid, endGrid, HisGirdList);
        // 回溯迷宫路径
        ArrayList<Grid> path = new ArrayList<>();
        while (resultGrid != null) {
            path.add(new Grid(resultGrid.x,resultGrid.y));
            resultGrid = resultGrid.parent;
        }
        // 输出迷宫和路径，路径用 * 表示
//        for (int i = 0; i < MAZE.length; i++) {
//            for (int j=0; j<MAZE[0].length;j++) {
//                if (containGrid(path, i, j)) {
//                    System.out.print("*, ");
//                } else {
//                    System.out.print(MAZE[i][j] + ", ");
//                }
//            }
//            System.out.println();
//        }
        // 打印历史记录
        int[][] temMaze = MAZE.clone();
        int z = 2;
        for (Grid grid : HisGirdList) {
            temMaze[grid.x][grid.y] = z++;
        }
        for (int i = 0; i < temMaze.length; i++) {
            for (int j=0; j<temMaze[0].length;j++) {
                System.out.print(MAZE[i][j] + ", ");
            }
            System.out.println();
        }

    }

    private static Grid aStarSearch(Grid start, Grid end, List<Grid> hisGirdList) {
        ArrayList<Grid> openList = new ArrayList<>();
        ArrayList<Grid> closeList = new ArrayList<>();
        // 把起点加入 openList
        openList.add(start);
        // 主循环，每一轮检查1个当前方格节点
        while (openList.size() > 0) {
            // 在 openList.size 中查找 F 值最小的节点，将其作为当前方格节点
            Grid currentGrid = findMinGrid(openList);
            hisGirdList.add(currentGrid);
            // 将当前方格节点从openList 中移除,添加进 closeList中
            openList.remove(currentGrid);
            closeList.add(currentGrid);
            // 找到所有临近节点
            List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
            for (Grid grid : neighbors) {
                if (!openList.contains(grid)) {
                    // 邻近节点不在 openList 中， 标记 “父节点”， G、H、F,并放入 openList
                    grid.initGrid(currentGrid, end);
                    openList.add(grid);
                }
            }
            // 如果终点在 openList中，直接返回终点格子
            for (Grid grid : openList) {
                if (grid.x == end.x && grid.y == end.y) {
                    return grid;
                }
            }
        }
        // openList用尽，任然找不到终点，说明终点不可到达，返回空
        return null;
    }

    private static List<Grid> findNeighbors(Grid grid, ArrayList<Grid> openList, ArrayList<Grid> closeList) {

        ArrayList<Grid> gridList = new ArrayList<>();
        if(isValidGrid(grid.x, grid.y - 1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y - 1));
        }
        if (isValidGrid(grid.x, grid.y +1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y + 1));
        }
        if (isValidGrid(grid.x-1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x-1, grid.y));
        }
        if (isValidGrid(grid.x+1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x+1, grid.y));
        }
        return gridList;

    }

    private static boolean isValidGrid(int x, int y, ArrayList<Grid> openList, ArrayList<Grid> closeList) {
        // 是否超过边界
        if(x < 0 || x >= MAZE.length || y < 0 || y >=MAZE[0].length) {
            return false;
        }
        // 是否有障碍物
        if (MAZE[x][y] == 1) {
            return false;
        }
        // 是否已经在 openList中
        if (containGrid(openList, x, y)) {
            return false;
        }

        // 是否已经在 closeList 中
        if (containGrid(closeList, x, y)) {
            return false;
        }

        return true;
    }

    private static boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid grid : grids) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    private static Grid findMinGrid(ArrayList<Grid> openList) {
        Grid tempGrid = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < tempGrid.f) {
                tempGrid = grid;
            }
        }
        return tempGrid;
    }
}
