package project.runner;

import project.entity.*;
import project.sorter.Sorter;

public class Main {

    private static final String IN_FILE_PATH = Tools.DEFAULT_FILE_PATH;

    public static void main(String[] args) {

        MusicDB database = new MusicDB();
        database.readTracksFromFile(IN_FILE_PATH);

        User user1 = new User("Dark_Vadim");
        User user2 = new User("Mikey_212");

        PlayList calm_vibes = new PlayList("calm vibes",user1); // user1 created playlist

//        calm_vibes.addTrack(Sorter.trackRetriever(Sorter.findTrack(database.getData(),"tothegood")),user2);// NO PERMISSIONS ( EXCEPTION )

        user1.addEditor(user2,calm_vibes); // now user 2 can edit "calm_vibes" playlist

        calm_vibes.addTrack(Sorter.trackRetriever(Sorter.findTrack(database.getData(),"tothegood")),user2); // GOT PERMISSIONS ( OK ! )
        calm_vibes.addTrack(Sorter.trackRetriever(Sorter.findTrack(database.getData(),"akiaura")),user1); // GOT PERMISSIONS ( OK ! )
        calm_vibes.addTrack(Sorter.trackRetriever(Sorter.findTrack(database.getData(),"win32")),user2); // GOT PERMISSIONS ( OK ! )

        System.out.println(user1); //printing user's info
        user1.printPlayLists(); // printing users playlists , should be 3, cause 2 defaults: 'favorites', 'listened', and new 'calm vibes';

        System.out.println(user2); //printing user's info
        user2.printPlayLists(); // printing users playlists , should be , cause 2 defaults: 'favorites', 'listened', editing playlists does not count

        calm_vibes.addTrack(Sorter.trackRetriever(Sorter.findTrack(database.getData(),"Brothel")),user1);


    }
}
