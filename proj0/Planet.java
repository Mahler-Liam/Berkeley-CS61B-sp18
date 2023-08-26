public class Planet {
    public double xxPos;   //its current x position
    public double yyPos;   //its current y position
    public double xxVel;   //its current velocity in the x direction
    public double yyVel;   //its current velocity in the y direction
    public double mass;    //its mass
    public String imgFileName; //the name of the file that corresponds to the image that depicts the body
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        double dx = xxPos - b.xxPos;
        double dy = yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet b) {
        double F;
        double r = calcDistance(b);
        F = (G * mass * b.mass) / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - xxPos;
        double r = calcDistance(b);
        return calcForceExertedBy(b) * dx / r;
    }

    public double calcForceExertedByY(Planet b) {
        double dy = b.yyPos - yyPos;
        double r = calcDistance(b);
        return calcForceExertedBy(b) * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceX = 0.0;
        for (Planet p : allPlanets) {    //java中的增强型for循环（也称为for-each循环）
            if (this.equals(p)) {
                continue;
            }
            double forceX = calcForceExertedByX(p);
            netForceX += forceX;
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceY = 0.0;
        for (Planet p : allPlanets) {    
            if (this.equals(p)) {
                continue;
            }
            double forceY = calcForceExertedByY(p);
            netForceY += forceY;
        }
        return netForceY;
    }

    public void update(double dt,double fX,double fY) {
        double aNetX = fX / mass;
        double aNetY = fY / mass;
        xxVel = xxVel + dt * aNetX;
        yyVel = yyVel + dt * aNetY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
