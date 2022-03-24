import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MainPrg
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame f = new JFrame("Sorting Visualizer");

        DrawLines line = new DrawLines();
        f.getContentPane().add(line);
        f.getContentPane().setBackground(Color.black);

        //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //f.setUndecorated(true);

        f.setResizable(false);
        f.setSize(line.getWidth() + 50, line.getHeight() + 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        TimeUnit.SECONDS.sleep(1);

        Sort sorting = new Sort();

        sorting.mergeSort(line.getArray(), 0, line.getArray().length - 1, f);

        sorting.refresh(f);
        f.setVisible(true);
    }
}
