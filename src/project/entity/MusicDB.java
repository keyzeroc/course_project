package project.entity;

import project.io.IllegalFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static project.io.IOUtils.readMusicFromTextFile;

public class MusicDB {
    private List<Music> musicStorage = new ArrayList<>();

    public void readTracksFromFile(String filePath){
        try{
            musicStorage=readMusicFromTextFile(filePath);
            System.out.println("DONE");
        }catch (IOException e){
            System.out.println("IO: "+e.getMessage());
        }catch (IllegalFormatException e){
            System.out.println("Ill Form: "+e.getMessage());
        }
    }

    public List<Music> getData() {
        return musicStorage;
    }
}
