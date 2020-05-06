package club.hand13.cfg;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import icons.EasyTomcatIcons;

public class TomcatConfiguration extends ConfigurationTypeBase {

    public TomcatConfiguration() {
        super("com.hand13.cfg.type", "Easy tomcat", "Run Tomcat", EasyTomcatIcons.CONFIGURATION_ICON);
        this.addFactory(new EasyTomcatConfigurationFactory(this));
    }

}
