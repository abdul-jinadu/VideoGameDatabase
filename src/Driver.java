import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            GameAPI api = new GameAPI();
            boolean running = true;

            System.out.println("====================================");
            System.out.println("       VIDEO GAME DATABASE");
            System.out.println("====================================");

            while (running) {

                System.out.println();
                System.out.println("1. Display all games");
                System.out.println("2. Find a game by ID");
                System.out.println("3. Search games by genre");
                System.out.println("4. Search games by platform");
                System.out.println("5. Find games released after a year");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                String choice = input.nextLine().trim();

                try {
                    switch (choice) {

                        case "1":
                            displayGames(api.getAllGames());
                            break;

                        case "2":
                            System.out.print("Enter game ID: ");
                            int id = Integer.parseInt(
                                    input.nextLine().trim());

                            Game game = api.getGameById(id);

                            if (game == null) {
                                System.out.println("Game not found.");
                            } else {
                                System.out.println(game);
                            }
                            break;

                        case "3":
                            System.out.print("Enter a genre: ");
                            String genre = input.nextLine();

                            displayGames(
                                    api.getGamesByGenre(genre));
                            break;

                        case "4":
                            System.out.print("Enter a platform: ");
                            String platform = input.nextLine();

                            displayGames(
                                    api.getGamesByPlatform(platform));
                            break;

                        case "5":
                            System.out.print("Enter a year: ");
                            int year = Integer.parseInt(
                                    input.nextLine().trim());

                            displayGames(
                                    api.getGamesReleasedAfter(year));
                            break;

                        case "6":
                            running = false;
                            System.out.println("Goodbye!");
                            break;

                        default:
                            System.out.println(
                                    "Please enter a number from 1 to 6.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Please enter a valid whole number.");

                } catch (SQLException e) {
                    System.out.println(
                            "Database error: " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Could not start the database: "
                            + e.getMessage());
            System.out.println(
                    "Check that the SQLite JDBC driver is configured.");
        }
    }

    private static void displayGames(List<Game> games) {

        if (games.isEmpty()) {
            System.out.println("No games found.");
            return;
        }

        for (Game game : games) {
            System.out.println(game);
        }
    }
}