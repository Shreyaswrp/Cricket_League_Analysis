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




}
