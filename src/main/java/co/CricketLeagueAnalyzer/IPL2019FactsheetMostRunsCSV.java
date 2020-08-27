package co.CricketLeagueAnalyzer;

import com.opencsv.bean.CsvBindByName;
public class IPL2019FactsheetMostRunsCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @CsvBindByName(column = "100", required = true)
    public int hundred;
}
