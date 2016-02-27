import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anh on 27/02/2016.
 */
public class Gamewindow extends Frame implements MouseMotionListener,MouseListener,KeyListener,Runnable {
    private Label statusBar;
    BufferedImage Plane, Plane2;
    BufferedImage background;
    int PlaneX = 150;
    int PlaneY = 200;
    int direction = 0;

    int PlaneX2=100;
    int PlaneY2=200;
    int direction2=0;

    public Gamewindow() {
        this.setTitle("Game 1945");
        this.setSize(400, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       super.windowClosing(e);
                                       System.exit(0);
                                   }
                               }
        );





        try {
            background = ImageIO.read(new File("Resouces/Background.png"));
            Plane = ImageIO.read(new File("Resouces/PLANE1.png"));
            Plane2 = ImageIO.read(new File("Resouces/PLANE2.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        repaint();

    }

    private void addWindowListener(MouseAdapter mouseAdapter) {
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        g.drawLine(0, 0, 100, 100);
        g.drawImage(Plane, PlaneX, PlaneY, null);
        g.drawImage(Plane2,PlaneX2,PlaneY2,null);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("May vua bam phim " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            direction = 1;
            //repaint();
        }
        if (e.getKeyChar() == 'a') {
            direction = 4;
            //repaint();
        }
        if (e.getKeyChar() == 'd') {
            direction = 3;
            //repaint();
        }
        if (e.getKeyChar() == 'x') {
            direction = 2;
            //repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void run() {

        while (true) {
            if (direction == 0) {

            } else if (direction == 1) {
                PlaneY -= 2;
            } else if (direction == 2) {
                PlaneY += 2;
            } else if (direction == 3) {
                PlaneX += 2;
            } else if (direction == 4) {
                PlaneX -= 2;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public  void mouseClicked(MouseEvent event)
    {
        PlaneX2=event.getX();
        PlaneY2=event.getY();
    }

    @Override
    public void mousePressed(MouseEvent event)
    {

    }

    @Override
    public void mouseReleased(MouseEvent event)
    {

    }

    @Override
    public void mouseEntered(MouseEvent event)
    {

    }

    @Override
    public void mouseExited(MouseEvent event)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent event)
    {
        PlaneX2=event.getX();
        PlaneY2=event.getY();
    }
}


