package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket>, Comparator<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(Ticket ticket) {
        return this.price - ticket.price;
    }

    @Override
    public int compare(Ticket o1, Ticket o2) {
        {
            return o1.getTime() - o2.getTime();
        }
    }
}
