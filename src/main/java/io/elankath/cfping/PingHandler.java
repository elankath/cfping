package io.elankath.cfping;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PingHandler extends RouterNanoHTTPD.DefaultHandler {

    @Override
    public String getText() {
        return "Not Used";
    }

    @Override
    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        final StringWriter sw = new StringWriter(16 * 1024);
        final PrintWriter out = new PrintWriter(sw);
        final Runtime r = Runtime.getRuntime();
        out.println("--- PING ");
        try {
            out.println("Host=" + InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace(out);
        }
        out.println("--- JVM RUNTIME INFO ");
        out.println("FreeMemory=" + r.freeMemory());
        out.println("MaxMemory=" + r.maxMemory());
        out.println("TotalMemory=" + r.totalMemory());
        out.println("AvailableProcessors="+ r.availableProcessors());
        final Path memStat = Paths.get("/sys/fs/cgroup/memory/memory.stat");
        if (Files.exists(memStat)) {
            out.println("--- CONTAINER MEMORY INFO");
            try {
                Files.readAllLines(memStat).forEach(out::println);
            } catch (final IOException e) {
                out.println("Error reading: " + memStat);
                e.printStackTrace(out);
            }
        }
        out.println("--- ENVIRONMENT VARIABLES");
        System.getenv().forEach((k, v) -> out.println(k + "=" + v));
        out.flush();
        return NanoHTTPD.newFixedLengthResponse(this.getStatus(), this.getMimeType(), sw.toString());
    }

    @Override
    public String getMimeType() {
        return "text/plain";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }
}
