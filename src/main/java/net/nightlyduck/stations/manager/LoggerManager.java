package net.nightlyduck.stations.manager;

import net.nightlyduck.stations.StationsApplication;
import org.tinylog.Logger;

public class LoggerManager {
    private final StationsApplication application = StationsApplication.getApplication();

    public void info(String message) {
        Logger.info(message);
    }

    public void debug(String message) {
        if (application.debugEnabled()) Logger.warn(message);
    }
}
