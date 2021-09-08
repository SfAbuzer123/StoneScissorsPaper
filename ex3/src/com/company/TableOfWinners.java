package com.company;

import com.bethecoder.ascii_table.ASCIITable;

public class TableOfWinners {
    public void showTable(String[] arr) {
        String[] tableHeaders = new String[arr.length+1];
        tableHeaders[0] = "User\\PC";
        for (int i = 1; i < tableHeaders.length; i++) {
            tableHeaders[i] = arr[i-1];
        }
        String[][] tableData = new String[arr.length][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length+1; j++) {
                if (j == 0){
                    tableData[i][j] = arr[i];
                }
                else{
                    tableData[i][j] = new WinnerDetector().winLose(arr, i, j -1);
                }

            }
        }
        ASCIITable.getInstance().printTable(tableHeaders, tableData);
    }
}
