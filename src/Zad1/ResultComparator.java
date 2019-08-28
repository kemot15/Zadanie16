package Zad1;

import java.util.Comparator;

public class ResultComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1 == null && o2 == null)
            return 0;
        if (o1 ==null && o2 !=null)
            return -1;
        if (o1 !=null && o2 ==null)
            return 1;
        if (o1.getPoints() > o2.getPoints())
            return 1;
        if (o1.getPoints() < o2.getPoints())
            return -1;
        return 0;
    }
}
