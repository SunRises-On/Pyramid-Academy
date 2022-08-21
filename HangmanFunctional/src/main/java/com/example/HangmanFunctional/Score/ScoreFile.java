package com.example.HangmanFunctional.Score;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScoreFile {
    private static final String filePath= "src/main/resources/Leaderboard.txt" ;

    protected void getRank (int userScore, String userName) throws NumberFormatException{

            //Key = Rank,  Value = Player which has score and name
            Map<Integer, List<GameSave>> save = new TreeMap<>();
            int userRank = 0;
            save = readFile(save);
            writeToFile(save);
            if(save.isEmpty()){
                userRank = 1;
                save = setNewRank( userScore, userName, save, userRank);
            }else{
                //put save into new hashmap of score and rank
                // Create simple TreeMap of <rank, score>
                Iterator<Integer> keyIterator = save.keySet().iterator();

                Map<Integer, Integer> smallSave =
                    save.values().stream().flatMap(
                            c->c.stream().map(d-> d.getScore()))
                            .collect(Collectors.toMap(k->keyIterator.next(),
                                    Function.identity(),
                                    (l,r) -> l , TreeMap::new));


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
            scanner.close();
        }catch( FileNotFoundException e){
            System.out.println("Leaderboard.txt not found");
        }
        return save;
    }

    public void writeToFile( Map<Integer, List<GameSave>> save){
        System.out.println("Here is the old set of scores");
        for(Map.Entry<Integer, List<GameSave>> entry  : save.entrySet() ){
            System.out.println("Rank " + entry.getKey());
            for( GameSave g : save.get(entry.getKey())){
                System.out.println("Rank = " + entry.getKey() + " Name = " + g.getName() + " Score = " + g.getScore());

            }
        }
    }
}
