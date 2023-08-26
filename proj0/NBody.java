public class NBody {

    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String FileName) {
        In in = new In(FileName);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] allPlanets = new Planet[number];
        for (int i = 0; i < number; i++) {
            double initxxPos = in.readDouble();
            double inityyPos = in.readDouble();
            double initxxVel = in.readDouble();
            double inityyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            allPlanets[i] = new Planet(initxxPos, inityyPos, initxxVel, inityyVel, mass, img);
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);

        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();

        double t = 0.0;
        int num = allPlanets.length;

        while (t <= T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];

            for (int i = 0; i < num; i++) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            for (int i = 0; i < num; i++) {
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : allPlanets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t = t + dt;
        }
        
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
            allPlanets[i].yyVel, allPlanets[i].mass,allPlanets[i].imgFileName);   
        }

        
    }
}
