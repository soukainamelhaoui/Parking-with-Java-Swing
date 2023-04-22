import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

public class ParkingGUI extends JPanel {
    ImageIcon bg;
    public boolean[] spot;
    public HashSet<Voiture> voitureHashSet = new HashSet<>();
    public int placesOccupees;
    public ParkingGUI(int capacity){
        spot = new boolean[capacity];
        Arrays.fill(spot, false);
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        bg = new ImageIcon("bg.png");
        bg.paintIcon(this, g, WIDTH,HEIGHT);
    }
    public int place(){
        return this.spot.length - this.placesOccupees;
    }
    synchronized public boolean accept(Voiture c){
        if (this.place() > 0) {
            return true;
        }else
            return false;
    }
    public static void main(String[] args) {
        int nbVoitures=15;
        int capacite = 5;
        JFrame frame = new JFrame();
        frame.setSize(717, 541);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ParkingGUI parkPanel = new ParkingGUI(capacite);
        frame.setContentPane(parkPanel);
        parkPanel.setLayout(null);
        frame.setVisible(true);
        Voiture[] voitures = new Voiture[nbVoitures];
        Thread[] MesVoitures = new Thread[nbVoitures];

        for (int i =0; i< nbVoitures ; i++){
                voitures[i] = new Voiture(String.format("Voit %d ", i), parkPanel);
                MesVoitures[i] = new Thread(voitures[i]);
                MesVoitures[i].start();

                try {
                    MesVoitures[i].sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                parkPanel.add(voitures[i]);

        }
    }
}