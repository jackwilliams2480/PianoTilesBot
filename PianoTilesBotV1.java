import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class autoClicker
{    
    public static Color black =  new Color(17,17,17);
    public static Color red = new Color(251,62,56);
    //public static Color grey = new ;

    public static void main() throws IOException,AWTException,InterruptedException 
    {
        Robot robot = new Robot();

        int input = JOptionPane.showOptionDialog(null, "Piano Tiles Yuh", 
        "AutoClicker 1.0.0", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if(input == JOptionPane.OK_OPTION)
        {
            //gets cordinates of mouse and sets them to x and y variables
            Thread.sleep(3000);

            //x = 800, y = 600 for A
            //x = 900, y = 600 for S
            //x = 1000, y = 600 for D
            //x = 1130, y = 600 for F  

            while(!robot.getPixelColor(990,630).equals(red))
            {
                if(robot.getPixelColor(800,600).equals(black))
                {
                    robot.keyPress(KeyEvent.VK_A);
                    while(robot.getPixelColor(800,600).equals(black)){
                        //wait
                    }
                }else if(robot.getPixelColor(900,600).equals(black))
                {
                    robot.keyPress(KeyEvent.VK_S);
                    while(robot.getPixelColor(900,600).equals(black)){
                        //wait
                    }
                }else if(robot.getPixelColor(1000,600).equals(black))
                {
                    robot.keyPress(KeyEvent.VK_D);
                    while(robot.getPixelColor(1000,600).equals(black)){
                        //wait
                    }
                }else if(robot.getPixelColor(1130,600).equals(black))
                {
                    robot.keyPress(KeyEvent.VK_F);
                    while(robot.getPixelColor(1130,600).equals(black)){
                        //wait
                    }
                }
            }

        }

    }

}

