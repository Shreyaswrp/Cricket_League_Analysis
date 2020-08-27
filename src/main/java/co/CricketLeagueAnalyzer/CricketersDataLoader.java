package co.CricketLeagueAnalyzer;

import CensusAnalyserJarDemo.CSVBuilderException;
import CensusAnalyserJarDemo.CSVBuilderFactory;
import CensusAnalyserJarDemo.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CricketersDataLoader {


    private <E> Map<String, CricketersDataDAO> loadFactSheetData(Class<E> factSheetCSVClass, String csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, CricketersDataDAO> map = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, factSheetCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (factSheetCSVClass.getName().equals("co.CricketLeagueAnalyzer.IPL2019FactsheetMostRunsCSV")){
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPL2019FactsheetMostRunsCSV.class::cast)
                        .forEach(cricketCSV -> map.put(cricketCSV.player, new CricketersDataDAO(cricketCSV)));
            } else if (factSheetCSVClass.getName().equals("co.CricketLeagueAnalyzer.IPL2019FactsheetMostWktsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPL2019FactsheetMostWktsCSV.class::cast)
                        .forEach(cricketCSV -> map.put(cricketCSV.player, new CricketersDataDAO(cricketCSV)));
            }
            return map;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FILE_TYPE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }


    public Map<String, CricketersDataDAO> loadLeagueFactSheet(CricketLeagueAnalyzer.PlayerType playerType, String csvFilePath) throws CricketLeagueAnalyserException {
        if (playerType.equals(CricketLeagueAnalyzer.PlayerType.BATSMEN)) {
            return this.loadFactSheetData(IPL2019FactsheetMostRunsCSV.class, csvFilePath);
        } else if (playerType.equals(CricketLeagueAnalyzer.PlayerType.BOWLER)) {
            return this.loadFactSheetData(IPL2019FactsheetMostWktsCSV.class, csvFilePath);
        } else throw new CricketLeagueAnalyserException("Incorrect Player Type",
                CricketLeagueAnalyserException.ExceptionType.INVALID_PLAYER_TYPE);

    }
}