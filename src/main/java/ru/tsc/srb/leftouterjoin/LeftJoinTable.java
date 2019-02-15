package ru.tsc.srb.leftouterjoin;

import java.util.ArrayList;
import java.util.List;

public class LeftJoinTable {

    private String nameId;
    private String nameValueTableA;
    private String nameValueTableB;

    private List<RowLeftJoinTable> rowLeftJoinTablesList;

    public LeftJoinTable(String nameId, String nameValueTableA, String nameValueTableB) {
        this.nameId = nameId;
        this.nameValueTableA = nameValueTableA;
        this.nameValueTableB = nameValueTableB;
        this.rowLeftJoinTablesList = new ArrayList<>();
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
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

    public List<RowLeftJoinTable> getRowLeftJoinTablesList() {
        return rowLeftJoinTablesList;
    }

    public void setRowLeftJoinTablesList(List<RowLeftJoinTable> rowLeftJoinTablesList) {
        this.rowLeftJoinTablesList = rowLeftJoinTablesList;
    }

    public void createRowsLeftJoinTables(List<RowCrossJoinTable> rowsCrossJoinTableList, List<TableFromFile> tablesFromFileList) {
        createRowsInnerJoinTables(rowsCrossJoinTableList);
        for (RowTableFromFile rowTableFromFile: tablesFromFileList.get(0).getRowsTableFromFileList()) {
            if (rowLeftJoinTablesList.indexOf(rowTableFromFile) == -1) {
                int nameId = rowTableFromFile.getId();
                String nameValueTableA = rowTableFromFile.getName();
                RowLeftJoinTable rowLeftJoinTable = new RowLeftJoinTable(nameId, nameValueTableA);
                rowLeftJoinTablesList.add(rowLeftJoinTable);
            }
        }
    }

    public void createRowsInnerJoinTables(List<RowCrossJoinTable> rowsCrossJoinTableList) {
        for (RowCrossJoinTable rowCrossJoinTable: rowsCrossJoinTableList) {
            if (rowCrossJoinTable.getIdTableA() == rowCrossJoinTable.getIdTableB()) {
                int nameId = rowCrossJoinTable.getIdTableA();
                String nameValueTableA = rowCrossJoinTable.getValueTableA();
                String nameValueTableB = rowCrossJoinTable.getValueTableB();
                RowLeftJoinTable rowLeftJoinTable = new RowLeftJoinTable(nameId, nameValueTableA, nameValueTableB);
                rowLeftJoinTablesList.add(rowLeftJoinTable);
            }
        }
    }
}
