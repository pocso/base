package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;

public class TrainTachograph {


    Table<LocalDateTime, Integer, Integer> table = HashBasedTable.create();

    public void addEntry(int joyStickPos, int refSpeed){
        table.put(LocalDateTime.now(), joyStickPos, refSpeed);
    }

    public Table<LocalDateTime, Integer, Integer> getTable(){ return table;}
}