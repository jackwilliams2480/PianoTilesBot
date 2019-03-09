/*
 *DISCLAIMER : code snippets from stackoverflow and other sites are used in this program.
 *Make sure you have space for a small text file
 *
 */
import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.image.*;
import javax.imageio.*;

public class botUsingClicks{

    //global variables
    public static Point topLeft = new Point(0,0);
    public static Point bottomRight = new Point(0,0);
    public static Point tileOne = new Point(0,0);
    public static Point tileTwo = new Point(0,0);
    public static Point tileThree = new Point(0,0);
    public static Point tileFour = new Point(0,0);
    public static Thread t = new Thread();
    public static String fileName = "clickVariables.txt";

    public static void main(){
        try{
            Robot robot = new Robot();
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            //Read all variables from text folder (This allows you to change / run setVar program again)
            topLeft.x = input.nextInt();
            System.out.println(topLeft);
            topLeft.y = input.nextInt();
            bottomRight.x = input.nextInt();
            bottomRight.y = input.nextInt();
            tileOne.x = input.nextInt();
            tileOne.y = input.nextInt();
            tileTwo.x = input.nextInt();
            tileTwo.y = input.nextInt();
            tileThree.x = input.nextInt();
            tileThree.y = input.nextInt();
            tileFour.x = input.nextInt();
            tileFour.y = input.nextInt();

            Rectangle rec = new Rectangle(topLeft.x, topLeft.y, (bottomRight.x - topLeft.x), (bottomRight.y - topLeft.y));
            //Colors vary depending on your version of pianoTiles.
            //I recommend ColorZilla (https://chrome.google.com/webstore/detail/colorzilla/bhlhnicpbhignbdhedgjhgdocnmhomnp), 
            //a chrome extension that should let you grab the exact color of the tile, background, and any other color you need
            Color black =  new Color(16,20,19);
            Color blackv2 =  new Color(0,0,0);
            Color firstTile = new Color(66,161,195);
            Color clicked = new Color(150,180,218);
            int count = 1;

            System.out.println(tileOne.x - topLeft.x);
            System.out.println(tileTwo.x - topLeft.x);
            System.out.println(tileThree.x - topLeft.x);
            System.out.println(tileFour.x - topLeft.x);
            System.out.println(tileThree.y - topLeft.y);
            System.out.println(tileThree.y - topLeft.y);

            t.sleep(3000);
            while(count<200){
                //restart:
                BufferedImage img = robot.createScreenCapture(rec);
                Color first = new Color(img.getRGB(tileOne.x - topLeft.x,tileOne.y - topLeft.y));
                System.out.println(first);
                Color second = new Color(img.getRGB(tileTwo.x - topLeft.x,tileTwo.y - topLeft.y));
                System.out.println(second);
                Color third = new Color(img.getRGB(tileThree.x - topLeft.x,tileThree.y - topLeft.y));
                System.out.println(third);
                Color fourth = new Color(img.getRGB(tileFour.x - topLeft.x,tileFour.y - topLeft.y));
                System.out.println(fourth);
                long nano_startTime = System.nanoTime();

                File outputfile = new File("image.jpg");
                ImageIO.write(img, "jpg", outputfile);

                if(first.equals(black) || first.equals(blackv2)){
                    robot.mouseMove(tileOne.x,tileOne.y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    
                }else if(second.equals(black) || second.equals(blackv2))
                {
                    robot.mouseMove(tileTwo.x,tileTwo.y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    
                }else if(third.equals(black) || third.equals(blackv2))
                {
                    robot.mouseMove(tileThree.x,tileThree.y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    
                }else if(fourth.equals(black) || fourth.equals(blackv2))
                {
                    robot.mouseMove(tileThree.x,tileThree.y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    
                }
                long nano_endTime = System.nanoTime(); 
                System.out.println("Time taken in seconds: "
                    + (nano_endTime - nano_startTime)/1000000000.0 + " on image number: " + count);
                count++;
            } 
        } catch(Exception e){
            throw new IllegalArgumentException("An error occured");
        }
    } 

    public static void createFileVariables() throws FileNotFoundException{
        //Please be carefull when naming the file, the default is 'variables.txt', which might already exist within the folder you are running the program.
        //Make sure you dont overwrite something that you dont want to lose.
        try{
            File file = new File(fileName);

            //Create the file
            if (file.createNewFile())
            {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            //Allow read/write
            Scanner input = new Scanner(file);
            PrintStream output = new PrintStream(file);

            int firstClick = JOptionPane.showConfirmDialog(null,"Hover your mouse over the top left of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (firstClick == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                topLeft = MouseInfo.getPointerInfo().getLocation();
                output.println(topLeft.x);
                output.println(topLeft.y);
            }

            int secondClick = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (secondClick == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                bottomRight = MouseInfo.getPointerInfo().getLocation();
                output.println(bottomRight.x);
                output.println(bottomRight.y);
            }

            int firstTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the first tile", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (firstTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileOne = MouseInfo.getPointerInfo().getLocation();
                output.println(tileOne.x);
                output.println(tileOne.y);
            }

            int secondTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the second tile", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (secondTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileTwo = MouseInfo.getPointerInfo().getLocation();
                output.println(tileTwo.x);
                output.println(tileTwo.y);
            }

            int thirdTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the third tile", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (thirdTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileThree = MouseInfo.getPointerInfo().getLocation();
                output.println(tileThree.x);
                output.println(tileThree.y);
            }

            int fourthTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the fourth tile", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (fourthTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileFour = MouseInfo.getPointerInfo().getLocation();
                output.println(tileFour.x);
                output.println(tileFour.y);
            }

            //You can add additional methods for more tiles, just make sure to create another Point object and JPane section

        }catch(Exception e){
            throw new IllegalArgumentException("An error occured");
        }
    }
}
