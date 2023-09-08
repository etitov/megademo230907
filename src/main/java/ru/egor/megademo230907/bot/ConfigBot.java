package ru.egor.megademo230907.bot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "bot")
@ConfigurationPropertiesScan
public class ConfigBot {
    private String name;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        if (!token.contains(":"))
            throw new RuntimeException("set bot.token in application.properties");

        this.token = token;
    }
}
