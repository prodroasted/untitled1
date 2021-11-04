package serie;

import java.util.ArrayList;

public class series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();

    public series (String title, ArrayList<String> cast){
        this.title = title;
        this.cast = cast;
    }

    public String getTitle (){
        return title;
    }

    public int totalLength(){

    }

    public ArrayList<String> getCast (){
        return cast;
    }
}
