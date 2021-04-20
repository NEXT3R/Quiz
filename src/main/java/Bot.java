import Events.MessageListener;
import Game.Player;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class  Bot {


    public static void main(String[] args)throws Exception {

      JDA jda= new  JDABuilder("NzgwNDQ3MzEzOTM1MjA0Mzg0.X7vOMw.3Xu7VoApQ7A5EXo1zJ9DRk4IJGM")
                .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                .setMemberCachePolicy(MemberCachePolicy.ALL) // ignored if chunking enabled
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();

        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.addEventListener(new MessageListener());

        System.out.println("Im Alive");


    }
}
