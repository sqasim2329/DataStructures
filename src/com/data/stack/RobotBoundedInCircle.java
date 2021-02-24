package com.data.stack;

public class RobotBoundedInCircle {
	
	public boolean isRobotBounded(String instructions) {
        //N.     E.    S.     W
int directions[][] ={{0,1},{1,0},{0,-1},{-1,0}};
int dir = 0;
int x = 0;
int y = 0;
for(char c:instructions.toCharArray()){
if(c == 'L'){
dir = (dir+1)%4; 
}else if(c == 'R'){
dir = (dir+3)%4; 
}else {
x += directions[dir][0];
y += directions[dir][1];
}
}

return (x == 0 && y == 0) || dir !=0;
}

}
