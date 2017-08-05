package project.entity;

import project.io.IllegalFormatException;

public class Tools {
    public static final String CSV_DELIMITER = ";";
    
    public static final String DEFAULT_FILE_PATH = "src\\project\\files\\music_list.csv";

    public static boolean correctName(String name){
        if(!(name==null||name.trim().equals(""))){
            return true;
        }else{
            return false;
        }
    }
}
