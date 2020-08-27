package co.CricketLeagueAnalyzer;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyzerTest {

    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPLMOSTRUNS.csv";
    private static final String IPL_MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/wicket.csv";

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAvrageSortedCricketersData();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].player);
    }


    @Test
    public void givenMostRunFactSheet_WhenShortedOnStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getStrikingRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4s_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4sWithStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sWithStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverageWithBestStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAverageWithStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsWithBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BATSMEN, IPL_MOST_RUNS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithBattingAverageSortedFactSheet();
        IPL2019FactsheetMostRunsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostRunsCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithBattingAverageSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Umesh Yadav", iplMostWktsCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlerStrikeRate_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestBowlerStrikeRateSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWktsCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestEconomyRate_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestEconomyRateSortedForBowlersFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Ben Cutting", iplMostRunCSV[0].player);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestStrikeRateWith4wAnd5w_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestStrikeRateWith4wAnd5wSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Lasith Malinga", iplMostRunCSV[0].player);
    }
    @Test
    public void givenMostRunFactSheet_WhenShortedOnBowlingAverageWithBestStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyzer cricketLeagueAnalyser = new CricketLeagueAnalyzer();
        cricketLeagueAnalyser.loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType.BOWLER, IPL_MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBowlingAverageWithBestStrikeRatesSortedFactSheet();
        IPL2019FactsheetMostWktsCSV[] iplMostWktsCSV =  new Gson().fromJson(sortedFactSheetData, IPL2019FactsheetMostWktsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWktsCSV[0].player);
    }
}
