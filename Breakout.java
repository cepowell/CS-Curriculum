package curriculum;

import processing.core.PApplet;

import java.util.ArrayList;

public class Breakout extends PApplet {
	
	public Ball ball;
	public Rectangle paddle;
	public ArrayList<Rectangle> bricks = new ArrayList<Rectangle>();
	
	public void setup() {
	
		size(400,600);
		background(0);
		
		ball = new Ball(this, width/2, height/2, 20, random(255), random(255), random(255));
		addBricks();
		paddle = new Rectangle(this, 200, 550, 60, 20);
		
	}
	
	public void draw() {
		
		fill(0, 0, 0);
		rect(0, 0, width, height);
		
		drawBricks();
		
		ball.update();
		ball.paint();
		
		updatePaddle();
		updateGame();
		
	}
	
	private void updatePaddle() {
		paddle.setX(mouseX);
		paddle.paint();
	}
	
	private void addBricks() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				bricks.add(new Rectangle(this, 40*i, 100+15*j, 40, 15));
			}
		}
		
	}
	
	private void drawBricks() {
		
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).paint();
		}
		
	}
	
	private void updateGame() {
		 
		// check if ball hits paddle
		
		if (ball.getX() > paddle.getX() && ball.getX() < paddle.getX() + paddle.getWidth() && ball.getY() + ball.getSize()/2 > paddle.getY()) {
			ball.setVelocity(ball.getVX(), -ball.getVY());
			ball.setRed(random(255));
			ball.setGreen(random(255));
			ball.setBlue(random(255));
		}
		
		// check if ball hits a brick
		
		for(int i = 0; i < bricks.size(); i++) {
			Rectangle b = bricks.get(i);
			if (ball.getX() > b.getX() && ball.getX() < (b.getX() + b.getWidth()) && (ball.getY()-ball.getSize()/2) < b.getY()) {
				ball.setVelocity((float)(ball.getVX()*1.1), (float)(-ball.getVY()*1.1));
				bricks.remove(b);
			}
		}
		
		// check if you lost
		
		if(ball.getY() > height -10){
			background(0); //erase everything
			textSize(45);
			text("Game Over!", 50, height/2);
			ball.setVelocity(0, 0); //stop the ball so the game will stop
		}
		
		if (bricks.size() == 0) {
			background(0);
			textSize(45);
			text("You Won!", 50, height/2);
			ball.setVelocity(0, 0);
		}
	}

}
