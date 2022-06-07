package net.nightlyduck.stations.manager;

import lombok.SneakyThrows;

import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private ConfigurationNode rootNode;
    private ConfigurationNode webserverNode;
    private ConfigurationNode storageNode;

    @SneakyThrows
    public ConfigManager() {
        var configFile = Path.of("application.conf");
        var resource = getClass().getResourceAsStream("/application.conf");

        if (resource == null) {
            return;
        }

        if (Files.notExists(configFile)) {
            Files.copy(resource, configFile);
        }

        var loader = HoconConfigurationLoader.builder().path(configFile).build();
        this.rootNode = loader.load().node("configuration");

        this.webserverNode = rootNode.node("webserver");
        this.storageNode = rootNode.node("storage");
    }

    public boolean debugEnabled() {
        return rootNode.node("debug-enabled").getBoolean();
    }

    public String webserverHost() {
        return webserverNode.node("webserver-host").getString();
    }

    public int webserverPort() {
        return webserverNode.node("webserver-port").getInt();
    }

}
