import java.awt.*;

public class Controlled_Racket_2 implements Racket {
    double y, yVel;
    boolean upAcceleration, downAcceleration;
    final double GRAVITY = 0.94;
    int player, x;

    public Controlled_Racket_2(int player)
    {
        upAcceleration = false;
        downAcceleration = false;
        y = 210;
        yVel = 8;

        if (player == 2 )
        {
            x=660;
        }
        else
        {
            x = 20;
        }

    }
    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x, (int) y, 20, 80 );
    }

    public void move()
    {
        if (upAcceleration)
        {
            yVel -= 2;
        }
        else if (downAcceleration)
        {
            yVel += 2;

        }
        else if (!upAcceleration && !downAcceleration)
        {
            yVel *=GRAVITY;
        }
        if (yVel >= 5)
            yVel = 5;

        else if (yVel <= -5)
            yVel = -5;

        y += yVel;

        if (y<0)
        {
            y= 0;
        }

        if (y>420)
        {
            y=420;
        }
    }
    public void setUpAcceleration(boolean input)
    {
        upAcceleration = input;
    }

    public void setDownAcceleration(boolean input)
    {
        downAcceleration = input;
    }

    public int getY() {
        return (int)y ;
    }
}
