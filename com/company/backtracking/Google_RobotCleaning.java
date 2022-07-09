package com.company.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Google_RobotCleaning {
    Set<String> visited;
    void cleanRoom(Robot robot){
        visited = new HashSet<>();
        dfs(robot, 0,0);
    }

    void dfs(Robot robot, int i, int j){
        if(visited.contains(i+","+j)) return;
        // add to visited
        visited.add(i+","+j);
        robot.clean();
        for(int k=0;k<4;k++){
            if(robot.move()) { // we check if we can move
                if (k == 0) dfs(robot, i + 1, j);
                if (k == 1) dfs(robot, i - 1, j);
                if (k == 2) dfs(robot, i, j + 1);
                if (k == 3) dfs(robot, i, j - 1);
                // after moving we need to backtrack
                robot.move();
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnLeft();
        }
    }

    class Robot{
        public boolean move(){return true;}
        void turnLeft(){}
        void turnRight(){}
        void clean(){}
    }
}
