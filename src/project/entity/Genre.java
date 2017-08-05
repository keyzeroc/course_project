package project.entity;

public enum Genre {
    ambient,
    meditation,
    soundtrack,
    dubstep,
    pop,
    chillout,
    vaporwave,
    witch,
    classic,
    violin,
    piano,
    saxophone,
    guitar,
    comedy,
    choral,
    blues,
    punk,
    synthwave,
    country,
    jazz,
    rock,
    hard_rock,
    punk_rock,
    light_rock,
    garage_rock,
    alternative_rock,
    nightcore,
    remix,
    noise,
    sethos,
    instrumental,
    metal,
    heavy_metal,
    vocal,
    electronic,
    trap,
    wave,
    techno,
    disco,
    dance,
    edm,
    beats,
    club,
    house,
    dutch_house,
    tropical_house,
    chill_house,
    witch_house,
    deep_house,
    future_house,
    progressive_house,
    darkpsy,
    hip_hop,
    rap,
    cloud_rap,
    underground;

    // checks if string is correct, and this kinda genre exists
    public static boolean isGenre(String string){
        for (Genre genre:Genre.values()) {
            if(string.toLowerCase().equals(genre.name().toLowerCase())){
                return true;
            }
        }
        return false;
    }

//    public static Genre[] genreList(){
//        return Genre.values();
//    }

}
