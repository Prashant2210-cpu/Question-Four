package base;

import util.ReadConfig;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getAPIBaseUrl();
    public String resource = readConfig.getAPIResource();
}
