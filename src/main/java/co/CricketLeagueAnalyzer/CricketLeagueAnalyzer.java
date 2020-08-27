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
        map = new CricketersDataLoader().loadFactSheetData(IPL2019FactsheetMostRunsCSV.class,csvFilePath);
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
        Comparator<CricketersDataDAO> censusComparator = Comparator.comparing(cricket -> cricket.avg);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(censusComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

    //to know the top striking rates of the batsman
    public String getStrikingRatesSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> censusComparator = Comparator.comparing(cricket -> cricket.sr);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(censusComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

    public String getMax4sAnd6sSortedFactSheet() throws CricketLeagueAnalyserException {
        if (map == null || map.size() == 0) {
            throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
        }
        Comparator<CricketersDataDAO> cricketDataComparator = Comparator.comparing(cricket -> cricket.fours * 4 + cricket.sixes * 6);
        List<CricketersDataDAO> cricketersDataDAOList = map.values().stream().collect(Collectors.toList());
        cricketersDataDAOList = descendingSort(cricketDataComparator, cricketersDataDAOList);
        return new Gson().toJson(cricketersDataDAOList);
    }

}
