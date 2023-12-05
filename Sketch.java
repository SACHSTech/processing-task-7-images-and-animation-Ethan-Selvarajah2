import processing.core.PApplet;
import processing.core.PImage;
import java.lang.Math;

public class Sketch extends PApplet {
  PImage imgDuckWalk;
  PImage imgBackground;
  float fltDuckX = 150;
  float fltDuckY = 150;
  float fltRectX = 100;
  float fltRectY = 100;
  int xDirection = 1;
  int yDirection = 1;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // Setup images
    imgDuckWalk = loadImage("swaggy_duck_transparent_1.png");
    imgBackground = loadImage("sky-with-clouds-and-sun-shining-through-8-bit.jpg");

    // Resize images
    imgDuckWalk.resize(imgDuckWalk.width / 5, imgDuckWalk.height / 5);
    imgBackground.resize(imgBackground.width / 2, imgBackground.height / 2);
  }

  public void draw() {
    // Background drawn
    image(imgBackground, -100, -50);

    // Duck drawn
    image(imgDuckWalk, fltDuckX, fltDuckY);

    // Duck Movement
    fltDuckX += (float)(Math.pow(2 * xDirection, 2) + (3 * xDirection) + yDirection);
    fltDuckY = (float)(height - 0.02 * Math.pow(fltDuckX - width / 4, 2));


    // Shape drawn and moved
    rect(fltRectX, fltRectY, 30, 30);
    fltRectX -= 2;
    fltRectY -= 2;
    
    // Edge detection for duck
    if (fltDuckX >= width + imgDuckWalk.width / 2) {
      fltDuckX = -imgDuckWalk.width / 2;
    } else if (fltDuckX <= -imgDuckWalk.width / 2) {
      fltDuckX = width + imgDuckWalk.width / 2;
    }

    // Edge detection for rectangle
    if (fltRectX <= -30) {
      fltRectX = width;
    } else if (fltRectY <= -30) {
      fltRectY = height;
    }
  }
}