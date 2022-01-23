package net.minecraftforge.gradle.common;

import groovy.lang.GroovyObjectSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunConfig extends GroovyObjectSupport {
    private final List<String> args = new ArrayList<>();
    private final List<String> jvmArgs = new ArrayList<>();

    public void args(List<String> values) {
        setArgs(values);
    }

    public void args(String... values) {
        args(Arrays.asList(values));
    }

    public void jvmArgs(List<String> values) {
        setJvmArgs(values);
    }

    public void jvmArgs(String... values) {
        jvmArgs(Arrays.asList(values));
    }

    private void setArgs(List<String> values) {
        values.forEach(value -> getArgs().add(Objects.toString(value)));
    }

    public List<String> getArgs() {
        return args;
    }

    private void setJvmArgs(List<String> values) {
        getJvmArgs().addAll(values);
    }

    public List<String> getJvmArgs() {
        return jvmArgs;
    }
}
