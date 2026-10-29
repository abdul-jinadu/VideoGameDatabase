import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameAPI {

    private static final String DATABASE_URL =
            "jdbc:sqlite:database/games.db";

    public GameAPI() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS games ("
                + "id INTEGER PRIMARY KEY, "
                + "title TEXT NOT NULL, "
                + "genre TEXT NOT NULL, "
                + "platform TEXT NOT NULL, "
                + "release_year INTEGER NOT NULL)";

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public List<Game> getAllGames() throws SQLException {
        String sql = "SELECT * FROM games ORDER BY title";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            return readGames(results);
        }
    }

    public Game getGameById(int id) throws SQLException {
        String sql = "SELECT * FROM games WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    return readGame(results);
                }
                return null;
            }
        }
    }

    public List<Game> getGamesByGenre(String genre)
            throws SQLException {

        String sql = "SELECT * FROM games "
                + "WHERE LOWER(genre) = LOWER(?) ORDER BY title";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, genre.trim());

            try (ResultSet results = statement.executeQuery()) {
                return readGames(results);
            }
        }
    }

    public List<Game> getGamesByPlatform(String platform)
            throws SQLException {

        String sql = "SELECT * FROM games "
                + "WHERE LOWER(platform) = LOWER(?) ORDER BY title";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, platform.trim());

            try (ResultSet results = statement.executeQuery()) {
                return readGames(results);
            }
        }
    }

    public List<Game> getGamesReleasedAfter(int year)
            throws SQLException {

        String sql = "SELECT * FROM games "
                + "WHERE release_year > ? "
                + "ORDER BY release_year, title";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, year);

            try (ResultSet results = statement.executeQuery()) {
                return readGames(results);
            }
        }
    }
   
    private List<Game> readGames(ResultSet results)
            throws SQLException {

        List<Game> games = new ArrayList<>();

        while (results.next()) {
            games.add(readGame(results));
        }

        return games;
    }

    private Game readGame(ResultSet results)
            throws SQLException {

        return new Game(
                results.getInt("id"),
                results.getString("title"),
                results.getString("genre"),
                results.getString("platform"),
                results.getInt("release_year")
        );
    }
}