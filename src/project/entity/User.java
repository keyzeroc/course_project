package project.entity;

import project.io.IllegalFormatException;

import java.util.*;

public class User {

    private String name;
    private String id;
    private List<PlayList> playlists = new ArrayList<>();
    private final PlayList favorites = new PlayList("favorites",this);
    private final PlayList listened = new PlayList("Recently listened",this);

    public User(String name){
        if(!(UserDB.nameAvailable(name))){
            throw new project.io.IllegalFormatException("User with this name is already exists: "+name);
        }
        if(!(Tools.correctName(name))){
            throw new IllegalFormatException("Illegal name!: "+ name);
        }
        this.name=name;
        id = UUID.randomUUID().toString();
        UserDB.addUser(this);
    }

    public User addPlayList(PlayList playlist){
        if(!(playlists.contains(playlist))){
            playlists.add(playlist);
        }else {
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public PlayList getFavorites() {
        return favorites;
    }

    public PlayList getListened() {
        return listened;
    }

    public void addEditor(User newEditor, PlayList playlist ){ // String search_string (was as paramether)
        playlist.addEditor(newEditor);
//        project.sorter.Sorter.findPlayList(this, search_string).addEditor(newEditor);
    }

    public void addTrackToPlayList(Music music, PlayList playlist){
        playlist.addTrack(music,this);
    }

    public void printPlayLists(){ // print all user playlists
        for (PlayList playlist:playlists) {
                System.out.println(playlist);
        }
    }

    public void listen(Music listen){
        listened.addTrack(listen,this);
    }

    public void deletePlayList(String nameOfPlayList){  // find playlist by name and delete it  todo вынести в сортер
        for (PlayList playlist:playlists) {
            if(nameOfPlayList.equals(playlist.getName())){
                playlists.remove(playlist);
                break;
            }
        }
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (playlists != null ? !playlists.equals(user.playlists) : user.playlists != null) return false;
        if (favorites != null ? !favorites.equals(user.favorites) : user.favorites != null) return false;
        return listened != null ? listened.equals(user.listened) : user.listened == null;
    }

    @Override
    public String toString() {
        return "User: "+name+ ", ID:"+id+", playlists: "+playlists.size()+"\n***********************************************************************";
    }
}
