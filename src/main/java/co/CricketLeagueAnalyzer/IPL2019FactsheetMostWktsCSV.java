package co.CricketLeagueAnalyzer;

import com.opencsv.bean.CsvBindByName;
public class IPL2019FactsheetMostWktsCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Avg", required = true)
    public double bowlingAvg;

    @CsvBindByName(column = "Wkts", required = true)
    public int wkts;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "4w", required = true)
    public int fourWkts;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWkts;
    @CsvBindByName(column = "Econ", required = true)
    public double economyRate;
}
