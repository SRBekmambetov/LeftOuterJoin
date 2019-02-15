package ru.tsc.srb.leftouterjoin;

import java.util.List;
import java.util.Objects;

public class RowTableFromFile {

    private int id;
    private String name;

    public RowTableFromFile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == RowLeftJoinTable.class) {
            RowLeftJoinTable table = (RowLeftJoinTable)o;
            if(table.getNameId() == this.getId())
                return true;
        }
        if (getClass() != o.getClass()) return false;

        RowTableFromFile that = (RowTableFromFile) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RowTableFromFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
