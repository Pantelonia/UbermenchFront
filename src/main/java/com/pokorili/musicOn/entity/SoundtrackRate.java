package com.pokorili.musicOn.entity;


public class SoundtrackRate {

    private Long id;

    private Soundtrack soundtrack;

    private Visitor visitor;

    private Integer rate;

    public SoundtrackRate() {}

    public SoundtrackRate(Soundtrack soundtrack, Visitor visitor) {
        this.soundtrack = soundtrack;
        this.visitor = visitor;
    }

    public Soundtrack getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(Soundtrack soundtrack) {
        this.soundtrack = soundtrack;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoundtrackRate that = (SoundtrackRate) o;

        if (soundtrack != null ? !soundtrack.equals(that.soundtrack) : that.soundtrack != null) return false;
        if (visitor != null ? !visitor.equals(that.visitor) : that.visitor != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = soundtrack != null ? soundtrack.hashCode() : 0;
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
