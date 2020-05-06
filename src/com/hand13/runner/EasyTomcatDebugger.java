package com.hand13.runner;

import club.hand13.cfg.EasyTomcatRunConfiguration;
import com.intellij.debugger.impl.GenericDebuggerRunner;
import com.intellij.debugger.impl.GenericDebuggerRunnerSettings;
import com.intellij.execution.configurations.ConfigurationInfoProvider;
import com.intellij.execution.configurations.RunProfile;
import org.jetbrains.annotations.NotNull;

public class EasyTomcatDebugger extends GenericDebuggerRunner{
    private String ID = "Easy Tomcat Debugger";

    @NotNull
    @Override
    public String getRunnerId() {
        return ID;
    }

    @Override
    public boolean canRun(@NotNull String s, @NotNull RunProfile runProfile) {
        if(!(runProfile instanceof EasyTomcatRunConfiguration)) {
            return false;
        }
        return true;
    }

    @Override
    public GenericDebuggerRunnerSettings createConfigurationData(@NotNull ConfigurationInfoProvider settingsProvider) {
        return super.createConfigurationData(settingsProvider);
    }
}
