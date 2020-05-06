package club.hand13.cfg;

public class TomcatConfig {
    private String tomcatPath;
    private String webappPath;
    private String javaHome;
    private String port;
    private String debugPort;

    public TomcatConfig() {
        this.setJavaHome(System.getenv("JAVA_HOME"));
        this.setCatalinaOptions("-server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=127.0.0.1:7777");
        this.setPort("8080");
        this.setDebugPort("55555");
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getCatalinaOptions() {
        return catalinaOptions;
    }

    public void setCatalinaOptions(String catalinaOptions) {
        this.catalinaOptions = catalinaOptions;
    }

    private String catalinaOptions;

    public String getTomcatPath() {
        return tomcatPath;
    }

    public void setTomcatPath(String tomcatPath) {
        this.tomcatPath = tomcatPath;
    }

    public String getWebappPath() {
        return webappPath;
    }

    public void setWebappPath(String webappPath) {
        this.webappPath = webappPath;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDebugPort() {
        return debugPort;
    }

    public void setDebugPort(String debugPort) {
        this.debugPort = debugPort;
    }
}
