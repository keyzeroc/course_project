package project.runner;

import project.entity.Genre;
import project.entity.Music;
import project.entity.PlayList;
import project.entity.User;
import project.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public class SorterRunner {

    public static void main(String[] args) {

        User max32 = new User("Max");

        PlayList great_songs = new PlayList("Great Songs ^^",max32);

        great_songs.addTrack(new Music("bla_blakin","bbb song", Genre.comedy,2016),max32);
        great_songs.addTrack(new Music("Arnold","aaa song", Genre.comedy,2016),max32);
        great_songs.addTrack(new Music("bla_blakin","blabla song", Genre.comedy,2014),max32);
        great_songs.addTrack(new Music("Alala","alala_song", Genre.choral,2009),max32);
        great_songs.addTrack(new Music("Max","Mad max ost", Genre.soundtrack,2015),max32);
        great_songs.addTrack(new Music("olli","it's not you, it's me", Genre.chillout,2016),max32);

        System.out.println("UNSORTED: "+great_songs);
        Sorter.sortByYear(great_songs.getPlaylist());
        System.out.println("BY YEAR: "+great_songs);
        Sorter.sortByYearDescending(great_songs.getPlaylist());
        System.out.println("BY YEAR DESCENDING: "+great_songs);
        Sorter.sortByComposer(great_songs.getPlaylist());
        System.out.println("BY COMPOSER: "+great_songs);
        Sorter.sortByComposerDescending(great_songs.getPlaylist());
        System.out.println("BY COMPOSER DESCENDING: "+great_songs);

        PlayList stand_ups = new PlayList("Famous stand Ups",max32);

        stand_ups.addTrack(Sorter.trackRetriever(great_songs.getPlaylist()),max32); // adding 1 track from 'great_songs' to 'stand_ups'

        List<Music> filtered_tracks = new ArrayList<>();

        filtered_tracks=Sorter.onlySameOf(Sorter.findByGenre(great_songs.getPlaylist(),"comedy"),Sorter.findByYear(great_songs.getPlaylist(),2008,2016));
        System.out.println(filtered_tracks); // ONLY SAME 2008-2016 years && comedy

        filtered_tracks=Sorter.anyOf(Sorter.findByGenre(great_songs.getPlaylist(),"comedy"),Sorter.findByYear(great_songs.getPlaylist(),2008,2016));
        System.out.println(filtered_tracks); // ALL 2008-2016 year || comedy

//        System.out.println(stand_ups);
//        System.out.println(max32);
//        max32.printPlayLists();



    }
}
