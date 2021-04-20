package Events;


import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import quiz.PlayerQ;
import quiz.Quiz;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Locale;

public class MessageListener extends ListenerAdapter {

    private int j = -1;
    //  private Player[] players =new Player[6];
    private PlayerQ[] players = new PlayerQ[6];
    private Boolean game = false;
    private TextChannel salem;

    private int voted =0;
    Quiz quiz = new Quiz();
    private int max= 7;
    private int q= 1;
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        this.salem = event.getGuild().getTextChannelsByName("salem",true).get(0);
        User author = event.getAuthor();
        String message = event.getMessage().getContentRaw();
        System.out.println(message);

        if (message.equals(".join")) {
            j++;
            players[j] = new PlayerQ(author);
            event.getChannel().sendMessage(author.getAsTag() + " has joined the game").queue();

        }
        else if (game == false && message.equals(".start") && j != -1) {

            event.getChannel().sendMessage("lets do this").queue();
            game = true;
                try {
                    quiz.question( salem,q);
                    q++;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
            }


           /* event.getChannel().sendMessage("Sending roles").queue();
            cores.addRoles();
           salemChannel = event.getGuild().getTextChannelsByName("salem",true).get(0);
            cores.setNight(true);
           game=true;
            players= cores.getPlayers();
                for(int i=0;i<=j;i++){
                    User on =  players[i].getAutor();
                    int finalI = i;
                    on.openPrivateChannel().queue(channel ->{
                        channel.sendMessage("Your Role is "+players[finalI].getRole()).queue();
                    });
                }
                salemChannel.sendMessage("A Night has started").queue();

                    */
        }

    }

    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if (game && msg[0].toUpperCase(Locale.ROOT).matches("[A-D]")) {
            if (msg[0].toUpperCase(Locale.ROOT).equals(quiz.getAns())) {
                for (int i = 0; i <=j; i++) {
                    if (author == players[i].getAutor()) {
                        players[i].setScore(1);
                        players[i].setVoted(true);
                        voted++;
                    }
                }
            } else {
                for (int i = 0; i <= j; i++) {
                    if (author == players[i].getAutor()) {
                        players[i].setVoted(true);
                        voted++;
                    }
                }
            }
            System.out.println(voted);
            if (voted==j+1){

                event.getChannel().sendMessage("Correct Answer was: "+quiz.getAns()).queue();
                voted=0;
                if(q<=max) {
                    try {
                        quiz.question(salem, q);
                        q++;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else {
                    game=false;
                System.out.println(game);
                for (int i = 0; i <= j; i++) {
                    event.getChannel().sendMessage(players[i].getAutor().getAsTag()+" score: "+ players[i].getScore()).queue();
                }
                salem.sendMessage("thats all folks").queue();
                    players = new PlayerQ[6];
                    System.out.println(players);
                    q=1;
                    j=-1;
                    //salem.getHistory()
            }
            }

       /* User author = event.getAuthor();
        String[] msg= event.getMessage().getContentRaw().split(" ");
        if (game){
            if (msg[0].equals(".alive")){
                for(int i=0;i<=j;i++){
                    if(players[i].isAlive()){
                        event.getChannel().sendMessage(players[i].getPl_nm()+" "+players[i].getAutor().getAsTag()).queue();
                    }
                }
            }

            for (int i=0;i<=j;i++){

                if (author ==players[i].getAutor() && players[i].getRole() == "mafioso" && msg[0].equals(".kill")) {//asi aj votovanie
                    if (msg[1].matches("[0-9]+")){
                        int killNm = Integer.parseInt(msg[1]);
                       if(players[killNm].isAlive()==true) {
                           players[killNm].setAlive(false);
                           author.openPrivateChannel().queue(channel -> {
                               channel.sendMessage("kill comfirmed " + players[killNm].getAutor()).queue();
                           });

                           salemChannel.sendMessage(players[killNm].getAutor().getAsTag()+" has died :(").queue();

                       }else{
                           author.openPrivateChannel().queue(channel -> {
                               channel.sendMessage("Player is already dead...").queue();
                           });
                       }
                    }

                }
            }
        }*/
        }


    }

}