package co.CricketLeagueAnalyzer;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyzerTest {

    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPLMOSTRUNS.csv";

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



}
