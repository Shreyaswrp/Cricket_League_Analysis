package co.CricketLeagueAnalyzer;

public class CricketLeagueAnalyserException extends Exception {

    public enum ExceptionType {
        FILE_TYPE_PROBLEM,WRONG_HEADER,NO_CRICKET_DATA
    }

    public ExceptionType type;

    public CricketLeagueAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CricketLeagueAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketLeagueAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
