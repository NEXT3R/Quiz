package Game;

import net.dv8tion.jda.api.entities.User;

public class Player {
    private int pl_nm;
    private User autor;
    private String role;
    private boolean isAlive;
    public Player(int pl_nm, User autor) {
        this.pl_nm = pl_nm;
        this.autor = autor;
        this.isAlive=true;
    }

    public int getPl_nm() {
        return pl_nm;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setRole(String role) {
        this.role = role;

    }

    public User getAutor() {
        return autor;
    }

    public String getRole() {
        return role;
    }
}
