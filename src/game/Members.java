package game;
import javax.swing.*;
import java.awt.*;

public class Members {

}

class Tank {
	int x = 0;  //坦克坐标
	int y = 0;
	int direct;  //坦克方向
	int speed = 1;  //坦克速度
	Color color;    //坦克颜色
	
	/*public Tank(int x, int y, int direct, Color color) {
	 * 子类如何初始化带参数的父类？
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.color = color;
	}*/
}


class Hero extends Tank {
	public Hero(int x, int y) {
		this.x = x;
		this.y = y;
		direct = 1; //上下左右 1, 2, 3, 4
		color = Color.gray;
	}
}

class Enemy extends Tank {
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		direct = 2;
		color = Color.red;
	}
}