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


    public <E> Map<String, CricketersDataDAO> loadFactSheetData(Class<E> factSheetCSVClass, String csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, CricketersDataDAO> map = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, factSheetCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(IPL2019FactsheetMostRunsCSV.class::cast)
                    .forEach(cricketCSV -> map.put(cricketCSV.player, new CricketersDataDAO(cricketCSV)));
            return map;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FILE_TYPE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }

    }