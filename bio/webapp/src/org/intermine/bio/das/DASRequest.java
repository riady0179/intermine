package org.intermine.bio.das;

import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class DASRequest extends AbstractMap<String, String>
{
    private String dataSource, command;
    private Set<Entry<String, String>> arguments = new HashSet<Entry<String, String>>();

    DASRequest() {
        // default scope constructor.
    }

    DASRequest(Map<String, String> mappings) {
        for (Entry<String, String> pair: mappings.entrySet()) {
            addArgument(pair.getKey(), pair.getValue());
        }
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getCommand() {
        return command;
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return new HashSet<Map.Entry<String, String>>(arguments);
    }

    void setCommand(String command) {
        this.command = command;
    }

    void setDataSource(String src) {
        this.dataSource = src;
    }

    void addArgument(String name, String value) {
        arguments.add(new AbstractMap.SimpleImmutableEntry(name, value));
    }

}
