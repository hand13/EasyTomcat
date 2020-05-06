package club.hand13.cfg;

import club.hand13.util.TomcatUtils;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class TomcatRunnerState extends CommandLineState {

    private TomcatConfig tomcatConfig;

    protected TomcatRunnerState(ExecutionEnvironment environment,EasyTomcatRunConfiguration runConfiguration) {
        super(environment);
        tomcatConfig = runConfiguration.getTomcatConfig();
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = TomcatUtils.getTomcatCommandLine(tomcatConfig,false);
        OSProcessHandler handler = new OSProcessHandler(commandLine);
        handler.startNotify();
        return handler;
    }
}
