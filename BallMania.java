package curriculum;

import java.util.ArrayList;

import processing.core.PApplet;

public class BallMania extends PApplet {

    //Ball[] b;
	ArrayList<Ball> b = new ArrayList<Ball>();
    
	public void setup() {
		background(0);
		size(400,400);			
		
		/*b = new Ball[20];
		for(int i =0; i < b.length; i++){
			b[i] = new Ball(this, random(200),random(200),10, random(255), random(255), random(255) );
		}*/
		
		for(int i =0; i < 20; i++){
			b.add(new Ball(this, random(200),random(200),10, random(255), random(255), random(255)));
		}
	}

	public void draw() {
		fill(0,0,0,15);
		noStroke();
		rect(0,0,width,height);

		/*for(int i =0; i < b.length; i++){
			b[i].update();
			b[i].paint();
		}*/
		for(int i = 0; i < b.size(); i++){
			b.get(i).update();
			b.get(i).paint();

		}
		if(mousePressed == true){
			b.add(new Ball(this, 200,200,10, random(255), random(255), random(255)));
			//b.add(new Ball(this, mouseX, mouseY, 10, random(255), random(255), random(255)));
			//b.add(new Ball(this, random(200), random(200), random(40), random(255), random(255), random(255)));
		}
		
		
	}
}

