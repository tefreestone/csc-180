package edu.neumont.csc180.enums;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/8/13
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tree extends Plant implements TomsInterface {

    @Override
    public void setLeaves(String leaves) {
        super.setLeaves(leaves);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String getLeaves() {
        return super.getLeaves();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void wakeup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void tryAgainAndWakeup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
