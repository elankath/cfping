package io.elankath.cfping;

import fi.iki.elonen.router.RouterNanoHTTPD;
import fi.iki.elonen.util.ServerRunner;

public class PingApp  extends RouterNanoHTTPD {
    public static final int PORT = 8080;

    public PingApp() {
        super(PORT);
        addMappings();
        System.out.println("\nRunning at http://localhost:" + PORT + "/ \n");
    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/", PingHandler.class);
    }

    public static void main(String[] args) {
        ServerRunner.run(PingApp.class);
    }
}
