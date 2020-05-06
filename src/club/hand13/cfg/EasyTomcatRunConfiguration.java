package club.hand13.cfg;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EasyTomcatRunConfiguration extends RunConfigurationBase {

    private TomcatConfig tomcatConfig;


    protected EasyTomcatRunConfiguration(@NotNull Project project, @Nullable ConfigurationFactory factory, @Nullable String name) {
        super(project, factory, name);
        tomcatConfig = new TomcatConfig();
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new TomcatSettingEditor();
    }


    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return new TomcatRunnerState(executionEnvironment,this);
    }


    @Override
    public void readExternal(@NotNull Element element) throws InvalidDataException {
        super.readExternal(element);
        XmlSerializer.deserializeInto(this,element);
    }

    @Override
    public void writeExternal(@NotNull Element element) {
        super.writeExternal(element);
        XmlSerializer.serializeInto(this,element);
    }

    public TomcatConfig getTomcatConfig(){
        return this.tomcatConfig;
    }

    public void setTomcatConfig(TomcatConfig tomcatConfig) {
        this.tomcatConfig = tomcatConfig;
    }
}
