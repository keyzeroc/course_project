package project.runner;

import project.entity.Music;
import project.io.IllegalFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static project.io.IOUtils.*;

public class IOUtilsRunner {

    private static final String IN_FILE_PATH = "src\\project\\files\\music_list.csv";
    private static final String OUT_FILE_PATH = "src\\project\\files\\music_list_out.csv";
    private static final String IN_BINARY_FILE_PATH = "src\\project\\files\\music_binary_in.dat";
    private static final String OUT_BINARY_FILE_PATH = "src\\project\\files\\music_binary_in.dat";

    public static void main(String[] args) {


        // JUST READING STUFF
        List<Music> readFromFileList = new ArrayList<>();

        List<Music> outBinary = new ArrayList<>();

        try{
            readFromFileList=readMusicFromTextFile(IN_FILE_PATH);  // READING TRACKS FROM FILE

            writeMusicIntoTextFile(OUT_FILE_PATH,readFromFileList);  // WRITING TRACK INTO FILE

            writeMusicIntoBinFile(IN_BINARY_FILE_PATH,readFromFileList);  // WRITING INTO BINARY FILE

//            readMusicFromBinFile(OUT_BINARY_FILE_PATH,outBinary); TODO: seems not working...

            System.out.println("DONE");
        }catch (IOException e){
            System.out.println("IO: "+e.getMessage());
        }catch (IllegalFormatException e){
            System.out.println("Ill Form: "+e.getMessage());
        }

        System.out.println(readFromFileList);

    }

}
