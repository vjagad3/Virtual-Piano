
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Image;
//import javax.swing.*;
public class Music extends Applet implements KeyListener
{
    	String tune[]=new String[20]; 
    	AudioClip clip[]=new AudioClip[25]; 
    	int i;String str1;
    	Image MyImage;
    	char msg;
    	Label label;
  	TextField txtField;
    	Button b;
  	

    	public void init()

    	{
            tune[0]="a.mid";
            tune[1]="s.mid";
            tune[2]="d.mid";
            tune[3]="f.mid";
            tune[4]="j.mid";
            tune[5]="k.mid";
            tune[6]="l.mid";
            tune[7]="h.mid";
 
       	MyImage=getImage(getDocumentBase(),"piano.gif");
       	for(i=0;i<8;i++)
	 	clip[i]=getAudioClip(getCodeBase(),tune[i]);
       	addKeyListener(this);
            label = new Label();
   	      txtField = new TextField(20);
    		txtField.addKeyListener(this);
    		add(label, BorderLayout.SOUTH);
    		add(txtField, BorderLayout.NORTH);
    		b=new Button("record");
    		add(b);
     		add(b, BorderLayout.NORTH);

     }
     public void keyPressed(KeyEvent ke)
      {
          for(i=0;i<=8;i++)
		clip[i].stop();
           
	    if(str1.equals("record"))
          {
    		 char c = ke.getKeyChar();
             String str = Character.toString(c);
             label.setText(str);
          }
        
    }
    public void keyReleased(KeyEvent ke)
    {

        showStatus("keyup");
    }


    public void keyTyped(KeyEvent ke)
    {
        showStatus("key typed");
 
        msg =ke.getKeyChar();
        for(i=0;i<8;i++)
        clip[i].stop();  

        if(ke.getKeyChar()=='a')
            clip[0].play();
        else if(ke.getKeyChar()=='s')
             clip[1].play();

        else if(ke.getKeyChar()=='d')
             clip[2].play();
        else if(ke.getKeyChar()=='f')
             clip[3].play();

        else if(ke.getKeyChar()=='j')
             clip[4].play();
        else if(ke.getKeyChar()=='k')
             clip[5].play();

        else if(ke.getKeyChar()=='l')
             clip[6].play();
        else if(ke.getKeyChar()==';')
             clip[7].play();

        else
        {

        }
  

   	  repaint();
     }

    
   public void paint (Graphics g)
   {  
       
        g.drawImage(MyImage, 300, 200, this);
   }

}

    