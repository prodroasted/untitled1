package UMLDiagram;

import java.util.ArrayList;

public class Team {
    ArrayList<Player> list;

    String teamName;

    public Team(String inputTeamName) {
        teamName = inputTeamName;
        list = new ArrayList<Player>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void addPlayers(Player player) {
        list.add(player);
    }

    public void printPlayers() {
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);
            System.out.println(player.getName() + player.getAge() + player.getScore());
        }
    }

    public double calcAverageAge() {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getAge();
        }
        return sum / list.size();
    }

    public int calcTotalScore() {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getScore();
        }
        return total;
    }

    public int calcOldPlayerScore(int ageLimit){
        int limitedscore = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAge() >= ageLimit){
                limitedscore += list.get(i).getScore();
            }
        }
        return limitedscore;
    }

    public int maxScore(){
        int overallbest = 0;
        for(int i = 0; i < list.size(); i++){
            if(overallbest < list.get(i).getScore()){
                overallbest = list.get(i).getScore();
            }
        }
        return overallbest;
    }

    public String bestplayer(){
        String bestname = "";
        int high = 0;
        for(Player player : list){
            if(high < player.getScore()){
                high = player.getScore();
                bestname = player.getName();
            }
        }
        return bestname;
    }

}
