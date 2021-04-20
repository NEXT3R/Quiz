package quiz;

import Game.Player;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Quiz {
    private int max=2;

    private int i =-1;
    private String ans;

    public Quiz() {
    }

    public String getAns() {
        return ans;
    }

    public void question(TextChannel salem, int k) throws FileNotFoundException {

        /*Random random = new Random();
        int k= random.nextInt(3 - 1) + 1;*/
        File file = new File("src/quest/Questions"+k);
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(file);

        //Reading each line of file using Scanner class
        this.ans= scnr.nextLine();
        String line= "";
        while(scnr.hasNextLine()){
             line += scnr.nextLine()+"\n";
        }
        salem.sendMessage(line).queue();

    }
}
