package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TachographTest {

    TrainTachograph tachograph;

    @Test
    public void putTest(){
        TrainTachograph tach = new TrainTachograph();
        tach.addEntry(1, 2);
        tach.addEntry(1, 2);

        Assert.assertEquals(2, tach.getTable().size());
    }
}