package com.example.HangmanFunctional.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ScoreFile {
    private static final String filePath= "src/main/resources/Leaderboard.txt" ;

    private Scanner scanner;

    protected int getRank (int userScore, String userName) throws NumberFormatException{
        try{

            File text = new File(filePath);
            Scanner scanner = new Scanner(text);
            //Key, Value
            //Key = Rank,  Value = Player which has score and name 
            Map<Integer, ArrayList<Player>> user ;
            Map<Integer, String> scoreMap ;

            int userRank, prevRank, prevScore;
            userRank = prevRank = prevScore = 0;
            int lineNumber = 1;

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();

                if(line.isEmpty()){
                    break;
                }
                //rank name score
                String[] array = line.split(" "); /*split by space */

                int currRank = Integer.parseInt(array[0]);
                String currName = array[1];
                int currScore = Integer.parseInt(array[2]);
                //60    userScore = 60
                if(currScore == userScore){
                    userRank = currRank;
                    break;
                }
                // 50    userScore = 100
                if( (prevScore == 0) && ( currScore < userScore  )){
                    userRank = currRank;
                    decrementScore( lineNumber );
                }
                //100    userScore = 50;
                if( (prevScore == 0 ) && ( currScore > userScore)){
                    userRank = currRank++;
                    break;
                }
                //100 50       userScore = 60
                if( (prevScore > userScore) && (currScore < userScore ) ){
                    userRank = currRank;
                    decrementScore( lineNumber );
                    break;
                }
                // 100 90  userScore = 60  (do nothing)

                prevRank = currRank;
                prevScore = currScore;

                lineNumber++;
            }
            /* Empty file */
            if(lineNumber == 1){
                userRank = 1;
            }
            /* User score is the lowest ever */
            if( userRank == 0){
                userRank = prevRank++;
            }

            scanner.close();

            return userRank;

        }catch( FileNotFoundException e){
            System.out.println("Leaderboard.txt not found");
        }
        return -1;
    }
    //get rank
    //get file position
    //sort file
    private void decrementScore(int lineNum){
        int i = 1;

    }
}
