import com.nirvana.learning.CricketTournament;
import com.nirvana.learning.TossConditions;
import com.nirvana.learning.enums.Teams;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FixMethodOrder(MethodSorters.DEFAULT)
public final class CricketChallengeTest {

    private final static List<String> weatherType = Arrays.asList("Clear","Cloudy");
    private final static List<String> dayType = Arrays.asList("Day", "Night");
    private String commentaryFileName = CricketTournament.cricketProperties.properties.getProperty("commentaryFileName");
    private String scoreCardFileName = CricketTournament.cricketProperties.properties.getProperty("scoreCardFileName");
    //Set4Problem1
    @Test
    public void testToss()  {
        int weatherIndex =  new Random().nextInt(weatherType.size());
        int dayIndex =  new Random().nextInt(dayType.size());
        System.out.println("Input: "+weatherType.get(weatherIndex) +" "+dayType.get(dayIndex));
        System.out.println(TossConditions.getInstance().getTossResult(Teams.LENGABURU, weatherType.get(weatherIndex), dayType.get(dayIndex)));
        System.out.println("---------------------------------------------------------");

    }

    //Set4Problem2
    @Test
    public void chaseInning() throws IOException {
        final  String [] playerNames = {"Kirat Boli","N.S Nodhi","R Rumrah","Shashi Henra"};
        int [][] probMatrix = {
                {5, 30, 25, 10, 15, 1, 9, 5},
                {10, 40, 20, 5,10, 1, 4, 10},
                {20, 30, 15, 5, 5, 1, 4, 20},
                {30, 25, 5, 0, 5, 1, 4, 30}
        };
        CricketTournament cricketTournament = new CricketTournament();

        cricketTournament.buildPlayerMatrix(playerNames, probMatrix, 4);
        cricketTournament.chaseTarget("Lengaburu");

        cricketTournament.printFile(scoreCardFileName);
        cricketTournament.printFile(commentaryFileName);
        System.out.println("---------------------------------------------------------");
    }

    //Set4Problem3
    @Test
    public void playSuperOver() throws IOException {
        final  String [] lengaburuNames = {"Kirat Boli","N.S Nodhi"};
        final  String [] enchaiNames = {"DB Vellyers","H Mamla"};
        int [][] lengaburuProbMatrix  = {
                {5, 10, 25, 10, 25, 1, 14, 10},
                {5, 15, 15, 10, 20, 1, 19, 15}
        };
        int [][] enchaiProbMatrix = {
                {5, 10, 25, 10, 25, 1, 14, 10},
                {10, 15, 15, 10, 20,1, 19, 10}
        };

        CricketTournament cricketTournament = new CricketTournament();

        cricketTournament.buildPlayerMatrix(lengaburuNames, lengaburuProbMatrix,1);
        cricketTournament.setTarget("Lengaburu");

        cricketTournament.buildPlayerMatrix(enchaiNames, enchaiProbMatrix,1);
        cricketTournament.setChase("Enchai");

        cricketTournament.printFile(scoreCardFileName);
        cricketTournament.printFile(commentaryFileName);
        System.out.println("---------------------------------------------------------");
    }

}
