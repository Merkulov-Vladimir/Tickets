package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;


public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = searchAirport(from, to);
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = searchAirport(from, to);
        Arrays.sort(result, comparator);
        return result;
    }

    public Ticket[] searchAirport(String from, String to) {
        Ticket[] result = new Ticket[0]; // массив для хранения, подошедших запросу билетов
        int index = 0;
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp; // "добавляем в конец" массива result нужный билет
            }
        }
        return result;
    }
}


