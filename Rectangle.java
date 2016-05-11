package curriculum;

import java.awt.Color;
import processing.core.PApplet;

public class Rectangle {
	
	PApplet p;
	private float xpos;
	private float ypos;
	private float width;
	private float height;
	private Color c;
	
	public Rectangle(PApplet tempP, float tempx, float tempy, float tempwidth, float tempheight) {
		p = tempP;
		xpos = tempx;
		ypos = tempy;
		width = tempwidth;
		height = tempheight;
		c = new Color(255, 255, 255);
		//c = Color.CYAN;
	}
	
	public void paint() {
		//p.noStroke();
		p.stroke(0);
		p.strokeWeight(5);
		p.fill(c.getRed(), c.getGreen(), c.getBlue());
		p.rect(xpos, ypos, width, height);
	}
	
	public void setX(float newX){
	    xpos = newX;
	}
	
	public void setY(float newY){
	    ypos = newY;
	}
	
	public void setWidth(float newW){
		if (newW > 0) {
			width = newW;
		}
	}
	
	public void setHeight(float newH){
		if (newH > 0) {
		    height = newH;
		}
	}
	
	public float getX(){
		return xpos;
	}
	
	public float getY(){
		return ypos;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public Color getColor(){
		return c;
	}

}
