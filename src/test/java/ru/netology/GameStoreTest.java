package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();
    Game game1 = store.publishGame("Гонки", "онлайн");
    Game game2 = store.publishGame("Стрелялка", "Бой");
    Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game4 = store.publishGame("Паб", "Симулятор");
    Game game5 = store.publishGame("Майнкрафт", "Стратегия");

    @Test
    public void shouldAddGameTrue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldNOGameFalse() {

        GameStore store = new GameStore();
        Game game6 = new GameStore().publishGame("Рыбы", "Открытый мир");

        assertFalse(store.containsGame(game6));
    }

    @Test
    public void addGame() {

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertTrue(store.containsGame(game5));
        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldTimeGame() {

        GameStore store = new GameStore();


        store.addPlayTime("Коля", 5);
        store.addPlayTime("Коля", 12);
        store.addPlayTime("Коля", 8);
        store.addPlayTime("Таня", 10);

        int expected = 35;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Коля", 10);
        store.addPlayTime("Коля", 30);
        store.addPlayTime("Вася", 70);

        String expected = "Вася";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostSumPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Коля", 10);
        store.addPlayTime("Коля", 30);
        store.addPlayTime("Вася", 20);

        String expected = "Коля";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

}
