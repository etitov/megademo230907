package ru.egor.megademo230907;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.egor.megademo230907.bot.ConfigBot;

@SpringBootApplication
@EnableConfigurationProperties(ConfigBot.class)
public class Megademo230907Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Megademo230907Application.class, args);

		try {
			TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
			api.registerBot(context.getBean("helloBot", TelegramLongPollingBot.class));
		} catch (TelegramApiException e) {
			throw new RuntimeException(e);
		}
	}

}
