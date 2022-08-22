package com.example.HangmanFunctional.Score;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreFile {
    private static final String filePath= "src/main/resources/Leaderboard.txt" ;

    protected void getRank (int userScore, String userName) throws NumberFormatException, Exception{

            //Key = Rank,  Value = Player which has score and name
            Map<Integer, List<GameSave>> save = new TreeMap<>();
            int userRank = 0;
            save = readFile(save);
            printToFile(save);
            if(save.isEmpty()){
                userRank = 1;
                save = setNewRank( userScore, userName, save, userRank);
            }else{
                //put save into new hashmap of score and rank
                // Create simple TreeMap of <rank, score>
                Iterator<Integer> keyIterator = save.keySet().iterator();

                //Convert scores to treeset
                Set<Integer> valueScore = save.values().stream().flatMap(
                        c -> c.stream().map(GameSave::getScore)
                ).collect(Collectors.toCollection(TreeSet::new));

             //   TreeSet<Integer> valueReverse = (TreeSet<Integer>) ((TreeSet<Integer>) valueScore).descendingSet();
                NavigableSet<Integer> reverseValue = ((TreeSet<Integer>) valueScore).descendingSet();

                Iterator<Integer> valueIt = reverseValue.iterator();
                TreeMap<Integer, Integer> smallSave = new TreeMap<>();
                for( int i : reverseValue){
                    smallSave.put( keyIterator.next(), valueIt.next());
                }
                for( Map.Entry<Integer, Integer> entry : smallSave.entrySet()){
                    System.out.println("Rank = " + entry.getKey() +" Score = "+ entry.getValue());
                }
                int biggerRank = 0;
                int smallerRank = 0;
                boolean hasChanged = false;
                for( Map.Entry<Integer, Integer> entry  : smallSave.entrySet() ) {
                    if (entry.getValue() == userScore) {
                        userRank = entry.getKey();
                        GameSave gameSave = new GameSave(userScore, userName);
                        save.get(userRank).add(gameSave);
                        hasChanged = true;
                        break;
                    } else if (entry.getValue() > userScore) {
                        biggerRank = entry.getKey();
                    } else if (entry.getValue() < userScore) {
                        smallerRank = entry.getKey();
                        userRank = smallerRank;
                        save = incrementRank( save, userRank);
                        save = setNewRank( userScore, userName, save, userRank);
                        hasChanged = true;
                        break;
                    }
                }
                if(!hasChanged){
                    //add too tail
                    userRank = smallSave.get( smallSave.size()-1) + 1;
                    save = setNewRank( userScore, userName, save, userRank );
                }

            }

            printToFile(save);
            writeToFile(save);
    }
    private Map<Integer, List<GameSave>> incrementRank( Map<Integer, List<GameSave>> save , int rank){
        Map<Integer, List<GameSave>> newMap = new TreeMap<>();
        for(Map.Entry<Integer, List<GameSave>> entry  : save.entrySet() ){
            if( entry.getKey() >= rank){
                int key = entry.getKey() + 1;
                newMap.put(key, entry.getValue());
            }else{
                newMap.put( entry.getKey(), entry.getValue());
            }
        }
        return save;
    }

    private Map<Integer, List<GameSave>> setNewRank (int score, String name, Map< Integer,List<GameSave> > save , int rank){

        GameSave gameSave = new GameSave(score, name);
        List<GameSave> list = new ArrayList<>();
        list.add(gameSave);
        save.put(rank, list);

        return save;
    }




    private  Map<Integer, List<GameSave>> readFile ( Map<Integer, List<GameSave>> save  ) throws NumberFormatException{
        try{

            File text = new File(filePath);
            Scanner scanner = new Scanner(text);

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();

                if(line.isEmpty()){
                    break;
                }
                //Line is ordered by String, rank name score
                String[] array = line.split(" "); /*split by space */

                int currRank = Integer.parseInt(array[0]);
                String currName = array[1];
                int currScore = Integer.parseInt(array[2]);

                GameSave gameSave = new GameSave(currScore, currName);

                if( !save.containsKey(currRank)){
                    List<GameSave> newList = new ArrayList<>();
                    newList.add(gameSave);
                    save.put( currRank, newList );
                }else{
                    save.get(currRank).add(gameSave);
                }

            }
            //scanner.close();
        }catch( FileNotFoundException e){
            System.out.println("Leaderboard.txt not found");
        }
        return save;
    }

    public void printToFile( Map<Integer, List<GameSave>> save){
        System.out.println("Here is the old set of scores");
        for(Map.Entry<Integer, List<GameSave>> entry  : save.entrySet() ){
            System.out.println("Rank " + entry.getKey());
            for( GameSave g : save.get(entry.getKey())){
                System.out.println("Rank = " + entry.getKey() + " Name = " + g.getName() + " Score = " + g.getScore());

            }
        }

    }
    public void writeToFile( Map<Integer, List<GameSave>> save) throws Exception{
        File file = new File(filePath);
        BufferedWriter buffer = new BufferedWriter( new FileWriter(file));
        for(Map.Entry<Integer, List<GameSave>> entry : save.entrySet()){
            for( GameSave g : save.get(entry.getKey())){
                String str = (entry.getKey() + " " +g.toString());
                System.out.println(str);
                buffer.write(entry.getKey() + " "+ g.toString() );
                buffer.newLine();

            }
        }
        buffer.flush();
    }
}
