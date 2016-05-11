package curriculum;

import processing.core.PApplet;

public class Ball  {
    
	private PApplet p;
	private float x;
	private float y;
	private float vx;
	private float vy;
	private float size;
	private float R;
	private float G;
	private float B;
	
	public Ball(PApplet tempP, float nx, float ny, float nsize, float r, float g, float b){
		p = tempP;
		x = nx;
		y = ny;
		size = nsize;
		R = r;
		G = g;
		B = b;
		
		vx = p.random(-3,3);
		vy = p.random(-3,3);
	}
	
	public void update(){
		x = x + vx;
		y = y + vy;
		
		if(x > p.width || x < 0){
			vx = -vx;
		}
		
		if(y > p.height || y < 0){
			vy = -vy;
		}
		
	}
	
	public void paint(){
		p.noStroke();
		p.fill(R, G, B);
		p.ellipse(x, y, size, size);
	}
	
	public void setX(float newX){
	    x = newX;
	}
	
	public void setY(float newY){
	    y = newY;
	}
	
	public void setSize(float newSize){
	    if (newSize > 0) {
	    	size = newSize;
	    }
	}
	
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getSize(){
		return size;
	}
	
	public float getRed() {
		return R;
	}
	
	public void setRed(float r) {
		if (r >= 0 && r <= 255) {
			R = r;
		}
	}
	
	public float getGreen() {
		return G;
	}
	
	public void setGreen(float g) {
		if (g >= 0 && g <= 255) {
			G = g;
		}
	}
	
	public float getBlue() {
		return B;
	}
	
	public void setBlue(float b) {
		if (b >= 0 && b <= 255) {
			B = b;
		}
	}
	
	public float getVX() {
		return vx;
	}
	
	public float getVY() {
		return vy;
	}
	
	public void setVelocity(float newVX, float newVY) {
		vx = newVX;
		vy = newVY;
	}
	
}
