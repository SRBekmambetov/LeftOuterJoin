package ru.tsc.srb.leftouterjoin;

import java.util.Objects;

public class RowCrossJoinTable {

    private int idTableA;
    private int idTableB;
    private String valueTableA;
    private String valueTableB;

    public RowCrossJoinTable(int idTableA, int idTableB, String valueTableA, String valueTableB) {
        this.idTableA = idTableA;
        this.idTableB = idTableB;
        this.valueTableA = valueTableA;
        this.valueTableB = valueTableB;
    }

    public int getIdTableA() {
        return idTableA;
    }

    public void setIdTableA(int idTableA) {
        this.idTableA = idTableA;
    }

    public int getIdTableB() {
        return idTableB;
    }

    public void setIdTableB(int idTableB) {
        this.idTableB = idTableB;
    }

    public String getValueTableA() {
        return valueTableA;
    }

    public void setValueTableA(String valueTableA) {
        this.valueTableA = valueTableA;
    }

    public String getValueTableB() {
        return valueTableB;
    }

    public void setValueTableB(String valueTableB) {
        this.valueTableB = valueTableB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowCrossJoinTable that = (RowCrossJoinTable) o;
        return idTableA == that.idTableA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTableA);
    }

    @Override
    public String toString() {
        return "RowCrossJoinTable{" +
                "idTableA=" + idTableA +
                ", idTableB=" + idTableB +
                ", valueTableA='" + valueTableA + '\'' +
                ", valueTableB='" + valueTableB + '\'' +
                '}';
    }
}
