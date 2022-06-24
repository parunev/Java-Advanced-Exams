package E12Exam29february2020.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    public List<Player> roster;
    public String name;
    public int capacity;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (this.roster.size()<capacity){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name)){
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name) && player.getRank().equals("Trial")){
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name) && !player.getRank().equals("Trial")){
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> playersToRemove = this.roster.stream().filter(s->s.getClazz().equals(clazz)).collect(Collectors.toList());
        this.roster.removeAll(playersToRemove);
        return playersToRemove.toArray(Player[]::new);
    }

    public String report() {
        return "Players in the E12Exam29february2020.guild: " + this.name + ":" + System.lineSeparator() +
                this.roster.stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public int count() {
        return this.roster.size();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

}
