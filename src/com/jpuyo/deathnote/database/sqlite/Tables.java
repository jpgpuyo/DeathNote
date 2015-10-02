package com.jpuyo.deathnote.database.sqlite;

import com.jpuyo.deathnote.database.models.Deduction;
import com.jpuyo.deathnote.database.models.Investigation;

public enum Tables {
    INVESTIGATION(Investigation.class),
    DEDUCTION(Deduction.class);

    Tables(Class tableClass) {
        this.tableClass = tableClass;
    }

    private Class tableClass;

    public Class getTableClass() {
        return tableClass;
    }
}
