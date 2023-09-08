package ru.egor.megademo230907.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.egor.megademo230907.db.FakeDB;

@Component
public class HelloBot extends TelegramLongPollingBot {
    private FakeDB fakeDB;
    private String name;
    @Autowired
    public HelloBot(FakeDB fakeDB, ConfigBot config) {
        super(config.getToken());
        this.fakeDB = fakeDB;
        this.name = config.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());


            String name = update.getMessage().getChat().getUserName();
            String msg = update.getMessage().getText();

            System.out.println(name + " " + msg);

            message.setText(msg);

            fakeDB.add(name, msg);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public String getBotUsername() {
        return this.name;
    }
}
