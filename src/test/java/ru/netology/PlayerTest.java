package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private GameStore store = new GameStore();
    private Game mortalKombat = store.publishGame("Mortal Kombat X", "Fights");
    private Game injustice = store.publishGame("Injustice", "Fights");
    private Game rockNRollRacing = store.publishGame("Rock N Roll Racing", "Race");


    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void mostPlayerByGenreGamePlayed() {
        Player player = new Player("Ura");
        player.installGame(mortalKombat);
        player.installGame(injustice);
        player.installGame(rockNRollRacing);

        player.play(mortalKombat, 6);
        player.play(injustice, 5);
        player.play(rockNRollRacing, 3);


        Game expected = mortalKombat;
        Game actual = player.mostPlayerByGenre("Fights");

        assertEquals(expected, actual);
        }

    // другие ваши тесты
}
