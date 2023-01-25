package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
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

    @Test /*при любых условиях выходит null, а должно выходить название игры*/
    public void shouldGetGameGenreWithMoreTimeAndNotInstallGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Исследование планет", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game1);
        player.play(game1, 3);

        player.installGame(game2);
        player.play(game2, 5);

        assertEquals("Исследование планет", player.mostPlayerByGenre("Аркады"));

    }

    @Test /*при использовании невалидного значения, должен выходить 0*/
    public void shouldSumGenreIfNotValidAndNotInstallGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, -5);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test /*не суммируется время, если игрок играет в одну игру несколько раз */
    public void shouldSumGenreIfOneGameManyTimes() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 4);
        player.play(game, 3);

        int expected = 7;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test /*игра не установлена у игрока, но время посчиталось, а должно выходить RuntimeException*/
    public void shouldSumGenreIfManyGame2AndNotInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> player.play(game, 2));

    }
}
