package UMLDiagram;

public class Player {

    private String name;
    private int age;
    private int score;

    public Player(String name, int age){
        this.name = name;
        this.age = age;
        score = 0;

    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){

    }

    public void addScore(int score) {
        this.score += score;
    }

}
