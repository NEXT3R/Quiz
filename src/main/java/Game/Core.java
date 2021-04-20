package Game;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;
import java.util.Timer;

public class Core {
    private Boolean night= false;
    private Player[] players=new Player[6];
    private int i =-1;

    public  void addPlayer(User autor){ ///osetrit ci nahodou nehra dva krat
        i++;
        players[i]= new Player(i,autor);
        System.out.println(i+" Priadl sa hrac "+autor.getAsTag());

}

    public Boolean getNight() {
        return night;
    }

    public void setNight(Boolean night) {
        this.night = night;
    }

    public void addRoles(){//zatial
    Random rand = new Random();

        int r = rand.nextInt(i);
            for (int j=0;j<=i;j++){
                if (r==j){
                    this.players[j].setRole("mafioso");
                }else{
                    this.players[j].setRole("townie");
                }
            }

    }

    public Player[] getPlayers() {
        return players;
    }


    public void isDay(){
        this.night=false;
        for (int i =0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }

}