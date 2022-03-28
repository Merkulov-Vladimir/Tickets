package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Ticket one = new Ticket(1, 100, "VNK", "LTE", 200);
    Ticket two = new Ticket(2, 500, "VNK", "RGA", 400); // 4
    Ticket three = new Ticket(3, 300, "SKS", "RTH", 300);
    Ticket four = new Ticket(4, 300, "VNK", "RGA", 120); // 2
    Ticket fife = new Ticket(5, 300, "DMD", "LTE", 300);
    Ticket six = new Ticket(6, 100, "VNK", "RGA", 800); // 1
    Ticket seven = new Ticket(7, 400, "DMD", "LTE", 800);
    Ticket eight = new Ticket(8, 300, "VNK", "RGA", 400); // 3
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket ticket = new Ticket();

    @Test
    void findAll() {
        repository.save(one);
        repository.save(two); // must be 4, price 500
        repository.save(three);
        repository.save(four); // must be 2, price 300
        repository.save(fife);
        repository.save(six); // must be 1, price 100
        repository.save(seven);
        repository.save(eight);// must be 3, price 300
        Ticket[] expected = {six, four, eight, two};
        Ticket[] actual = manager.findAll("VNK", "RGA");
        assertArrayEquals(actual, expected);
    }

    @Test
    void FindAllForFast() {
        repository.save(one);
        repository.save(two); // must be 2, time 400
        repository.save(three);
        repository.save(four); // must be 1, time 120
        repository.save(fife);
        repository.save(six); // must be 4, time 800
        repository.save(seven);
        repository.save(eight); // must be 3, time 400
        Ticket[] expected = {four, two, eight, six};
        Ticket[] actual = manager.findAll("VNK", "RGA", ticket);
        assertArrayEquals(actual, expected);
    }
}
