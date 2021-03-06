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

    //to know bowling avg of the cricketers
    public String getBestBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> bowlingAvgComparator = Comparator.comparing(leagueFact -> leagueFact.bowlingAvg);
        List<CricketersDataDAO> factSheetDAO = map.values().stream().collect(Collectors.toList());
        factSheetDAO = descendingSort( bowlingAvgComparator,factSheetDAO);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    //added to know bowlers who have top striking rates
    public String getBestBowlerStrikeRateSortedFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> bowlerStrikeRateComparator = Comparator.comparing(cricketFact -> cricketFact.sr);
        List<CricketersDataDAO> factSheetDAO = map.values().stream().collect(Collectors.toList());
        this.descendingSort( bowlerStrikeRateComparator,factSheetDAO);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    //added to know economy rates of the best bowlers
    public String getBestEconomyRateSortedForBowlersFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> ecoRateComparator = Comparator.comparing(leagueFact -> leagueFact.economyRate);
        List<CricketersDataDAO> factSheetDAO = map.values().stream().collect(Collectors.toList());
        factSheetDAO = descendingSort( ecoRateComparator,factSheetDAO);
        String sortedFactSheetJson = new Gson().toJson(factSheetDAO);
        return sortedFactSheetJson;
    }

    //added to know cricketers who had best striking rates with 4W and 5W
    public String getBestStrikeRateWith4wAnd5wSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> bowlerStrikeRateComparator = Comparator.comparing(cricketFact -> cricketFact.sr);
        Comparator<CricketersDataDAO> w4AndW5Comparator = Comparator.comparing(cricket -> cricket.fourWkts * 4 + cricket.fiveWkts * 5);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(w4AndW5Comparator.thenComparing(bowlerStrikeRateComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //added to know bowling avg with best strike rates
    public String getBowlingAverageWithBestStrikeRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> avgRunComparator = Comparator.comparing(cricket -> cricket.bowlingAvg);
        Comparator<CricketersDataDAO> strikeRateComparator = Comparator.comparing(cricket -> cricket.sr);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(strikeRateComparator.thenComparing(avgRunComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know who took maximum wickets and who has best avg
    public String getMaxWktsWithBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> avgWktsComparator = Comparator.comparing(cricket -> cricket.bowlingAvg);
        Comparator<CricketersDataDAO> wicketComparator = Comparator.comparing(cricket -> cricket.wkts);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(wicketComparator.thenComparing(avgWktsComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know cricketers who had best bowling avg and best batting avg
    public String getMaxBattingBowlingAverageSortedFactSheet() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> avgWktsComparator = Comparator.comparing(cricket -> cricket.bowlingAvg);
        Comparator<CricketersDataDAO> avgRunsComparator = Comparator.comparing(cricket -> cricket.avg);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(avgRunsComparator.thenComparing(avgWktsComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know cricketers who are all rounders
    public String getAllRounderCricketers() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> WktsComparator = Comparator.comparing(cricket -> cricket.wkts);
        Comparator<CricketersDataDAO> RunsComparator = Comparator.comparing(cricket -> cricket.runs);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(RunsComparator.thenComparing(WktsComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //to know who hit maximum hundreds and had best avgs
    public String getMaximumHundredWithAvgSorted() throws CricketLeagueAnalyserException{
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> hundredComparator = Comparator.comparing(cricket -> cricket.hundred);
        Comparator<CricketersDataDAO> avgComparator = Comparator.comparing(cricket -> cricket.avg);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(hundredComparator .thenComparing(avgComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }

    //added to know cricketers who hit zero 100 and 50 with best batting avg
    public String getBestBattingAvgWithZero100And50SortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> battingAvgComparator = Comparator.comparing(cricketFact -> cricketFact.avg);
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.hundred * 100 + cricket.fifty * 50 == 0);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(cricketDataComparator.thenComparing(battingAvgComparator),cricketersDataDAOList);
        String sortedFactSheetJson = new Gson().toJson(cricketersDataDAOList);
        return sortedFactSheetJson;
    }
}
