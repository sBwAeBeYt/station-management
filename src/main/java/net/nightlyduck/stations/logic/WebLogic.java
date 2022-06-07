package net.nightlyduck.stations.logic;

import io.javalin.Javalin;
import net.nightlyduck.stations.StationsApplication;

public class WebLogic {
    private final StationsApplication application = StationsApplication.getApplication();
    private final Javalin javalin = application.getJavalinServer();

    public void applyRedirect() {
        javalin.routes(() -> {
            javalin.get("/", ctx -> ctx.redirect("/"));
            //javalin.get("/", ctx -> ctx.status(400));
        });
    }
}
