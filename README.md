# PianoTilesBot

This bot utilizes the `java.awt` package by creating a BufferedImage, reading the image for tiles, then pressing the coresponding key that needs to be pressed.

## How it works
First specifiy the bounds of the game, then put these bounds into a Rectangle object. The variation I use takes in four parameters
(int x, int y, int width, int height), which uses pixels as units. The x and y represent the top left of the rectangle, the width goes from left to right, and the height goes from top to bottom. My game bounds where (750, 230, 400, 460) going from the website [Don't Tap The White Tile](http://tanksw.com/piano-tiles/).

```java
Rectangle rec = new Rectangle(750, 230, 400, 460);
```

Next we need to create a `BufferedImage` so we can read what is happening on the screen. Depending on which website you use, the colors for detecting tiles can change, but these are taken from the website above. 
```java
BufferedImage img = robot.createScreenCapture(rec);
  Color black =  new Color(17,17,17);
  Color red = new Color(251,62,56);
  Color clicked = new Color(77,77,77);
  ```

Next, we need to read the image and get the pixel color of each tile area, and compair it to the color we need to click. By importing the `java.awt.event.*` from our original `java.awt` we can use keyPress to press each of our four KeyEvents A,S,D, and F.
```java
Color first = new Color(img.getRGB(70,377));
Color second = new Color(img.getRGB(165,377));
Color third = new Color(img.getRGB(250,377));
Color fourth = new Color(img.getRGB(350,377));

if(first.equals(black)){
  robot.keyPress(KeyEvent.VK_A);
  while(!first.equals(clicked)){
    img = robot.createScreenCapture(rec);
    first = new Color(img.getRGB(70,377));
  }
}
```
