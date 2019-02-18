import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;

public class bot9thTry{

    public static void main(){
        try{
            Rectangle rec = new Rectangle(750, 230, 400, 460);
            Robot robot = new Robot();
            Thread t = new Thread();

            Color black =  new Color(17,17,17);
            Color red = new Color(251,62,56);
            Color clicked = new Color(77,77,77);
            int count = 1;
            //820,607
            //915,607
            //1000,607
            //1100,607

            t.sleep(3000);
            while(true){
                //restart:
                BufferedImage img = robot.createScreenCapture(rec);
                Color first = new Color(img.getRGB(70,377));
                Color second = new Color(img.getRGB(165,377));
                Color third = new Color(img.getRGB(250,377));
                Color fourth = new Color(img.getRGB(350,377));
                long nano_startTime = System.nanoTime();

                if(first.equals(black)){
                    robot.keyPress(KeyEvent.VK_A);
                    while(!first.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        first = new Color(img.getRGB(70,377));
                    }
                }else if(second.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_S);
                    while(!second.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        second = new Color(img.getRGB(165,377));
                    }
                }else if(third.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_D);
                    while(!third.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        third = new Color(img.getRGB(250,377));
                    }
                }else if(fourth.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_F);
                    while(!fourth.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        fourth = new Color(img.getRGB(350,377));
                    }
                }
                long nano_endTime = System.nanoTime(); 
                System.out.println("Time taken in seconds: "
                    + (nano_endTime - nano_startTime)/1000000000.0 + " on image number: " + count);
            } 
            } catch(Exception e){
                throw new IllegalArgumentException("oof");
            }
    } 

}
