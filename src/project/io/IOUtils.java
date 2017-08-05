package project.io;

import project.entity.Tools;
import project.entity.Genre;
import project.entity.Music;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

    public static final String DELIMITER= Tools.CSV_DELIMITER;

    //     Input to text file
    public static List<Music> readMusicFromTextFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readMusic(reader);
        }
    }
    private static List<Music> readMusic(BufferedReader reader) throws IOException {
        List<Music> res = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            Music music = parseMusic(line);
            res.add(music);
        }

        return res;
    }

    //     Output to text file
    public static void writeMusicIntoTextFile(String filePath, List<Music> list) throws FileNotFoundException{
        try(PrintWriter printWriter = new PrintWriter(new File(filePath))){
            writeMusic(printWriter, list);
        }

    }
    private static void writeMusic(PrintWriter printWriter, List<Music> list) {
        for (Music music : list) {
            printWriter.println(music.convertToString(DELIMITER));
        }
    }

    //     Output to binary file
    public static void writeMusicIntoBinFile(String fileName, List<Music> tracks) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(tracks);
        }
    }

    //     Input from binary file
    public static List<Music> readMusicFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Music>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    //     Parse read values into Music Object
    private static Music parseMusic(String line) {
        String[] tokens = line.split(DELIMITER); // composer=[0] / name=[1] - genre=[2] - year=[3]

        if (tokens.length < 3) {
            throw new IllegalFormatException("Missing values, should be (composer;name;genres,year): " + line);
        }

        if (!Validator.isInt(tokens[3])) {
            throw new IllegalFormatException("Release year in not a number: " + tokens[3]);
        }else {
            if (!Validator.isReleaseYear(Integer.parseInt(tokens[3]))){
                throw new IllegalFormatException("Release date is not correct! : " + tokens[3]);
            }
        }

        if(!Genre.isGenre(tokens[2])){
            throw new IllegalFormatException("There's no kind of genre in database : " + tokens[2]);
        }

        String composer = tokens[0];
        String name = tokens[1];
        Genre genre = Genre.valueOf(tokens[2]);
        int year = Integer.parseInt(tokens[3]);

        return new Music(composer,name,genre,year);
    }


}
