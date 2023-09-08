package ru.egor.megademo230907.db;

public class BotMessage {

    private String user;
    private String message;

    public BotMessage() {
    }

    public BotMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public BotMessage setUser(String user) {
        this.user = user;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BotMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
