package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    Ticket one = new Ticket(1, 100, "DMD", "LTE", 200);
    Ticket two = new Ticket(2, 200, "VNK", "RGA", 400);
    Ticket three = new Ticket(3, 300, "SKS", "RTH", 300);
    TicketRepository repo = new TicketRepository();

    @Test
    void save() {
        repo.save(one);
        repo.save(three);
        Ticket[] expected = {one, three};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void removeById() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        Ticket[] expected = {one, three};
        repo.removeById(2);
        Ticket[] actual = repo.findAll();
        assertArrayEquals(actual, expected);
    }


}