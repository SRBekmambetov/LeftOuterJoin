package ru.tsc.srb.leftouterjoin;

import java.util.Objects;

public class RowLeftJoinTable {

    private int nameId;
    private String nameValueTableA;
    private String nameValueTableB;

    public RowLeftJoinTable(int nameId, String nameValueTableA) {
        this.nameId = nameId;
        this.nameValueTableA = nameValueTableA;
    }

    public RowLeftJoinTable(int nameId, String nameValueTableA, String nameValueTableB) {
        this.nameId = nameId;
        this.nameValueTableA = nameValueTableA;
        this.nameValueTableB = nameValueTableB;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getNameValueTableA() {
        return nameValueTableA;
    }

    public void setNameValueTableA(String nameValueTableA) {
        this.nameValueTableA = nameValueTableA;
    }

    public String getNameValueTableB() {
        return nameValueTableB;
    }

    public void setNameValueTableB(String nameValueTableB) {
        this.nameValueTableB = nameValueTableB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowLeftJoinTable that = (RowLeftJoinTable) o;
        return nameId == that.nameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameId);
    }

    @Override
    public String toString() {
        return "RowLeftJoinTable{" +
                "nameId=" + nameId +
                ", nameValueTableA='" + nameValueTableA + '\'' +
                ", nameValueTableB='" + nameValueTableB + '\'' +
                '}';
    }
}
