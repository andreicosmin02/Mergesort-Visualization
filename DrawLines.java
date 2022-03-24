import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawLines extends JPanel
{
    private final int[] array;
    private final int height;
    private final int width;

    DrawLines()
    {
        width = 800;
        height = 500;
        array = new int[width];
        Random rand = new Random();
        for(int i = 0; i < width; i++)
        {
            array[i] = rand.nextInt(50, height);
        }
    }

    public void paint(Graphics g)
    {
        int x1, x2, y1, y2;
        for(int i = 25; i < width+25; i++)
        {
            setForeground(Color.white);
            x1 = x2 = i;
            y1 = height - array[i - 25] + 50;
            y2 = height + 50;

            g.drawLine(x1, y1, x2, y2);
        }
    }

    public int[] getArray()
    {
        return array;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public int getWidth()
    {
        return width;
    }

}
