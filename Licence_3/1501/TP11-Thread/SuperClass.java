
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Math;

public class SuperClass{

    public static class GameThread extends Thread{

        int dir;
        Pos test;

        public GameThread(int d, Pos t){
            dir = d;
            test = t;
        }
        
        public synchronized void movement(){
            int pos = test.getPos();
            String affiche = new String();
            affiche += "|";
            for(int i=0;i<pos;i++){
                affiche += " ";
            }
            switch (dir) {
                case -1:
                    affiche += "\\";
                    test.setPos(pos+1);
                    break;
                case 0:
                    affiche += "|";
                    break;
                case 1:
                    affiche += "/";
                    test.setPos(pos-1);
                    break;
                default:
                    break;
            }
            for(int j=pos+1;j<80;j++){
                affiche += " ";
            }
            affiche += "|";
            System.out.println(affiche);
        }

        @Override
        public void run() {
            for(int k=0; k<10; k++){
                movement();
                try {
                    int r =(int) (Math.random() * 1000);
                    sleep(r);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static class Pos{
        public int pos;

        public Pos(int p){
            pos = p;
        }
        public synchronized int getPos(){
            return pos;
        }
        
        public synchronized void setPos(int p){
            pos = p;
        }
    }

    public static void main(String[] args){
        Pos position = new Pos(40);
        GameThread gTh1 = new GameThread(-1,position);
        gTh1.start();
        GameThread gTh2 = new GameThread(0,position);
        gTh2.start();
        GameThread gTh3 = new GameThread(1,position);
        gTh3.start();
    }
}