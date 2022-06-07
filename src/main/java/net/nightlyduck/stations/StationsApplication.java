package net.nightlyduck.stations;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import lombok.Getter;

import net.nightlyduck.stations.logic.WebLogic;
import net.nightlyduck.stations.manager.ConfigManager;
import net.nightlyduck.stations.manager.LoggerManager;

public class StationsApplication {
    @Getter private static StationsApplication application;

    @Getter private final ConfigManager configManager;
    @Getter private final LoggerManager loggerManager;

    @Getter private Javalin javalinServer;
    @Getter private WebLogic webLogic;

    public StationsApplication() {
        application = this;

        this.configManager = new ConfigManager();
        this.loggerManager = new LoggerManager();
    }

    public void start() {
        this.javalinServer = Javalin.create(javalinConfig ->
                javalinConfig.addStaticFiles("web-resources", Location.CLASSPATH))
                .start(configManager.webserverHost(), configManager.webserverPort());

        this.webLogic = new WebLogic();
        this.webLogic.applyRedirect();
    }

    public boolean debugEnabled() {
        return configManager.debugEnabled();
    }
}
