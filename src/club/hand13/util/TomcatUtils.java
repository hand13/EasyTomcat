package club.hand13.util;

import club.hand13.cfg.TomcatConfig;
import com.intellij.execution.configurations.GeneralCommandLine;

public class TomcatUtils {
    public static GeneralCommandLine getTomcatCommandLine(TomcatConfig tomcatConfig, boolean debug) {
        GeneralCommandLine commandLine = new GeneralCommandLine();
        String startPath = tomcatConfig.getTomcatPath() + "\\bin\\catalina.bat";
        commandLine
                .withExePath(startPath)
                .withEnvironment("JAVA_HOME", tomcatConfig.getJavaHome())
                .withEnvironment("CATALINA_HOME", tomcatConfig.getTomcatPath())
                .withEnvironment("CATALINA_BASE", tomcatConfig.getWebappPath());
        if (debug) {
            commandLine.withEnvironment("CATALINA_OPTS", tomcatConfig.getCatalinaOptions());
        }
        commandLine.addParameter("run");
        return commandLine;
    }
}
