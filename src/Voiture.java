import javax.swing.*;

public class Voiture extends JLabel implements Runnable {
    String name;
    ParkingGUI park;
    ImageIcon voitureIcon ;
    public int posX;
    public int posY;
    public Voiture(String name, ParkingGUI park)
    {
        this.name = name;
        this.park = park;
        this.posX=600;
        this.posY=500;
        voitureIcon = new ImageIcon("1.png");
        this.setIcon(voitureIcon);
        setBounds(posX, posY, 87,160);
    }
   
     synchronized public void enter() throws InterruptedException {
         while (!this.park.accept(this)) {
             Thread.sleep((long) (100000 * Math.random()));
         }
         this.park.placesOccupees++;
         this.park.voitureHashSet.add(this);
         Animation.show(this, this.posX, this.posY);
         Animation.keepMoving(this, this.posX, this.posY, 470);
         if (!park.spot[0]) {
             Animation.parkIn(this, this.posX, this.posY);
             park.spot[0] = true;
         } else {
             Animation.keepMoving(this, this.posX, this.posY, 355);
             if (!park.spot[1]) {
                 Animation.parkIn(this, this.posX, this.posY);
                 park.spot[1] = true;
             } else {
                 Animation.keepMoving(this, this.posX, this.posY, 245);
                 if (!park.spot[2]) {
                     Animation.parkIn(this, this.posX, this.posY);
                     park.spot[2] = true;
                 } else {
                     Animation.keepMoving(this, this.posX, this.posY, 140);
                     if (!park.spot[3]) {
                         Animation.parkIn(this, this.posX, this.posY);
                         park.spot[3] = true;
                     } else {
                         Animation.keepMoving(this, this.posX, this.posY, 40);
                         if (!park.spot[4]) {
                             Animation.parkIn(this, this.posX, this.posY);
                             park.spot[4] = true;
                         }else {
                             Animation.keepMoving(this, this.posX, this.posY, -140);

                         }
                     }
                 }
             }
         }
         try {
             Thread.sleep(2000);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    synchronized public void getOut()
    {
        this.park.placesOccupees--;
        this.park.voitureHashSet.remove(this);
        if(this.posX<=470 && this.posX>=355)
        {
            Animation.moveBackwards(this, posX, posY);
            Animation.getOut(this, posX, posY);
            park.spot[0]=false;
        }
        if(this.posX<=355 && this.posX>=245)
        {
            Animation.moveBackwards(this, posX, posY);
            Animation.getOut(this, posX, posY);
            park.spot[1]=false;
        }
        if(this.posX<=245 && this.posX>=140)
        {
            Animation.moveBackwards(this, posX, posY);
            Animation.getOut(this, posX, posY);
            park.spot[2]=false;
        }
        if(this.posX<=140 && this.posX>=40)
        {
            Animation.moveBackwards(this, posX, posY);
            Animation.getOut(this, posX, posY);
            park.spot[3]=false;
        }
        if(this.posX<=40)
        {
            Animation.moveBackwards(this, posX, posY);
            Animation.getOut(this, posX, posY);
            park.spot[4]=false;
        }
    }
    synchronized public void run()
    {
        try
        {
            while (true){
                Thread.sleep((long) (10000 * Math.random()));
                this.enter();

                Thread.sleep((long) (10000 * Math.random()));
                this.getOut();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
