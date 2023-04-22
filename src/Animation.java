import javax.swing.*;

public class Animation {
    synchronized public static void show(Voiture voiture , int posX , int posY)
    {
        while(posX>-50 && posY>=250)
        {
            posY-=10;
            voiture.setLocation(posX, posY);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        voiture.posX=posX;
        voiture.posY=posY;
    }
    synchronized public static void keepMoving(Voiture voiture, int posX, int posY, int value)
    {
        ImageIcon voitureIcon = new ImageIcon("2.png");
        voiture.setIcon(voitureIcon);
        voiture.setBounds(voiture.posX, voiture.posY, 160,87);
        while(posX>=value )
        {
            posX-=15;
            voiture.setLocation(posX, posY-40);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        voiture.posX=posX;
        voiture.posY=posY;
    }

    synchronized public static void parkIn(Voiture voiture , int posX , int posY)
    {
        ImageIcon voitureIcon = new ImageIcon("1.png");
        voiture.setIcon(voitureIcon);
        voiture.setBounds(voiture.posX, voiture.posY, 87,160);
        while(posY>=40)
        {
            posY-=10;
            voiture.setLocation(posX, posY);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        voiture.posX=posX;
        voiture.posY=posY;
    }

    synchronized public static void moveBackwards(Voiture voiture , int posX , int posY )
    {
        while(posY<=150)
        {
            posY+=15;
            voiture.setLocation(posX, posY+45);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        voiture.posX=posX;
        voiture.posY=posY;
    }

    synchronized public static void getOut(Voiture voiture , int posX , int posY)
    {
        ImageIcon voitureIcon = new ImageIcon("2.png");
        voiture.setIcon(voitureIcon);
        voiture.setBounds(voiture.posX, voiture.posY, 160,87);
        while(posX<=700 && posX>=-160)
        {
            posX-=10;
            voiture.setLocation(posX, posY+40);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        voiture.posX=posX;
        voiture.posY=posY;
    }
}