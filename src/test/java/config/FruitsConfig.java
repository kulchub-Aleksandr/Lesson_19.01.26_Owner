package config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("array")
    String[] getFruitsArray();

    @Key("array-with-default-values")
    @DefaultValue("orange,apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String> getFruitsList();

    @Separator(";")
    @Key("list-with-separator")
    @DefaultValue("orange;banana")
    List<String> getFruitsListWithSeparator();
}
