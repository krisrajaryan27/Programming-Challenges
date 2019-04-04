package com.nirvana.learning.geektrust;

import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CricketTournament {
    public static CricketProperties cricketProperties = new CricketProperties();

    private  int totalOvers ;
    private  int runsToWin = 40;
    private int totalRuns = 0;
    private  int wicketsLeft;
    private  String [] playerNames;

    private  Pair<Integer,Integer>[] strikeRate ;
    private Set<Integer> outPlayerSet;
    private Map<Boolean,Integer> currentPlayers;
    private  int nextPlayerIndex = 2;
    private final Random r;
    private int ballRemaining = 0;
    private FileWriter commentaryFile;
    private FileWriter scoreFile;
    private PrintWriter commentaryPrint;
    private PrintWriter scorePrint;
    private int [][] cumProbMatrix;
    private String firstTeam;
    private String secondTeam;

    public CricketTournament() throws IOException {
        r = new Random(System.currentTimeMillis());
        String commentaryFileName = cricketProperties.properties.getProperty("commentaryFileName");
        String scoreCardFileName = cricketProperties.properties.getProperty("scoreCardFileName");
        commentaryFile = new FileWriter(commentaryFileName,false);
        scoreFile = new FileWriter(scoreCardFileName,false);
    }

   public void buildPlayerMatrix(String[] names, int[][] probMatrix, int overs) {
        playerNames = names.clone();
        cumProbMatrix = getCumSums(probMatrix);
        totalOvers = overs;
        wicketsLeft = playerNames.length - 1;
        currentPlayers = new HashMap<>();
        currentPlayers.put(true, 0);
        currentPlayers.put(false, 1);
        totalRuns = 0;
        strikeRate = new Pair[playerNames.length];
        for(int index = 0; index < playerNames.length; index++){
            strikeRate[index] = new Pair<>(0,0);
        }
        outPlayerSet = new HashSet<>();
        if(commentaryPrint== null)
            commentaryPrint = new PrintWriter(commentaryFile);
        if(scorePrint == null)
            scorePrint = new PrintWriter(scoreFile);
    }

    private void swapPlayer(){
        Integer player1Index = currentPlayers.get(true);
        Integer player2Index = currentPlayers.get(false);
        currentPlayers.put(false, player1Index);
        currentPlayers.put(true, player2Index);

    }

    private boolean removeCurrentPlayer(){
        int outPlayerIndex = currentPlayers.remove(true);
        outPlayerSet.add(outPlayerIndex);
        if(nextPlayerIndex == playerNames.length)
            return false;
        currentPlayers.put(true, nextPlayerIndex);
        nextPlayerIndex++;
        wicketsLeft--;
        return true;
    }

    private void setTargetScore(int score){
        runsToWin = score;
    }

    private  boolean updateStatistics(int playerIndex, int shotIndex, String ball){
        Integer ballsPlayed = strikeRate[playerIndex].getKey();
        Integer runsScored = strikeRate[playerIndex].getValue();
        String scoreFormat = cricketProperties.properties.getProperty("scoreFormat");
        String outFormat = cricketProperties.properties.getProperty("outFormat");
        boolean matchRunning = true;
        commentaryPrint.println();
        switch(shotIndex){
            case 0:
            case 2:
            case 4:
            case 6:
                runsScored+=shotIndex;
                totalRuns+=shotIndex;
                commentaryPrint.print(String.format(scoreFormat,ball, playerNames[playerIndex], shotIndex));
                break;
            case 1:
            case 3:
            case 5:
                runsScored+=shotIndex;
                totalRuns+=shotIndex;
                swapPlayer();
                commentaryPrint.print(String.format(scoreFormat,ball, playerNames[playerIndex], shotIndex));
                break;
            case 7:
                commentaryPrint.print(String.format(outFormat, ball, playerNames[playerIndex]));
                matchRunning= removeCurrentPlayer();

        }
        ballsPlayed+=1;
        strikeRate[playerIndex] = new Pair<>(ballsPlayed,runsScored);
        return matchRunning;

    }

    private  boolean playShot(String ballIndex){
        Integer playerIndex= currentPlayers.get(true);
        int score = (int)(r.nextFloat()*100);
        int shotIndex = Arrays.binarySearch(cumProbMatrix[playerIndex], score);
        if(shotIndex< 0)
            shotIndex = -1*(shotIndex +1);
        return updateStatistics(playerIndex, shotIndex, ballIndex);

    }

    private  Pair<Boolean, Integer> chaseOver(int overIndex){
        for(int ball = 0; ball < 6; ball++){
            if(!playShot(""+overIndex+"."+(ball+1)))
                return new Pair<>(false,null);
            else{
                if(runsToWin <= totalRuns)
                    return new Pair<>(true, 6- ball -1);
            }
        }
        return new Pair<>(null,null);
    }

    private  Pair<Boolean, Integer> playOver(int overIndex){
        for(int ball = 0; ball < 6; ball++){
            if(!playShot(""+overIndex+"."+(ball+1)))
                return new Pair<>(false,null);
        }
        return new Pair<>(null,null);
    }

    private void appendHeaderToScoreCard() throws IOException {
        String scoreCardFileName  = cricketProperties.properties.getProperty("scoreCardFileName");
        cleanUpScoreCard();
        List<String> lines = Files.readAllLines(Paths.get(scoreCardFileName));
        String winFormat = firstTeam+" won by %d runs";
        Pair<Boolean, Integer> winner = getWinner();
        scoreFile = new FileWriter(scoreCardFileName,false);
        scorePrint = new PrintWriter(scoreFile);
        if(winner.getKey()!= null){
            if(winner.getKey()){
                winFormat = secondTeam+" won with %d balls remaining";
                scorePrint.println(String.format(winFormat, winner.getValue()));
            }
            else{
                scorePrint.println(String.format(winFormat, winner.getValue()));
            }
        }
        else{
            scorePrint.println(cricketProperties.properties.getProperty("tieFormat"));
        }
        scorePrint.println();
        lines.forEach(scorePrint::println);
        cleanUpScoreCard();
    }

    private Pair<Boolean, Integer> getWinner(){
        if(totalRuns >= runsToWin){
            return new Pair<>(true, ballRemaining);
        }
        else if(totalRuns < runsToWin -1 ){
            return new Pair<>(false, runsToWin - totalRuns -1);

        }
        else
            return new Pair<>(null, 0);
    }

    private void cleanUpCommentary() throws IOException {
        commentaryPrint.close();
        commentaryFile.close();
    }

    private void cleanUpScoreCard() throws IOException {
        scorePrint.close();
        scoreFile.close();
    }

    public void chaseTarget(String teamName) throws IOException {
        secondTeam = teamName;
        commentaryPrint.println("Sample commentary");
        commentaryPrint.println();
        String outputFormat = cricketProperties.properties.getProperty("outputFormat");
        Pair<Boolean, Integer> overResult = null;
        for(int over = 0; over<totalOvers; over++){
            commentaryPrint.println();
            commentaryPrint.println(String.format(outputFormat, totalOvers - over, runsToWin - totalRuns));
            overResult = chaseOver(over);
            if(overResult.getKey()!= null){
                if(overResult.getKey()) {
                    commentaryPrint.print(teamName+" wins");
                    ballRemaining =  overResult.getValue()+ (totalOvers - over -1)*6;
                    cleanUpCommentary();
                    break;
                }
                else {
                    commentaryPrint.print(teamName+" all out");
                    cleanUpCommentary();
                    break;
                }
            }
            else if(totalRuns == runsToWin - 1 ){
                commentaryPrint.println(cricketProperties.properties.getProperty("tieFormat"));
            }
            else if (over == totalOvers -1){
                commentaryPrint.print(teamName+" loses");
            }
            if(over!=totalOvers-1)
                commentaryPrint.println();
            swapPlayer();

        }
        cleanUpCommentary();
        writeChaseScoreCard(teamName);

    }

    public void  setTarget(String teamName) throws IOException {
        firstTeam = teamName;
        commentaryPrint.println("Sample commentary");
        commentaryPrint.println();
        commentaryPrint.println(teamName+" innings");
        for(int over = 0; over<totalOvers; over++){
            Pair<Boolean, Integer> overResult = playOver(over);
            if(overResult.getKey()!= null) {
                if (!overResult.getKey()) {
                    commentaryPrint.println(teamName+"  all out");
                }
            }
        }
        setTargetScore(totalRuns +1);
        commentaryPrint.println();
        writeScoreCard(teamName);

    }

    public void setChase(String teamName) throws IOException {
        secondTeam = teamName;
        commentaryPrint.println();
        commentaryPrint.println(teamName+" innings");
        Pair<Boolean, Integer> overResult = null;
        for(int over = 0; over<totalOvers; over++){
            overResult = chaseOver(over);
            if(overResult.getKey()!= null) {
                if (overResult.getKey()) {
                    ballRemaining = overResult.getValue();
                    commentaryPrint.println(teamName+" wins");
                } else {
                    commentaryPrint.println(teamName+" all out");
                }
            }
            else if(totalRuns == runsToWin - 1 ){
                commentaryPrint.println(cricketProperties.properties.getProperty("tieFormat"));
            }
            else{
                commentaryPrint.println(teamName+" loses");
            }
        }

        cleanUpCommentary();
        writeScoreCard(teamName);
        appendHeaderToScoreCard();
    }


    private void writeChaseScoreCard(String teamName) throws IOException {
        String winFormat = teamName+" "+cricketProperties.properties.getProperty("winFormat");
        String lossFormat = teamName+" "+cricketProperties.properties.getProperty("lossFormat");
        String tieFormat = cricketProperties.properties.getProperty("tieFormat");
        if(runsToWin <= totalRuns){
            scorePrint.println(String.format(winFormat, wicketsLeft, ballRemaining));
        }
        else if(runsToWin - totalRuns> 1){
            scorePrint.println(String.format(lossFormat, runsToWin - totalRuns - 1));
        }
        else{
            scorePrint.println(tieFormat);

        }
        scorePrint.println();
        commonWriteScoreCard();
        cleanUpScoreCard();
    }

    private void writeScoreCard(String teamName){
        scorePrint.println(teamName);
        commonWriteScoreCard();
        scorePrint.println();
    }

    private void commonWriteScoreCard(){
        for(int index = 0; index <playerNames.length; index++){
            if(outPlayerSet.contains(index))
                scorePrint.println(playerNames[index]+" - "+strikeRate[index].getValue()+"("+ strikeRate[index].getKey()+")");
            else if(currentPlayers.containsValue(index))
                scorePrint.println(playerNames[index]+" - "+strikeRate[index].getValue()+"*("+ strikeRate[index].getKey()+")");
        }
    }

    public void printFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        lines.forEach(System.out::println);
        System.out.println();
    }

    private int [][] getCumSums( int [][] probMatrix){

        int [][] cumSumProbMatrix = new int [probMatrix.length][probMatrix[0].length];
        IntStream.range(0,probMatrix.length).forEach(index-> {
            AtomicInteger sum = new AtomicInteger(0);
            cumSumProbMatrix[index] = Arrays.stream(probMatrix[index]).map(sum::addAndGet).toArray();
        });
        return cumSumProbMatrix;
    }


}
