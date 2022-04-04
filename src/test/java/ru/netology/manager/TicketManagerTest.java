package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Ticket one = new Ticket(1, 100, "DMD", "LTE", 200);
    Ticket two = new Ticket(2, 500, "VNK", "RGA", 400); // 4
    Ticket three = new Ticket(3, 300, "SKS", "RTH", 300);
    Ticket four = new Ticket(4, 300, "VNK", "RGA", 120); // 2
    Ticket fife = new Ticket(5, 300, "DMD", "LTE", 300);
    Ticket six = new Ticket(6, 100, "VNK", "RGA", 800); // 1
    Ticket seven = new Ticket(7, 400, "DMD", "LTE", 800);
    Ticket eight = new Ticket(8, 300, "VNK", "RGA", 400); // 3
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    @Test
    void findAll() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(fife);
        repository.save(six);
        repository.save(seven);
        repository.save(eight);
        Ticket[] expected = {six, four, eight, two};
        Ticket[] actual = manager.findAll("VNK", "RGA");
        assertArrayEquals(actual, expected);
    }
    @Test                           // один билет верный
    void findAllWhenOneCorrect() {
        repository.save(one);
        repository.save(two); // must be 4, price 500
        repository.save(three);
        repository.save(fife);
        repository.save(seven);
        Ticket[] expected = {two};
        Ticket[] actual = manager.findAll("VNK", "RGA");
        assertArrayEquals(actual, expected);
    }

    @Test                           //ожидаемый набор пустой
    void findAllWhenEmpty() {
        repository.save(one);
        repository.save(three);
        repository.save(fife);
        repository.save(seven);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VNK", "RGA");
        assertArrayEquals(actual, expected);
    }
}