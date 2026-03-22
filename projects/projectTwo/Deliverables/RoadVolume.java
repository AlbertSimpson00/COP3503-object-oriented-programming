package unf.edu.cop3503;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Stores road volume data for a single date and time.
 * Includes four volume sensor readings.
 */
public class RoadVolume {
    private Date date;
    private String time;
    private int volumeSensor1;
    private int volumeSensor2;
    private int volumeSensor3;
    private int volumeSensor4;

    /**
     * Creates a RoadVolume object with the given date, time, and sensor readings.
     *
     * @param date the date of the volume reading
     * @param time the time of the volume reading
     * @param volumeSensor1 the reading from volume sensor 1
     * @param volumeSensor2 the reading from volume sensor 2
     * @param volumeSensor3 the reading from volume sensor 3
     * @param volumeSensor4 the reading from volume sensor 4
     */
    public RoadVolume(Date date, String time,
                      int volumeSensor1, int volumeSensor2,
                      int volumeSensor3, int volumeSensor4) {

        // Initialize object with constructor values
        this.date = date;
        this.time = time;
        this.volumeSensor1 = volumeSensor1;
        this.volumeSensor2 = volumeSensor2;
        this.volumeSensor3 = volumeSensor3;
        this.volumeSensor4 = volumeSensor4;
    }

    /**
     * Returns this object's data as a comma-separated string for file output.
     *
     * @return a CSV-formatted string containing the date, time, and volume sensor data
     */
    public String getFileData() {
        // Formats date segment for the output file
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Returns the CSV formatted line
        return outputDateFormat.format(date) + "," + time + "," + volumeSensor1 + "," + volumeSensor2 + "," + volumeSensor3 + "," + volumeSensor4;
    }

    /**
     * Returns the date of this volume record.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of this volume record.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the time of this volume record.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of this volume record.
     *
     * @param time the new time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the first volume sensor reading.
     *
     * @return the first sensor reading
     */
    public int getVolumeSensor1() {
        return volumeSensor1;
    }

    /**
     * Sets the first volume sensor reading.
     *
     * @param volumeSensor1 the new first sensor reading
     */
    public void setVolumeSensor1(int volumeSensor1) {
        this.volumeSensor1 = volumeSensor1;
    }

    /**
     * Returns the second volume sensor reading.
     *
     * @return the second sensor reading
     */
    public int getVolumeSensor2() {
        return volumeSensor2;
    }

    /**
     * Sets the second volume sensor reading.
     *
     * @param volumeSensor2 the new second sensor reading
     */
    public void setVolumeSensor2(int volumeSensor2) {
        this.volumeSensor2 = volumeSensor2;
    }

    /**
     * Returns the third volume sensor reading.
     *
     * @return the third sensor reading
     */
    public int getVolumeSensor3() {
        return volumeSensor3;
    }

    /**
     * Sets the third volume sensor reading.
     *
     * @param volumeSensor3 the new third sensor reading
     */
    public void setVolumeSensor3(int volumeSensor3) {
        this.volumeSensor3 = volumeSensor3;
    }

    /**
     * Returns the fourth volume sensor reading.
     *
     * @return the fourth sensor reading
     */
    public int getVolumeSensor4() {
        return volumeSensor4;
    }

    /**
     * Sets the fourth volume sensor reading.
     *
     * @param volumeSensor4 the new fourth sensor reading
     */
    public void setVolumeSensor4(int volumeSensor4) {
        this.volumeSensor4 = volumeSensor4;
    }
}