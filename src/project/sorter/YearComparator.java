package project.sorter;


import project.entity.Music;

import java.util.Comparator;

public class YearComparator implements Comparator<Music>{
    @Override
    public int compare(Music o1, Music o2) {
        if(o1.getYear()-o2.getYear()==0){
            return o1.getComposer().compareToIgnoreCase(o2.getComposer());
        }
        return o1.getYear()-o2.getYear();
    }
}
