package E12Exam29february2020.guild;

public class Player {
    public String name;
    public String clazz;
    public String rank = "Trial";
    public String description = "n/a";

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getClazz() {return clazz;}
    public void setClazz(String clazz) {this.clazz = clazz;}

    public String getRank() {return rank;}
    public void setRank(String rank) {this.rank = rank;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    @Override
    public String toString(){
        return String.format("Player %s: %s%nRank: %s%nDescription: %s",this.name,this.clazz,this.rank,this.description);
    }
}
