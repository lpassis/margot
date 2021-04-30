/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class ImagemFundo extends JPanel{
 
   private String pathImage = "/home/cma/NetBeansProjects/MyChatBot/src/mychatbot/mar.jpg"; // vari�vel que vai receber o caminho da imagem
 
   
   public ImagemFundo() {
   }
  
   public ImagemFundo(String pathImage) {
       this.pathImage = pathImage;
   }
 
   
   @Override
   
   public void paintComponent(Graphics g) 
   {
   
       Graphics2D gr = ( Graphics2D )g.create();
 
       try {
 
           
          BufferedImage buffer = ImageIO.read( new File(pathImage) );
          gr.drawImage(buffer, null, 0, 0 ); // desenha a imagem
 
       } catch (IOException ex) {
          Logger.getLogger(ImagemFundo.class.getName()).log(Level.SEVERE, null, ex);
       }
 
   }
}
