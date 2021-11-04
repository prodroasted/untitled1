public class opgave2 {
   private String title;
   private String artist;
   private int bpm;

   public opgave2 (String title, String artist, int bpm){
       this.title = title;
       this.artist = artist;
       this.bpm = bpm;
   }

   public void setBpm(int bpm){
       this.bpm = bpm;
   }

   public void tilpas(int bpm){
       int middel = 120;
       if (middel < bpm){
           System.out.println("Hurtig");
       }
       else if (middel > bpm){
           System.out.println("Langsom");
       }
       else {
           System.out.println("Perfekt");
       }
   }

   public String getTitle(){
       return title;
   }

   public String getArtist(){
       return artist;
   }

   public int getBpm(){
       return bpm;
   }

   public void printSong(){
       System.out.println("**********************");
       System.out.println("Titel : " + getTitle());
       System.out.println("Kunstner : " + getArtist());
       System.out.println("Hastighed : " + getBpm() + "(BPM)");
       System.out.println("**********************");
   }

}
