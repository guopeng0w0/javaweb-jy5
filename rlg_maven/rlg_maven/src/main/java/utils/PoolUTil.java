package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolUTil {
    private static final ComboPooledDataSource co = new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return co;
    }
}
