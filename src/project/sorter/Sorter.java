package project.sorter;

import project.entity.Music;
import project.entity.PlayList;
import project.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter {

    public static void sortByComposer(List<Music> list){
        Collections.sort(list,new ComposerComparator());
    }
    public static void sortByComposerDescending(List<Music> list){
        Collections.sort(list, Collections.reverseOrder(new ComposerComparator()));
    }
    public static void sortByYear(List<Music> list){
        Collections.sort(list, new YearComparator());
    }

    public static void sortByYearDescending(List<Music> list){
        Collections.sort(list, Collections.reverseOrder(new YearComparatorDescending()));
    }

    //todo: SORT BY GENRE? ORDERING?? house -> progressive_house-> ..all houses then next?

    //todo { HOW TO DO BETTER ??
    public static List<Music> findTrack(List<Music> list, String search_string){
        return list.stream().filter(m -> m.convertToString("").contains(search_string.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Music> findByGenre(List<Music> list, String search_tag){
        return list.stream().filter(m -> m.getGenre().name().toLowerCase().contains(search_tag.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Music> findByYear(List<Music> list, int year1, int year2){
        return list.stream().filter( music -> music.getYear()>=year1 && music.getYear()<=year2 ).collect(Collectors.toList());
    }

    public static List<PlayList> findPlayList(User user, String search_string){ // ???
        return user.getPlaylists().stream().filter(p -> p.getName().toLowerCase().contains(search_string.toLowerCase())).collect(Collectors.toList());
    }
    // todo  HOW TO DO BETTER ??? }


    // todo {  HOW TO DO BETTER ??
    /**
     * Uses scanner to contact with user
     * @return Music
     */
    public static Music trackRetriever(List<Music> list){ // TODO: EDIT DANGER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner sc = new Scanner(System.in);
        System.out.println("FOUND TRACKS:  ");
        for (int i=0;i<list.size();i++) {
            System.out.println(i+". "+list.get(i));
        }
        System.out.println("*** Enter a number of track to choose! ***");
        return list.get(sc.nextInt()); //todo: fix dangerous operation !
    }

    /**
     * Uses scanner to contact with user
     * @return PlayList
     */
    public static PlayList playListRetriever(List<PlayList> list){ // TODO: EDIT DANGER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner sc = new Scanner(System.in);
        System.out.println("FOUND PLAYLIST(S): ");
        for (int i=0;i<list.size();i++) {
            System.out.println(i+". "+list.get(i));
        }
        System.out.println("*** Enter a number of playlist to choose! ***");
        return list.get(sc.nextInt()); //todo: fix dangerous operation !
    }
    // todo HOW TO DO BETTER ?? }

    /**
     * COMBINES FOUND LISTS INTO 1 LIST
     * @return Music list
     */

    public static List<Music> anyOf(List<Music>... lists) {
        List<Music> finalList = new ArrayList<>();
        Set<Music> set = new HashSet<>();
        for (List list:lists) {
            set.addAll(list);
        }
        finalList.addAll(set);
        return finalList;
    }

    public static List<Music> onlySameOf(List<Music>... lists) {// TODO: EDIT DANGER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        List<Music> finalList = new ArrayList<>();
        Map<Music,Integer> map = new HashMap<>();

        for (List list:lists) {
            for (int i = 0; i < list.size(); i++) {
                if(map.containsKey(list.get(i))){
                    map.put((Music)list.get(i), map.get(list.get(i))+1);
                }else{
                    map.put((Music)list.get(i),0);
                }
            }
        }

        System.out.println("MAP : "+map);

        for (Map.Entry<Music, Integer> entry : map.entrySet())
        {
            if(entry.getValue()==1){
                finalList.add(entry.getKey());
            }
        }
        return finalList;
    }


}
