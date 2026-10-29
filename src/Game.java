public class Game {
    private int id;
    private String title;
    private String genre;
    private String platform;
    private int releaseYear;

    public Game(int id, String title, String genre,
                String platform, int releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return id + ". " + title
                + " | Genre: " + genre
                + " | Platform: " + platform
                + " | Year: " + releaseYear;
    }
}