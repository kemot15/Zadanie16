package Zad1;

import java.util.Comparator;

public class ResultComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int pointsCompare = Integer.compare(o1.getPoints(), o2.getPoints());
        if (pointsCompare == 0)
            return (o1.getFirstName().compareTo(o2.getFirstName()));
            else
                return pointsCompare;
    }
}
