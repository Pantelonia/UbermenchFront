package com.pokorili.musicOn.entity;

import java.sql.Timestamp;

public class History {

    private Long id;

    private Visitor visitor;

    private Soundtrack soundtrack;

    private Timestamp listeningDate;

    public History() {}

    public History(Visitor visitor, Soundtrack soundtrack) {
        this.visitor = visitor;
        this.soundtrack = soundtrack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Soundtrack getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(Soundtrack soundtrack) {
        this.soundtrack = soundtrack;
    }

    public Timestamp getListeningDate() {
        return listeningDate;
    }

    public void setListeningDate(Timestamp listeningDate) {
        this.listeningDate = listeningDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (id != null ? !id.equals(history.id) : history.id != null) return false;
        if (visitor != null ? !visitor.equals(history.visitor) : history.visitor != null) return false;
        if (soundtrack != null ? !soundtrack.equals(history.soundtrack) : history.soundtrack != null)
            return false;
        if (listeningDate != null ? !listeningDate.equals(history.listeningDate) : history.listeningDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        result = 31 * result + (soundtrack != null ? soundtrack.hashCode() : 0);
        result = 31 * result + (listeningDate != null ? listeningDate.hashCode() : 0);
        return result;
    }

}
