package ru.tsc.srb.leftouterjoin;

import java.util.ArrayList;
import java.util.List;

public class TableFromFile {

    private String nameTable;
    private String nameId;
    private String nameValue;

    private List<RowTableFromFile> rowsTableFromFileList;

    public TableFromFile(String nameTable, String nameId, String nameValue) {
        this.nameTable = nameTable;
        this.nameId = nameId;
        this.nameValue = nameValue;
        this.rowsTableFromFileList = new ArrayList<>();
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public List<RowTableFromFile> getRowsTableFromFileList() {
        return rowsTableFromFileList;
    }

    public void setRowsTableFromFileList(List<RowTableFromFile> rowsTableFromFileList) {
        this.rowsTableFromFileList = rowsTableFromFileList;
    }
}
