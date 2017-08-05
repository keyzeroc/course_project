package project.sorter;

import project.entity.Music;

import java.util.Comparator;

// JUST FIXED NAME DESCENDING, WHICH OCCURS IN YearComparator when it's called in reverseOrder()

public class YearComparatorDescending implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        if(o1.getYear()-o2.getYear()==0){
            return o2.getComposer().compareToIgnoreCase(o1.getComposer());
        }
        return o1.getYear()-o2.getYear();
    }
}
