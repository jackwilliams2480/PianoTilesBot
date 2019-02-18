# PianoTilesBot

This bot utilizes the java.awt package by creating a BufferedImage, reading the image for tiles, then pressing the coresponding key that needs to be pressed.

## How it works
First specifiy the bounds of the game, then put these bounds into a Rectangle object. The variation I use takes in four parameters, 
(int x, int y, int width, int height), which use pixels as units. The x and y represent the top left of the rectangle, the width goes from left to right, and the height goes from top to bottom. My game bounds where (750, 230, 400, 460) going from the website [Don't Tape The White Tile](http://tanksw.com/piano-tiles/).

```java
Rectangle rec = new Rectangle(750, 230, 400, 460);
```

Next we need to create a `BufferedImage` so we can read what is happening on the screen. Depending on which website you use, the colors for detecting tiles can change, but these are taken from the website above. 
```java
BufferedImage img = robot.createScreenCapture(rec);
  Color first = new Color(img.getRGB(70,377));
  Color second = new Color(img.getRGB(165,377));
  Color third = new Color(img.getRGB(250,377));
  Color fourth = new Color(img.getRGB(350,377));
  ```
