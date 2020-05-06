package club.hand13.cfg;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class TomcatSettingEditor extends SettingsEditor<EasyTomcatRunConfiguration> {

    private TomcatConfig tomcatConfig;
    private JPanel mainPanel;
    private JLabel title;
    private JTextField artifactPath;
    private JTextField tomcatPath;
    private JTextField javaHome;
    private JTextField javaOpts;
    private JTextField debugPort;
    private JTextField port;


    public TomcatSettingEditor() {
        tomcatConfig = new TomcatConfig();
    }

    private void initUI() {
        title.setText("Configuration");
        this.resetUIFromConfig();
    }


    @Override
    protected void resetEditorFrom(@NotNull EasyTomcatRunConfiguration easyTomcatRunConfiguration) {
        this.tomcatConfig = easyTomcatRunConfiguration.getTomcatConfig();
        resetUIFromConfig();
    }


    @Override
    protected void applyEditorTo(@NotNull EasyTomcatRunConfiguration easyTomcatRunConfiguration) throws ConfigurationException {
        tomcatConfig.setTomcatPath(tomcatPath.getText());
        tomcatConfig.setWebappPath(artifactPath.getText());
        tomcatConfig.setJavaHome(javaHome.getText());
        tomcatConfig.setPort(port.getText());
        tomcatConfig.setDebugPort(port.getText());
        easyTomcatRunConfiguration.setTomcatConfig(tomcatConfig);
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        this.initUI();
        return this.mainPanel;
    }

    private void resetUIFromConfig() {
        this.artifactPath.setText(tomcatConfig.getWebappPath());
        this.tomcatPath.setText(tomcatConfig.getTomcatPath());
        this.javaHome.setText(tomcatConfig.getJavaHome());
        this.javaOpts.setText(tomcatConfig.getCatalinaOptions());
        this.port.setText(tomcatConfig.getPort());
        this.debugPort.setText(tomcatConfig.getDebugPort());
        this.javaOpts.setEditable(false);
    }
}
