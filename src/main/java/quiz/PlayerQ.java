package quiz;

import net.dv8tion.jda.api.entities.User;

public class PlayerQ {
    private int score =0;
    private User autor;
    private Boolean voted;
    public PlayerQ( User autor) {
       this.score = 0;
        this.autor = autor;
        this.voted= false;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score =this.score+score;
    }

    public User getAutor() {
        return autor;
    }


    public Boolean getVoted() {
        return voted;
    }

    public void setVoted(Boolean voted) {
        this.voted = voted;
    }
}
