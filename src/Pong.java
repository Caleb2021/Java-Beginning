import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener
{
    final int WIDTH =700, HIGHT= 500;
    Thread thread;
    Controlled_Racket p1;
    Controlled_Racket_2 p2;
    Ball b1;
    Boolean gameStarted;
    Graphics gfx;
    Image img;


public void init()
{
this.resize(WIDTH, HIGHT);
gameStarted = false;
this.addKeyListener(this);
p1 = new Controlled_Racket(1);
p2 = new Controlled_Racket_2(2);
b1 =new Ball();
thread = new Thread(this);
thread.start();
img = createImage(WIDTH,HIGHT);
gfx = img.getGraphics();

}

public void paint (Graphics g)
{
gfx.setColor(Color.black);
gfx.fillRect(0, 0, WIDTH, HIGHT);
if(b1.getX() < -10 || b1.getX() > 710)
{
    gfx.setColor(Color.PINK);
    gfx.drawString("Game Over", 330, 250);
}
else {
    p1.draw(gfx);
    b1.draw(gfx);
    p2.draw(gfx);


}
if(!gameStarted)
{
    gfx.setColor(Color.WHITE);
    gfx.drawString("Pong", 335,100);
    gfx.drawString("Press Enter to Begin...Use 'W' and 'S' to move left racket, use 'UP'  and 'DOWN' to move right racket.", 100,150);
}
g.drawImage(img, 0, 0,this);
}

public void update (Graphics g)
{
paint(g);
}

    public void run() {
        for(;;)
        {
            if(gameStarted)
            {
                p1.move();
                b1.move();
                p2.move();
                b1.checkRacketCollision(p1, p2);
            }
            repaint();
        try
        {
            Thread.sleep(15);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        }
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            p1.setUpAcceleration(true);

        }
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            p1.setDownAcceleration(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            p2.setUpAcceleration(true);

        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)

        {
            p2.setDownAcceleration(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            gameStarted = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            p1.setUpAcceleration(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            p1.setDownAcceleration(false);

        }

        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            p2.setUpAcceleration(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            p2.setDownAcceleration(false);

        }
    }
    }




