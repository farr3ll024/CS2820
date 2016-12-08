package production;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import testpackage.*;

/**
 *
 * @author : Blaise Reints
 * @author : farr3ll024 (aka Blaise)
 * @version Last modified: 12/2/2016
 *
 * purpose - initialize and facilitate simulation (main)
 */
public class Master {

    Boolean isRunning;//aka status
    int iterations;// number of iterations("ticks") in this simulation
    int current_iteration;

    /**
     * constructor for master class
     */
    public Master() {
        this.isRunning = null;
        this.iterations = 100;
        this.current_iteration = 0;
    }

    /**
     * method for starting simulation - this should also create an instance of
     * all other classes
     */
    public void startSim() {
        this.isRunning = true;
    }

    /**
     * method for returning the status of the simulation(running/not running)
     *
     * @return Boolean
     */
    public Boolean getStatus() {
        if (this.current_iteration == 100) {
            this.isRunning = false;
        }
        return this.isRunning;
    }

    /**
     * method ends the simulation
     */
    public void endSim() {
        this.isRunning = false;
    }

    /**
     * method returns the current iteration number
     *
     * @return int
     */
    public int getIteration() {
        return this.current_iteration;
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String args[]) {

        Master sim = new Master();// create simulation object
        sim.startSim();// start the simulation - this will initialize all classes

        //create instance of each class
        Floor floor_master = new Floor(160, 200);
        List<Map<String, Object>> listA = new ArrayList<>();
        Inventory inventory_master = new Inventory(listA);
        Belt belt_master = new Belt(floor_master.floor_X);
        Orders orders_master = new Orders(inventory_master, floor_master);
        MockFloor mockFloor_master = new MockFloor();
        MockInventory mockInventory_master = new MockInventory();
        RobotMaster robotMaster_master = new RobotMaster(1, mockFloor_master, mockInventory_master);
//        RobotMaster robotMaster_master = new RobotMaster(1, floor_master, inventory_master);
        Visualizer visualizer_master = new Visualizer();

        while (sim.getStatus() == true) {
            inventory_master.tick(sim.current_iteration);
            belt_master.tick(sim.current_iteration);
            orders_master.tick(sim.current_iteration);
            robotMaster_master.tick(sim.current_iteration);
//            robotMaster_master.tick(sim.current_iteration);
            visualizer_master.tick(sim.current_iteration);
            sim.current_iteration += 1;
        }
    }
}
