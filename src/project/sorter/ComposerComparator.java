package project.sorter;

import project.entity.Music;

import java.util.Comparator;

public class ComposerComparator implements Comparator<Music>{
    @Override
    public int compare(Music o1, Music o2) {
        return o1.getComposer().compareToIgnoreCase(o2.getComposer());
    }
}
