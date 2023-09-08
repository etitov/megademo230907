package ru.egor.megademo230907.db;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class FakeDB {

    private CopyOnWriteArrayList<BotMessage> list = new CopyOnWriteArrayList<>();

    public void add(String name, String message) {
        list.add(new BotMessage(name, message));
    }

    public List<BotMessage> all() {
        return list;
    }
}
