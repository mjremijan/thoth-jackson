package org.thoth.jackson.chapter;

import java.util.List;

public class Chapter {

    protected List<Scripture> scripture;

    public List<Scripture> getScripture() {
        return scripture;
    }

    public void setScripture(List<Scripture> scripture) {
        this.scripture = scripture;
    }

    @Override
    public String toString() {

        StringBuilder sp = new StringBuilder();

        sp.append("{").append(getClass().getSimpleName()).append(":\n");
        sp.append("  scripture=[").append("\n");
        sp.append(
            scripture.stream()
                .map(s -> s.toString(4))
                .reduce((t, v) -> t + "," + v)
                .get()
        ).append("\n");
        sp.append("  ]").append("\n");
        sp.append("}");

        return sp.toString();
    }
}
