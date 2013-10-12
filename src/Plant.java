/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/8/13
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Plant {
    private String leaves;
    private String roots;

    public String getRoots() {
        return roots;
    }

    public void setRoots(String roots) {
        this.roots = roots;
    }

    public String getLeaves() {
        return this.leaves;
    }

    public void setLeaves(String leaves) {
        this.leaves = leaves;
    }

//    @Override
//    public String toString() {
////        setLeaves();
//        return "Plant{" +
//                "leaves='" + leaves + '\'' +
//                ", roots='" + roots + '\'' +
//                '}';
//    }
}
