/**
 * Created by Anh on 27/02/2016.
 */
public class main {
    public static void main (String [] args)
    {
        Gamewindow game= new Gamewindow();
        Thread thread=new Thread(game);
        thread.start();


    }
}
