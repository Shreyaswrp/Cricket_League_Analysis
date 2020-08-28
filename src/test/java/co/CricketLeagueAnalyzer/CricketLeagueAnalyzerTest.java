package co.CricketLeagueAnalyzer;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyzerTest {

    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPLMOSTRUNS.csv";
    private static final String IPL_MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/wicket.csv";

    @Test
    public void givenMostRunFactSheet_WhenSortedOnBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAvrageSortedCricketersData();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].player);
    }


    @Test
    public void givenMostRunFactSheet_WhenSortedOnStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getStrikingRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnMaximum6sAnd4s_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenSortedOnMaximum6sAnd4sWithStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sWithStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnBattingAverageWithBestStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAverageWithStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnRunsWithBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithBattingAverageSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].player);
    }

    @Test
    public void givenMostWktsFactSheet_WhenSortedOnBowlingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithBattingAverageSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Umesh Yadav", iplMostWktsCSV[0].player);
    }
    @Test
    public void givenMostWktsFactSheet_WhenSortedOnBowlerStrikeRate_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestBowlerStrikeRateSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWktsCSV[0].player);
    }

    @Test
    public void givenMostWktsFactSheet_WhenSortedOnEconomyRate_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestEconomyRateSortedForBowlersFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Ben Cutting", iplMostWktsCSV[0].player);
    }
    @Test
    public void givenMostWktsFactSheet_WhenSortedOnStrikeRateWith4wAnd5w_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestStrikeRateWith4wAnd5wSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Lasith Malinga", iplMostWktsCSV[0].player);
    }
    @Test
    public void givenMostWktsFactSheet_WhenSortedOnBowlingAverageWithBestStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBowlingAverageWithBestStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWktsCSV[0].player);
    }
    @Test
    public void givenMostWktsFactSheet_WhenSortedOnWicketsWithBowlingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMaxWktsWithBowlingAverageSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Imran Tahir", iplMostWktsCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenSortedOnBattingAndBowlingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMaxBattingBowlingAverageSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnRunsAndWkts_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getAllRounderCricketers();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnCenturyAndAvg_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMaximumHundredWithAvgSorted();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenSortedOnHundredAnd50WithAvg_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestBattingAvgWithZero100And50SortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Shimron Hetmyer", iplMostRunCSV[0].player);
    }
}
