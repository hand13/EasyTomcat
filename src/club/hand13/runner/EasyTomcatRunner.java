package club.hand13.runner;

import club.hand13.cfg.EasyTomcatRunConfiguration;
import club.hand13.cfg.TomcatConfig;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.runners.DefaultProgramRunner;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyTomcatRunner extends DefaultProgramRunner {
    private String ID = "Easy Tomcat Runner";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
        TomcatConfig tomcatConfig = ((EasyTomcatRunConfiguration) runProfile).getTomcatConfig();
        if(StringUtils.isBlank(tomcatConfig.getCatalinaOptions())) {
            logger.warn("options1 不得为空");
            return false;
        }
        if(StringUtils.isBlank(tomcatConfig.getJavaHome())) {
            logger.warn("options2 不得为空");
            return false;
        }
        if(StringUtils.isBlank(tomcatConfig.getTomcatPath())) {
            logger.warn("options3 不得为空");
            return false;
        }
        if(StringUtils.isBlank(tomcatConfig.getWebappPath())) {
            logger.warn("options4 不得为空");
            return false;
        }
        return true;
    }

}
