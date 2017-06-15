/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

/**
 *
 * @author PRPC
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import static java.lang.Math.abs;

public class PSO {

    //constants
    public static double C1 = 2.0;
    public static double C2 = 2.0;
    public static double w = 0;
    //constraints
    public static final int ROBOTS_SWARM_SIZE = 50;
    public static final int MAX_ITERATION = 1000;
    public static final double LOCATION_X_LOW = -2;
    public static final double LOCATION_X_HIGH = 2;
    public static final double LOCATION_Y_LOW = -2;
    public static final double LOCATION_Y_HIGH = 2;
    public static final double FINAL_X = 2;
    public static final double FINAL_Y = 2;
    public static final double THRESHOLD = 1E-5;
    public static long start;

    public static int loop = 0;
    public static ScatterPlot plot;
    private static ArrayList<PSO.Agent> agents = new ArrayList<>();
    private static double[] personalBest = new double[ROBOTS_SWARM_SIZE];
    private static int optimizedAgentsCount = 0;
    private static ArrayList<Location> personalBestLocation = new ArrayList<>();
    private static double globalBest;
    private static Location globalBestLocation;
    private static double[] goodnessValues = new double[ROBOTS_SWARM_SIZE];
    Random random = new Random();
    Timer timer;
    String title = "UAV";

    public void moveToWeedInfestedArea() {
        timer = new Timer();
        createSwarm();
        updateGoodnessValues();
        
        start = System.currentTimeMillis();

        plot = new ScatterPlot(title, agents, FINAL_X, FINAL_Y);
        plot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plot.pack();
        plot.setLocationRelativeTo(null);
        plot.setVisible(true);

        for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
            personalBest[i] = goodnessValues[i];
            personalBestLocation.add(agents.get(i).getLocation());
        }

        updateGlobalBest(loop);

        for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
            timer.schedule(agents.get(i), 100, 1000);
        }
    }

    public void createSwarm() {
        Agent agent;
        for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
            agent = new Agent();

            double[] loc = new double[2];
            loc[0] = LOCATION_X_LOW + random.nextDouble() * (LOCATION_X_HIGH - LOCATION_X_LOW);
            loc[1] = LOCATION_Y_LOW + random.nextDouble() * (LOCATION_Y_HIGH - LOCATION_Y_LOW);
            Location location = new Location(loc);

            double[] vel = new double[2];
            vel[0] = 0;
            vel[1] = 1;
            Velocity velocity = new Velocity(vel);

            agent.setLocation(location);
            agent.setVelocity(velocity);
            agents.add(agent);
        }
    }

    public void updateGoodnessValues() {
        for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
            goodnessValues[i] = agents.get(i).getGoodness();
        }
    }

    public int updateGlobalBest(int t) {
        int bestParticleIndex = getPositionOfParticleWithBestGoodness(goodnessValues);
        if (t == 0 || goodnessValues[bestParticleIndex] < globalBest) {
            globalBest = goodnessValues[bestParticleIndex];
            globalBestLocation = agents.get(bestParticleIndex).getLocation();
        }
        return bestParticleIndex;
    }

    public int getPositionOfParticleWithBestGoodness(double[] list) {
        int pos = 0;
        double minValue = list[0];

        for (int i = 0; i < list.length; i++) {
            if (list[i] < minValue) {
                pos = i;
                minValue = list[i];
            }
        }

        return pos;
    }

    public static double findGoodnessValue(Location location) {
        double result;
        double x = location.getLocation()[0];
        double y = location.getLocation()[1];

        double diff_x = FINAL_X - x;
        double diff_y = FINAL_Y - y;
        result = abs(diff_x) + abs(diff_y);

        return result;
    }

    public class Agent extends TimerTask {

        private double goodness;
        private Velocity velocity;
        private Location location;

        public Agent(double goodness, Velocity velocity, Location location) {
            super();
            this.goodness = goodness;
            this.velocity = velocity;
            this.location = location;
        }

        public Agent() {
            super();
        }

        public Velocity getVelocity() {
            return velocity;
        }

        public void setVelocity(Velocity velocity) {
            this.velocity = velocity;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public double getGoodness() {
            goodness = findGoodnessValue(location);
            return goodness;
        }

        @Override
        public void run() {

            if (optimizedAgentsCount >= ROBOTS_SWARM_SIZE || loop >= MAX_ITERATION) {
                int bestParticleIndex = updateGlobalBest(MAX_ITERATION);
                System.out.println("\nSolution found at iteration " + (loop - 1) + ", the solutions is:");
                System.out.println("     Best particle: " + (bestParticleIndex + 1));
                System.out.println("     Best X: " + globalBestLocation.getLocation()[0]);
                System.out.println("     Best Y: " + globalBestLocation.getLocation()[1]);
                for (int a = 0; a < personalBestLocation.size(); a++) {
                    Agent p = agents.get(a);
                    System.out.println("\n Particle:" + (a + 1));
                    System.out.println("     X: " + p.getLocation().getLocation()[0]);
                    System.out.println("     Y: " + p.getLocation().getLocation()[1]);
                    System.out.println("     Error Value: " + goodnessValues[a]);
                }
                timer.cancel();
                long now = System.currentTimeMillis();
                System.out.println("Time taken:" + (now - start) / 1000.0);
            }

            optimizePosition();

        }

        private synchronized void optimizePosition() {
            for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
                if (goodnessValues[i] < personalBest[i]) {
                    personalBest[i] = goodnessValues[i];
                    personalBestLocation.set(i, agents.get(i).getLocation());
                }
            }

            updateGlobalBest(loop);

            w = random.nextDouble();

            for (int i = 0; i < ROBOTS_SWARM_SIZE; i++) {
                double r1 = random.nextDouble();
                double r2 = random.nextDouble();

                if (goodnessValues[i] > THRESHOLD) {
                    Agent agent = agents.get(i);

                    double[] newVel = new double[2];
                    newVel[0] = (w * agent.getVelocity().getVelocity()[0])
                            + (r1 * C1) * (personalBestLocation.get(i).getLocation()[0] - agent.getLocation().getLocation()[0])
                            + (r2 * C2) * (globalBestLocation.getLocation()[0] - agent.getLocation().getLocation()[0]);
                    newVel[1] = (w * agent.getVelocity().getVelocity()[1])
                            + (r1 * C1) * (personalBestLocation.get(i).getLocation()[1] - agent.getLocation().getLocation()[1])
                            + (r2 * C2) * (globalBestLocation.getLocation()[1] - agent.getLocation().getLocation()[1]);
                    Velocity vel = new Velocity(newVel);
                    agent.setVelocity(vel);

                    double[] newLoc = new double[2];
                    newLoc[0] = agent.getLocation().getLocation()[0] + newVel[0];
                    newLoc[1] = agent.getLocation().getLocation()[1] + newVel[1];
                    Location loc = new Location(newLoc);
                    agent.setLocation(loc);
                    goodnessValues[i] = findGoodnessValue(agent.getLocation());
                    if (goodnessValues[i] < THRESHOLD) {
                        optimizedAgentsCount++;
                    }
                }
            }

            loop++;
            updateGoodnessValues();

            plot.changePosition(agents, FINAL_X, FINAL_Y);
        }

    }

    public class Location {

        private double[] location;

        public Location(double[] location) {
            super();
            this.location = location;
        }

        public double[] getLocation() {
            return location;
        }

        public void setLocation(double[] location) {
            this.location = location;
        }

    }

    public class Velocity {

        private double[] velocity;

        public Velocity(double[] velocity) {
            super();
            this.velocity = velocity;
        }

        public double[] getVelocity() {
            return velocity;
        }

        public void setVelocity(double[] velocity) {
            this.velocity = velocity;
        }

    }

    public static void main(String args[]) throws InterruptedException {
        new PSO().moveToWeedInfestedArea();
    }

}
