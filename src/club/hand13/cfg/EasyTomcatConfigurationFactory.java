package club.hand13.cfg;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class EasyTomcatConfigurationFactory extends ConfigurationFactory {
    public EasyTomcatConfigurationFactory(ConfigurationType configurationType) {
        super(configurationType);
    }
    private final String ID = "Easy Tomcat Configuration Factory";

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new EasyTomcatRunConfiguration(project,this,"run me");
    }

    @NotNull
    @Override
    public String getId() {
        return ID;
    }
}
