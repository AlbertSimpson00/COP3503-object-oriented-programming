package unf.edu.cop3503;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Stores road speed data for a single date and time.
 * Includes two speed sensor readings.
 */
public class RoadSpeed {
    private Date date;
    private String time;
    private double speedSensor1;
    private double speedSensor2;

    /**
     * Creates a RoadSpeed object with the given date, time, and sensor readings.
     *
     * @param date the date of the speed reading
     * @param time the time of the speed reading
     * @param speedSensor1 the reading from speed sensor 1
     * @param speedSensor2 the reading from speed sensor 2
     */
    public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2) {
        this.date = date;
        this.time = time;
        this.speedSensor1 = speedSensor1;
        this.speedSensor2 = speedSensor2;
    }

    /**
     * Returns this object's data as a comma-separated string for file output.
     *
     * @return a CSV-formatted string containing the date, time, and speed sensor data
     */
    public String getFileData() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        return outputDateFormat.format(date) + "," + time + "," + speedSensor1 + "," + speedSensor2;
    }

    /**
     * Returns the date of this speed record.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of this speed record.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the time of this speed record.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of this speed record.
     *
     * @param time the new time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the first speed sensor reading.
     *
     * @return the first speed sensor reading
     */
    public double getSpeedSensor1() {
        return speedSensor1;
    }

    /**
     * Sets the first speed sensor reading.
     *
     * @param speedSensor1 the new first speed sensor reading
     */
    public void setSpeedSensor1(double speedSensor1) {
        this.speedSensor1 = speedSensor1;
    }

    /**
     * Returns the second speed sensor reading.
     *
     * @return the second speed sensor reading
     */
    public double getSpeedSensor2() {
        return speedSensor2;
    }

    /**
     * Sets the second speed sensor reading.
     *
     * @param speedSensor2 the new second speed sensor reading
     */
    public void setSpeedSensor2(double speedSensor2) {
        this.speedSensor2 = speedSensor2;
    }
}