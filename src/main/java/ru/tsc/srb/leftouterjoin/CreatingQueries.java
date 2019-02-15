package ru.tsc.srb.leftouterjoin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreatingQueries {

    private List<TableFromFile> tablesFromFileList;
    private List<RowCrossJoinTable> rowsCrossJoinTableList;

    public CreatingQueries() {
        this.tablesFromFileList = new ArrayList<>();
        this.rowsCrossJoinTableList = new ArrayList<>();
    }

    public void createTableFromFile(String fileTable) throws IOException {
        File file = new File(fileTable);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int z = 1;
        String nameTable = "";
        TableFromFile tableFromFile = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (z == 1) {
                nameTable = line;
            } else {
                String[] arr = line.split("\t");
                if (z == 2) {
                    String nameId = arr[0];
                    String nameValue = arr[1];
                    tableFromFile = new TableFromFile(nameTable, nameId, nameValue);
                } else {
                    int id = Integer.parseInt(arr[0]);
                    String name = arr[1];
                    RowTableFromFile rowTableFromFile = new RowTableFromFile(id, name);
                    List<RowTableFromFile> rowsTableFromFileList = tableFromFile.getRowsTableFromFileList();
                    rowsTableFromFileList.add(rowTableFromFile);
                }
            }
            z++;
        }
        tablesFromFileList.add(tableFromFile);
    }

    public void printTablesFromFiles() {
        for (TableFromFile tableFromFile: tablesFromFileList) {
            System.out.println(tableFromFile.getNameTable());
            System.out.print(tableFromFile.getNameId() + " ");
            System.out.println(tableFromFile.getNameValue());
            List<RowTableFromFile> rowsTableFromFileList = tableFromFile.getRowsTableFromFileList();
            for (RowTableFromFile rowTableFromFile: rowsTableFromFileList) {
                System.out.print(rowTableFromFile.getId() + " ");
                System.out.println(rowTableFromFile.getName());
            }
            System.out.println();
        }
    }

    public List<RowCrossJoinTable> createRowsCrossJoinTableList() {
        for (RowTableFromFile rowTableFromFile1 : tablesFromFileList.get(0).getRowsTableFromFileList()) {
            for (RowTableFromFile rowTableFromFile2 : tablesFromFileList.get(1).getRowsTableFromFileList()) {
                int id1 = rowTableFromFile1.getId();
                int id2 = rowTableFromFile2.getId();
                String name1 = rowTableFromFile1.getName();
                String name2 = rowTableFromFile2.getName();
                RowCrossJoinTable rowCrossJoinTable = new RowCrossJoinTable(id1, id2, name1, name2);
                rowsCrossJoinTableList.add(rowCrossJoinTable);
            }
        }
        return rowsCrossJoinTableList;
    }

    public void printCrossJoinTable() {
        for (RowCrossJoinTable rowCrossJoinTable: rowsCrossJoinTableList) {
            System.out.print(rowCrossJoinTable.getIdTableA() + " ");
            System.out.print(rowCrossJoinTable.getIdTableB() + " ");
            System.out.print(rowCrossJoinTable.getValueTableA() + " ");
            System.out.println(rowCrossJoinTable.getValueTableB());
        }
    }

    public LeftJoinTable createLeftJoinTable() {
        String nameId = tablesFromFileList.get(0).getNameId();
        String nameValueTableA = tablesFromFileList.get(0).getNameTable();
        String nameValueTableB = tablesFromFileList.get(1).getNameTable();
        LeftJoinTable leftJoinTable = new LeftJoinTable(nameId, nameValueTableA, nameValueTableB);
        leftJoinTable.createRowsLeftJoinTables(createRowsCrossJoinTableList(), tablesFromFileList);
        return leftJoinTable;
    }

    public void printLeftJoinTable() {
        LeftJoinTable leftJoinTable = createLeftJoinTable();
        System.out.print(leftJoinTable.getNameId() + " ");
        System.out.print(leftJoinTable.getNameValueTableA() + ".VALUE" + " ");
        System.out.println(leftJoinTable.getNameValueTableB() + ".VALUE" + " ");
        for (RowLeftJoinTable rowLeftJoinTable: leftJoinTable.getRowLeftJoinTablesList()) {
            System.out.print(rowLeftJoinTable.getNameId() + " ");
            System.out.print(rowLeftJoinTable.getNameValueTableA() + " ");
            System.out.println(rowLeftJoinTable.getNameValueTableB() + " ");
        }
    }
}
