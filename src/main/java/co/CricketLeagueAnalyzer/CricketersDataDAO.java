package co.CricketLeagueAnalyzer;

public class CricketersDataDAO {

    public String player;
    public int matches;
    public int runs;
    public double avg;
    public int inns;
    public int wkts;

    public CricketersDataDAO(IPL2019FactsheetMostRunsCSV mostRunsCSV) {
        player = mostRunsCSV.player;
        matches = mostRunsCSV.matches;
        runs = mostRunsCSV.runs;
        avg = mostRunsCSV.avg;
        inns = mostRunsCSV.inns;
    }

    public CricketersDataDAO(IPL2019FactsheetMostWktsCSV mostWktsCSV) {
        player = mostWktsCSV.player;
        matches = mostWktsCSV.matches;
        wkts = mostWktsCSV.wkts;
        avg = mostWktsCSV.avg;
        inns = mostWktsCSV.inns;
    }
}
