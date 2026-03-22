package unf.edu.cop3503;

/**
 * Stores matching road volume and speed data for a single date and time,
 * along with calculated total and average values.
 */
public class RoadSection {
    private RoadVolume roadVolume;
    private RoadSpeed roadSpeed;

    private int volumeTotal;
    private double volumeAvg;
    private double speedAvg;

    /**
     * Creates a RoadSection object using matching volume and speed objects.
     * Derived values are calculated when the object is created.
     *
     * @param roadVolume the matching road volume object
     * @param roadSpeed the matching road speed object
     */
    public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {

        // Stores the matching volume and speed objects
        this.roadVolume = roadVolume;
        this.roadSpeed = roadSpeed;

        // Calls the respective helper methods to compute and calculate derived values
        this.volumeTotal = calcVolumeTotal();
        this.volumeAvg = calcVolumeAvg();
        this.speedAvg = calcSpeedAvg();
    }

    /**
     * Returns this object's data as a comma-separated string for file output.
     *
     * @return a CSV-formatted string containing road section data
     */
    public String getFileData() {

        // Combines all values into CSV format for the return value
        return roadVolume.getFileData() + "," + roadSpeed.getSpeedSensor1() + "," + roadSpeed.getSpeedSensor2() + "," + volumeTotal + "," + String.format("%.2f", volumeAvg) + "," + String.format("%.2f", speedAvg);
    }

    /**
     * Returns the RoadVolume object for this road section.
     *
     * @return the road volume object
     */
    public RoadVolume getRoadVolume() {
        return roadVolume;
    }

    /**
     * Sets the RoadVolume object for this road section and refreshes derived values.
     *
     * @param roadVolume the new road volume object
     */
    public void setRoadVolume(RoadVolume roadVolume) {
        this.roadVolume = roadVolume;
        // refresh derived values
        this.volumeTotal = calcVolumeTotal();
        this.volumeAvg = calcVolumeAvg();
    }

    /**
     * Returns the RoadSpeed object for this road section.
     *
     * @return the road speed object
     */
    public RoadSpeed getRoadSpeed() {
        return roadSpeed;
    }

    /**
     * Sets the RoadSpeed object for this road section and refreshes derived values.
     *
     * @param roadSpeed the new road speed object
     */
    public void setRoadSpeed(RoadSpeed roadSpeed) {
        this.roadSpeed = roadSpeed;
        // refresh derived values
        this.speedAvg = calcSpeedAvg();
    }

    /**
     * Returns the total volume for this road section.
     *
     * @return the total volume
     */
    public int getVolumeTotal() {
        return volumeTotal;
    }

    /**
     * Sets the total volume for this road section.
     *
     * @param total the new total volume
     */
    public void setVolumeTotal(int total) {
        this.volumeTotal = total;
    }

    /**
     * Returns the average volume for this road section.
     *
     * @return the average volume
     */
    public double getVolumeAvg() {
        return volumeAvg;
    }

    /**
     * Sets the average volume for this road section.
     *
     * @param avg the new average volume
     */
    public void setVolumeAvg(double avg) {
        this.volumeAvg = avg;
    }

    /**
     * Returns the average speed for this road section.
     *
     * @return the average speed
     */
    public double getSpeedAvg() {
        return speedAvg;
    }

    /**
     * Sets the average speed for this road section.
     *
     * @param avg the new average speed
     */
    public void setSpeedAvg(double avg) {
        this.speedAvg = avg;
    }

    // -------- PRIVATE HELPER METHODS --------

    /**
     * Calculates the total volume using the four volume sensor readings.
     *
     * @return the total volume
     */
    private int calcVolumeTotal() {
        return roadVolume.getVolumeSensor1() + roadVolume.getVolumeSensor2() + roadVolume.getVolumeSensor3() + roadVolume.getVolumeSensor4();
    }

    /**
     * Calculates the average volume using the four volume sensor readings.
     *
     * @return the average volume
     */
    private double calcVolumeAvg() {

        // Returns average by dividing the total volume by the amount of sensors (4 sensors)
        return calcVolumeTotal() / 4.0;
    }

    /**
     * Calculates the average speed using the two speed sensor readings.
     *
     * @return the average speed
     */
    private double calcSpeedAvg() {

        // Returns the average of the two speed sensors
        return (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2()) / 2.0;
    }
}