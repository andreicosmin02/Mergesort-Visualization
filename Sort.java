import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Sort
{
    public void refresh(JFrame f) throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1);
        f.invalidate();
        f.validate();
        f.repaint();
    }

    public void mergeSort(int[] array, int left, int right, JFrame f) throws InterruptedException
    {
        int middle;
        if(left < right)
        {
            middle = (left + right) / 2;

            mergeSort(array, left, middle, f);
            mergeSort(array, middle + 1, right, f);

            merge(array, left, middle, right, f);

        }
    }
    public void merge(int[] array, int left, int middle, int right, JFrame f) throws InterruptedException
    {
        int low = middle - left + 1;
        int high = right - middle;

        int[] L = new int[low];
        int[] R = new int[high];

        int i, j;
        for(i = 0; i < L.length; i++)
        {
            L[i] = array[left + i];
        }
        for(j = 0; j < R.length; j++)
        {
            R[j] = array[middle + 1 + j];
        }

        int k = left;
        i = 0;
        j = 0;

        while(i < low && j < high)
        {
            if(L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
                refresh(f);
            }
            else
            {
                array[k] = R[j];
                j++;
                refresh(f);
            }
            k++;
        }
        while(i < low)
        {
            array[k] = L[i];
            i++;
            k++;
            refresh(f);
        }
        while(j < high)
        {
            array[k] = R[j];
            j++;
            k++;
            refresh(f);
        }
    }
}
