package game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import java.util.*;

public class TankGame extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TankGame tg = new TankGame();
	}
	JMenuBar menubar;
	JMenuItem item1, item2, item3, item4; //�����˵���
	JMenu menu1;
	StartPanel sp;
	MyPanel mp;
	public TankGame() {  //�������
		menubar = new JMenuBar();
		setJMenuBar(menubar); //��Ӳ˵���
		menu1 = new JMenu("TankGame");
		menubar.add(menu1);  //��Ӳ˵�
		//JMenuItem item1, item2, item3, item4; //�����˵���
		item1 = new JMenuItem("Start");
		item2 = new JMenuItem("Pause");
		item3 = new JMenuItem("Save");
		item4 = new JMenuItem("End");
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		item1.addActionListener(this);
		
		sp = new StartPanel();
		//sp.setBackground(Color.black);
		add(sp, BorderLayout.CENTER);
		mp = new MyPanel();
		//add(mp, BorderLayout.CENTER);
		//panel1.setBackground(Color.black);
		setTitle("̹TankGame");
		setBounds(60, 100, 500, 600);
    	setVisible(true);
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem item = (JMenuItem)e.getSource();
    	if(item == item1) {
    	    remove(sp);
    	    add(mp, BorderLayout.CENTER);
    	    setVisible(true);
    	}
	}
}

//��ʼ����StartPanle���
class StartPanel extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g_2d = (Graphics2D)g;
		g.setFont(new Font("����", Font.BOLD, 20));
		g_2d.drawString("Welcome to Tank Game", 150, 250);
	}
}


//��Ϸ�����MyPanle���
class MyPanel extends JPanel {
	Hero hero = null; //�ҷ�̹��
	Vector<Enemy> ets = new Vector<Enemy>(); //�з�̹��
	int etsize = 3; //����̹�˵�����
	
	public void paint(Graphics g) {
		super.paint(g);
		drawTank(150, 200, 1, 1, g);
		drawTank(50, 10, 2, 2, g);
		drawTank(150, 10, 3, 2, g);
		drawTank(250, 10, 4, 2, g);
	}
	
	public void drawTank(int tx, int ty, int direction, int type, Graphics g) {
		Graphics2D g_2d = (Graphics2D)g;
		if(type == 1) 
			g_2d.setColor(Color.red);
		else g_2d.setColor(Color.gray);
		Rectangle2D rectangle1 = null, rectangle2 = null, rectangle3 = null;
		Ellipse2D circle = null;
		Line2D line = null;
		double rec1_width = 5, rec1_height = 30;
		double rec2_width = 10, rec2_height = 20;
		double Ellipse1_width = 10;
		if(direction == 1) {
		rectangle1 = new Rectangle2D.Double(tx, ty, rec1_width, rec1_height);
		rectangle2 = new Rectangle2D.Double(tx+15, ty, rec1_width, rec1_height);
		rectangle3 = new Rectangle2D.Double(tx+5, ty+5,  rec2_width, rec2_height);
		circle = new Ellipse2D.Double(tx+5, ty+10, Ellipse1_width, Ellipse1_width);
		line = new Line2D.Double(tx+10, ty-5, tx+10, ty+15);
		}
		else if(direction == 2) {
			rectangle1 = new Rectangle2D.Double(tx, ty, rec1_width, rec1_height);
			rectangle2 = new Rectangle2D.Double(tx+15, ty, rec1_width, rec1_height);
			rectangle3 = new Rectangle2D.Double(tx+5, ty+5,  rec2_width, rec2_height);
			circle = new Ellipse2D.Double(tx+5, ty+10, Ellipse1_width, Ellipse1_width);
			line = new Line2D.Double(tx+10, ty+15, tx+10, ty+35);
		}
		else if(direction == 3) {
			rectangle1 = new Rectangle2D.Double(tx, ty, rec1_height, rec1_width);
			rectangle2 = new Rectangle2D.Double(tx, ty+15, rec1_height, rec1_width);
			rectangle3 = new Rectangle2D.Double(tx+5, ty+5,  rec2_height, rec2_width);
			circle = new Ellipse2D.Double(tx+10, ty+5, Ellipse1_width, Ellipse1_width);
			line = new Line2D.Double(tx-5, ty+10, tx+15, ty+10);
		}
		else if(direction == 4) {
			rectangle1 = new Rectangle2D.Double(tx, ty, rec1_height, rec1_width);
			rectangle2 = new Rectangle2D.Double(tx, ty+15, rec1_height, rec1_width);
			rectangle3 = new Rectangle2D.Double(tx+5, ty+5,  rec2_height, rec2_width);
			circle = new Ellipse2D.Double(tx+10, ty+5, Ellipse1_width, Ellipse1_width);
			line = new Line2D.Double(tx+15, ty+10, tx+35, ty+10);
		}
		g_2d.draw(circle);
		g_2d.draw(line);
		g_2d.fill(rectangle1);
		g_2d.fill(rectangle2);
		g_2d.draw(rectangle3);
	}
	
	public MyPanel() {
		ets.add(new Enemy(150, 200));
		ets.add(new Enemy(50, 10));
		ets.add(new Enemy(150, 10));
		ets.add(new Enemy(250, 10));
	}
	
}