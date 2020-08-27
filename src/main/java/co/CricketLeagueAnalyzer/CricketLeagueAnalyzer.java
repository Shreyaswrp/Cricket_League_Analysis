package co.CricketLeagueAnalyzer;

import com.google.gson.Gson;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyzer {

    Map<String, CricketersDataDAO>  map;

    public enum PlayerType{
        BATSMEN, BOWLER
    }

    //to load factsheet csv file data
    public int loadLeagueFactSheet(PlayerType playerType, String csvFilePath) throws CricketLeagueAnalyserException {
        map = new CricketersDataLoader().loadLeagueFactSheet(playerType, csvFilePath);
        return map.size();
    }

    //Method to sort data in descending order
    private List<CricketersDataDAO> descendingSort(Comparator<CricketersDataDAO> csvComparator, List<CricketersDataDAO> censusList) {
        for (int i = 0; i < censusList.size() - 1; i++) {
            for (int j = 0; j < censusList.size() - i - 1; j++) {
                CricketersDataDAO census1 = censusList.get(j);
                CricketersDataDAO census2 = censusList.get(j + 1);
                if (csvComparator.compare(census1, census2) < 0) {
                    censusList.set(j, census2);
                    censusList.set(j + 1, census1);
                }
            }
        }
        return censusList;
    }

    //to know top batting averages of the cricketers
    public String getBattingAvrageSortedCricketersData() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.avg);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(cricketDataComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

    //to know the top striking rates of the batsman
    public String getStrikingRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.sr);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(cricketDataComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

    //to know cricketers who hit maximum 6s and 4s
    public String getMax4sAnd6sSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.fours * 4 + cricket.sixes * 6);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(cricketDataComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

    //to know cricketers who had best striking rates with 6s and 4s
    public String getMax4sAnd6sWithStrikeRatesSortedFactSheet()throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.sr);
        Comparator<CricketersDataDAO> fourAndSixComparator = Comparator.comparing(cricket -> cricket.fours * 4 + cricket.sixes * 6);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(fourAndSixComparator.thenComparing(cricketDataComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know which batsman had great avg with best strike rate possible
    public String getBattingAverageWithStrikeRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> avgRunComparator = Comparator.comparing(cricket -> cricket.avg);
        Comparator<CricketersDataDAO> strikeRateComparator = Comparator.comparing(cricket -> cricket.sr);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(strikeRateComparator.thenComparing(avgRunComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know who hits maximum runs with best avg
    public String getBestRunsWithBattingAverageSortedFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> avgRunComparator = Comparator.comparing(cricket -> cricket.avg);
        Comparator<CricketersDataDAO> strikeRateComparator = Comparator.comparing(cricket -> cricket.runs);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(strikeRateComparator.thenComparing(avgRunComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }
    public String getBestBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException{
        Comparator<CricketersDataDAO> bowlingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.avg);
        List<CricketersDataDAO> factSheetDAO = map.values().stream()
                .collect(Collectors.toList());
        factSheetDAO = descendingSort( bowlingAvgComparator,factSheetDAO);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }
}
