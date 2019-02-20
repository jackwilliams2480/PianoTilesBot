/*
 *DISCLAIMER : code snippets from stackoverflow and other sites are used in this program.
 *Make sure you have space for a small text file, this program requires variables that take a while to find,
 *
 */
import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class PianoTilesBotFinal{

    //global variables
    public static Point topLeft = new Point(0,0);
    public static Point bottomRight = new Point(0,0);
    public static Point tileOne = new Point(0,0);
    public static Point tileTwo = new Point(0,0);
    public static Point tileThree = new Point(0,0);
    public static Point tileFour = new Point(0,0);
    public static Thread t = new Thread();
    public static String fileName = "variables.txt";
    public static void main(){
        try{
            Robot robot = new Robot();
            Scanner input = new Scanner(fileName);

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
            input.close();

            Rectangle rec = new Rectangle(topLeft.x, topLeft.y, (bottomRight.x - topLeft.x), (bottomRight.y - topLeft.y));
            //Colors vary depending on your version of pianoTiles.
            //I recommend ColorZilla (https://chrome.google.com/webstore/detail/colorzilla/bhlhnicpbhignbdhedgjhgdocnmhomnp), 
            //a chrome extension that should let you grab the exact color of the tile, background, and any other color you need
            Color black =  new Color(17,17,17);
            Color red = new Color(251,62,56);
            Color clicked = new Color(77,77,77);
            int count = 1;

            t.sleep(3000);
            while(true){
                //restart:
                BufferedImage img = robot.createScreenCapture(rec);
                Color first = new Color(img.getRGB(tileOne.x - topLeft.x,bottomRight.y - tileOne.y));
                Color second = new Color(img.getRGB(tileTwo.x - topLeft.x,bottomRight.y - tileTwo.y));
                Color third = new Color(img.getRGB(tileThree.x - topLeft.x,bottomRight.y - tileThree.y));
                Color fourth = new Color(img.getRGB(tileFour.x - topLeft.x,bottomRight.y - tileFour.y));
                long nano_startTime = System.nanoTime();

                if(first.equals(black)){
                    robot.keyPress(KeyEvent.VK_A);
                    while(!first.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        first = new Color(img.getRGB(tileOne.x - topLeft.x,bottomRight.y - tileOne.y));
                    }
                }else if(second.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_S);
                    while(!second.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        second = new Color(img.getRGB(tileTwo.x - topLeft.x,bottomRight.y - tileTwo.y));
                    }
                }else if(third.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_D);
                    while(!third.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        third = new Color(img.getRGB(tileThree.x - topLeft.x,bottomRight.y - tileThree.y));
                    }
                }else if(fourth.equals(black))
                {
                    robot.keyPress(KeyEvent.VK_F);
                    while(!fourth.equals(clicked)){
                        img = robot.createScreenCapture(rec);
                        fourth = new Color(img.getRGB(tileFour.x - topLeft.x,bottomRight.y - tileFour.y));
                    }
                }
                long nano_endTime = System.nanoTime(); 
                System.out.println("Time taken in seconds: "
                    + (nano_endTime - nano_startTime)/1000000000.0 + " on image number: " + count);
            } 
        } catch(Exception e){
            throw new IllegalArgumentException("an error occured");
        }
    } 

    public static void createFileVariables() throws FileNotFoundException{
        try{
            File file = new File(fileName);

            //Create the file
            if (file.createNewFile())
            {
                //System.out.println("File is created!");
            } else {
                //System.out.println("File already exists.");
            }

            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Scanner input = new Scanner(new File(fileName));

            int firstClick = JOptionPane.showConfirmDialog(null,"Hover your mouse over the top left of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (firstClick == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                topLeft = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(topLeft.x);
                printWriter.println(topLeft.y);
            }

            int secondClick = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (secondClick == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                bottomRight = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(bottomRight.x);
                printWriter.println(bottomRight.y);
            }

            int firstTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (firstTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileOne = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(tileOne.x);
                printWriter.println(tileOne.y);
            }

            int secondTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (secondTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileTwo = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(tileTwo.x);
                printWriter.println(tileTwo.y);
            }

            int thirdTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (thirdTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileThree = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(tileThree.x);
                printWriter.println(tileThree.y);
            }

            int fourthTile = JOptionPane.showConfirmDialog(null,"Hover your mouse over the bottom right of your desired boundary for your rectangle", 
                    "You will have 5 seconds to do so",JOptionPane.YES_NO_OPTION); 
            if (fourthTile == JOptionPane.YES_OPTION) {
                t.sleep(5000);
                tileFour = MouseInfo.getPointerInfo().getLocation();
                printWriter.println(tileFour.x);
                printWriter.println(tileFour.y);
            }
            printWriter.close();
        }catch(Exception e){
            throw new IllegalArgumentException("an error occured");
        }
    }

    public static void test(){
        File file = new File(fileName);
        Scanner input = new Scanner(fileName); 

        //Read all variables from text folder (This allows you to change / run setVar program again)
        topLeft.x = Integer.parseInt(input.nextLine());
        System.out.println(topLeft);
    }
}
