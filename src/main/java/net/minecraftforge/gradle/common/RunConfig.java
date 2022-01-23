package net.minecraftforge.gradle.common;

import groovy.lang.GroovyObjectSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RunConfig extends GroovyObjectSupport {
    private final List<String> args = new ArrayList<>();
    private final List<String> jvmArgs = new ArrayList<>();

    public void args(Object... values) {
        args(Arrays.asList(values));
    }

    public void jvmArgs(Object... values) {
        jvmArgs(Arrays.asList(values));
    }

    public void args(List<Object> values) {
        List<String> args = values.stream().map(Object::toString).collect(Collectors.toList());
        addArgs(args);
    }

    public void jvmArgs(List<Object> values) {
        List<String> args = values.stream().map(Object::toString).collect(Collectors.toList());
        addJvmArgs(args);
    }

    private void addArgs(List<String> values) {
        values.forEach(value -> getArgs().add(Objects.toString(value)));
    }

    public List<String> getArgs() {
        return args;
    }

    private void addJvmArgs(List<String> values) {
        getJvmArgs().addAll(values);
    }

    public List<String> getJvmArgs() {
        return jvmArgs;
    }
}
