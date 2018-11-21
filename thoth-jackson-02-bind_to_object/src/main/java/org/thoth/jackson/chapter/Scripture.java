package org.thoth.jackson.chapter;

import java.util.Collections;
import java.util.List;

public class Scripture {

    protected List<Verse> verses;

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

    public String toString(int indent) {
        StringBuilder sp = new StringBuilder();
        String pad = Collections.nCopies(indent, " ").stream().reduce((t, u) -> t + u).get();

        sp.append(pad).append("{").append(getClass().getSimpleName()).append(":\n");
        sp.append(pad).append("  verses=[").append("\n");
        sp.append(
            verses.stream()
                .map(v -> toString(indent + 2, v))
                .reduce((t, u) -> t + ",\n" + u)
                .get()
        ).append("\n");
        sp.append(pad).append("  ]").append("\n");
        sp.append(pad).append("}");

        return sp.toString();
    }

    private String toString(int indent, Verse v) {
        StringBuilder sp = new StringBuilder();
        String pad = Collections.nCopies(indent, " ").stream().reduce((t, u) -> t + u).get();

        sp.append(pad).append("    {").append(v.getClass().getSimpleName()).append(":\n")
            .append(pad).append("      refkey=\"").append(v.getRefkey()).append("\"\n")
            .append(pad).append("      body=\"").append(v.getBody()).append("\"\n")
            .append(pad).append("    }");

        return sp.toString();
    }
}
