package Zad1;

import java.util.Comparator;

public class ResultComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int pointsCompare = Integer.compare(o1.getPoints(), o2.getPoints());
        int fnCompare = o1.getFirstName().compareTo(o2.getFirstName());
        int lnCompare = o1.getLastName().compareTo(o2.getLastName());
        if (pointsCompare == 0) {
            if (fnCompare == 0)
                return lnCompare;
            else return fnCompare;
        } else
            return pointsCompare;
    }
}
