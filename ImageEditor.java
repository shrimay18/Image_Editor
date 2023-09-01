import java.io.File ;      // to import file
import java.io.IOException ;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.util.*;

import javax.imageio.ImageIO;
//import javafx.scene.paint.Color;
import java.awt.*;
public class ImageEditor{
    public static BufferedImage convertToGrayScale(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for(int i=0;i<height;i++){
            for(int j =0; j<width; j++){
                outputImage.setRGB(j , i , inputImage.getRGB(j,i));
            }
        }return outputImage;
    }
    public static BufferedImage changeBrightness(BufferedImage inputImage, int increase){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i =0; i<height; i++){
            for(int j =0; j<width;j++){
        Color pixel = new Color(inputImage.getRGB(j,i)) ;  
        int red = pixel.getRed();
        int blue = pixel.getBlue();
        int green =pixel.getGreen();
        red = red +(red*increase)/100;
        blue = blue +(blue*increase)/100;
        green = green +(green*increase)/100;
        if(red>255) red=255;
        if(blue>255) blue=255;
        if(green>255) green=255;
        if(red<0) red=0;
        if(blue<0) blue=0;
        if(green<0) green=0;
        Color newPixel = new Color(red , green , blue);
        outputImage.setRGB(j ,i ,newPixel.getRGB());
            }}
            return outputImage ;
    } 
    public static void printPixelValues(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        for(int i =0; i<height; i++){
            for(int j =0; j<width;j++){
              //  System.out.print(inputImage.getRGB(j,i)+" "); //.getRBG is inbuilt and gives pixel values of red green and blue 
              Color pixel = new Color(inputImage.getRGB(j,i))    ;  
              System.out.print("("+ pixel.getRed()+ " "+ pixel.getBlue()+ " "+pixel.getGreen() + ")")  ;    
            }
            System.out.println();
        }
    }
     public static BufferedImage transposeImage(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                
                 outputImage.setRGB(i ,j ,inputImage.getRGB(j,i));            
    }   
} return outputImage ;
     } 
     public static BufferedImage croppedImage(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i =0;i<height/2;i++){
            for(int j =0;j<width/2;j++){
                outputImage.setRGB(j ,i ,inputImage.getRGB(j,i));
            }
        } return outputImage ;

     }
     public static BufferedImage invertedImage(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i =0;i<height;i++){
            for(int j =0;j<width;j++){
                
                outputImage.setRGB(j ,height-i-1,inputImage.getRGB(j,i));
            }
        } return outputImage ;

     }
     public static BufferedImage horizontalinvertedImage(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i =0;i<height;i++){
            for(int j =0;j<width;j++){
                
                outputImage.setRGB(width-j-1 ,i,inputImage.getRGB(j,i));
            }
        } return outputImage ;

     }
     public static BufferedImage quaterImage(BufferedImage inputImage){
        int height = inputImage.getHeight();
        int width = inputImage.getWidth();
        BufferedImage outputImage = new BufferedImage(width/2, height/2, BufferedImage.TYPE_3BYTE_BGR);
        for(int i =0;i<height/2;i++){
            for(int j =0;j<width/2;j++){
                outputImage.setRGB(j ,i ,inputImage.getRGB(j,i));
            }
        } return outputImage ;

     }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //File is a type of class in java .
        File inputFile = new File( "image.jpg");
        try {
            BufferedImage inputImage = ImageIO.read(inputFile);   //image IO se read and store it as image  & BUFFERED image se we are using this as  image form ;
          
        int ch;
        System.out.println("Enter 1 for printing pixel values");
        System.out.println("Enter 2 for GrayScale image");
        System.out.println("Enter 3 for changing brightness");
        System.out.println("Enter 4 for tansposing image");
        System.out.println("Enter 5 for quatered image");
        System.out.println("Enter 6 for inverted image");
        System.out.println("Enter 7 for horizontal inverted image");
        System.out.println("Enter 8 for cropped image");
        

        System.out.println("Enter your choice");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                printPixelValues(inputImage); 
                break;
                case 2:
                BufferedImage grayScale = convertToGrayScale(inputImage);
           File graScaleImage = new File("graScaleImage.jpg");
           ImageIO.write(grayScale, "jpg", graScaleImage);
           System.out.print("here is your gray scale image");

           break;
               case 3:
               BufferedImage changedBrightness = changeBrightness(inputImage ,100);
           File changedBrightnessImage = new File("changedBrightnessImage.jpg");
           ImageIO.write(changedBrightness, "jpg", changedBrightnessImage);
           System.out.print("here is your changedbrightness image");

                break;
                case 4:
                BufferedImage transposedImage = transposeImage(inputImage);
          File transposeImage = new File("transposedImage.jpg");
          ImageIO.write(transposedImage,"jpg",transposeImage);
          System.out.print("here is your transpose image");

               break;
               case 5:
               BufferedImage quateredImage = quaterImage(inputImage);
          File quaterImage = new File("quateredImage.jpg");
          ImageIO.write(quateredImage, "jpg", quaterImage);
          System.out.print("here is your quatered image");

          break;
               case 6:
               BufferedImage invertImage = invertedImage(inputImage);
          File invertedImage = new File("invertImage.jpg");
          ImageIO.write(invertImage,"jpg",invertedImage);
          System.out.print("here is your inverted image");

               break;
               case 7:
               BufferedImage horizontalinvertImage = horizontalinvertedImage(inputImage);
        File horizontalinvertedImage = new File("horizontalinvertImage.jpg");
        ImageIO.write(horizontalinvertImage,"jpg",horizontalinvertedImage);
        System.out.print("here is your horizontal inverted image");

            break;
               case 8:
               BufferedImage cropImage = croppedImage(inputImage);
        File croppedImage = new File("cropImage.jpg");
        ImageIO.write(cropImage,"jpg",croppedImage);
        System.out.print("here is your cropped image");

            break;
            
            default:
            System.out.print("Enter valid choice");


            }

           
        }  catch (IOException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        }    //to read file & store it
            
       }
    }
