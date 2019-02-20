# PianoTilesBot
This bot utilizes the `java.awt` package by creating a BufferedImage, reading the image for tiles every x seconds, then pressing the coresponding tile that shows up on the image. Although orginaly designed for one particular website, you can apply this bot to any type of PianoTiles game. Refer to `PianoTilesBotWithClicking`.

## Try Catch
Before anything we need to make sure we avoid the certain exceptions that may occur when using `java.awt`, so make sure to put everything in a try catch statement.
```java
try{
  //code
}catch(Exception e){
  throw new IllegalArgumentException("Something went wrong!");
}
```
## How it works
First, specifiy the bounds of the game and then put these bounds into a Rectangle object. The variation I use takes in four parameters
(int x, int y, int width, int height), which uses pixels as units. The x and y represent the top left of the rectangle, the width goes from left to right, and the height goes from top to bottom. My game bounds where (750, 230, 400, 460) going from the website [Don't Tap The White Tile](http://tanksw.com/piano-tiles/).

```java
Rectangle rec = new Rectangle(int x, int y,int width , int height);
```

Next we need to create a BufferedImage so we can read what is happening on the screen. Depending on which website you use, the colors for detecting tiles can change, but these are taken from the website above. 
```java
BufferedImage img = robot.createScreenCapture(rec);
  Color black =  new Color(17,17,17);
  Color red = new Color(251,62,56);
  Color clicked = new Color(77,77,77);
  ```

Next, we need to read the image and get the pixel color of each tile area, and compair it to the color we need to click. By importing the `java.awt.event.*` from our original `java.awt` we can use keyPress to press each of our four KeyEvents A,S,D, and F. Note that because we are reading a BufferedImage and not direct pixels from the screen, we need to pass the value from .getRGB into a Color object so we can easily compair the values to the specified ones. 
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

## Things to avoid
One thing that I ran into when first starting this bot was that I used the `robot.getPixelColor(x, y)`. Getting values back from a video card is often slow, so when you run the method 300+ times within each second the bot barley makes it past 100 tiles before getting to slow. This is caused by fast write speeds, but slow read speeds. 

Since, to a certain extend, we cannot avoid the speed limitations of getting pixels from the screen, its a lot more efficient to get the pixels in bulk and read them with img.getRGB(); rather than call getPixelColor 300+ times.

## Things to do
- the program does not run for long, errors rise within the first 100 tiles
- maybe JSON file would be better/easier to read?
- version that supports Clicking instead of keyevents
