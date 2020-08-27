package co.CricketLeagueAnalyzer;

public class CricketersDataDAO {

    public String player;
    public int matches;
    public int runs;
    public double avg;
    public int inns;
    public int wkts;
    public double sr;
    public int fours;
    public int sixes;
    public int fiveWkts;
    public int fourWkts;


    public CricketersDataDAO(IPL2019FactsheetMostRunsCSV mostRunsCSV) {
        player = mostRunsCSV.player;
        matches = mostRunsCSV.matches;
        runs = mostRunsCSV.runs;
        avg = mostRunsCSV.avg;
        inns = mostRunsCSV.inns;
        sr = mostRunsCSV.sr;
        fours = mostRunsCSV.fours;
        sixes = mostRunsCSV.sixes;
    }

    public CricketersDataDAO(IPL2019FactsheetMostWktsCSV mostWktsCSV) {
        player = mostWktsCSV.player;
        matches = mostWktsCSV.matches;
        wkts = mostWktsCSV.wkts;
        avg = mostWktsCSV.avg;
        inns = mostWktsCSV.inns;
        sr = mostWktsCSV.sr;
        fourWkts = mostWktsCSV.fourWkts;
        fiveWkts = mostWktsCSV.fiveWkts;
    }
}
