package project.entity;

import project.io.IllegalFormatException;

import java.util.*;

public class PlayList {

    private final List<Music> playlist = new ArrayList<>();
    private String NAME;
    private final User owner;
    private final Set<User> editors = new HashSet<>();

    public PlayList(String NAME, User owner) {
        if(!(Tools.correctName(NAME))){
            throw new IllegalFormatException("Illegal name!: "+ NAME);
        }
        this.NAME=NAME;
        this.owner=owner;
        owner.addPlayList(this);
        editors.add(owner);
    }

    public PlayList addTrack(Music m,User user){ // project.entity.Music m
        for (User editor:editors) {
            if(editor.equals(user)){
                playlist.add(m);
                return this;
            }
        }
        throw new project.io.IllegalFormatException("You don't have permissions to add tracks to this playlist: "+NAME);
    }

    public List<Music> getPlaylist() {
        return playlist;
    }
    public PlayList addEditor(User user){
        editors.add(user);
        return this;
    }

    public String printPlayList(){
        StringJoiner joiner = new StringJoiner("\n","\n","");
        for (int i=0;i<playlist.size();i++) {
            joiner.add(i+1+"."+playlist.get(i).toString());
        }
        return joiner.toString();
    }

    public void removeTrack(String trackName,User user){
        // todo
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayList playList = (PlayList) o;

        if (playlist != null ? !playlist.equals(playList.playlist) : playList.playlist != null) return false;
        if (NAME != null ? !NAME.equals(playList.NAME) : playList.NAME != null) return false;
        if (owner != null ? !owner.equals(playList.owner) : playList.owner != null) return false;
        return editors != null ? editors.equals(playList.editors) : playList.editors == null;
    }

    public User getOwner() {
        return owner;
    }

    public int getSize(){ return playlist.size(); }

    public String getName() {
        return NAME;
    }
    public void setName(String NAME) {
        this.NAME = NAME;
    }
    @Override
    public String toString() {
        return "Playlist "+ "'"+NAME+"'" + " : "+printPlayList()+"\n";
    }
}
