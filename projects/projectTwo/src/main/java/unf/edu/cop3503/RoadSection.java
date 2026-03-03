package unf.edu.cop3503;

public class RoadSection {
    private RoadVolume roadVolume;
    private RoadSpeed roadSpeed;

    private int volumeTotal;
    private double volumeAvg;
    private double speedAvg;

    public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {
        this.roadVolume = roadVolume;
        this.roadSpeed = roadSpeed;

        // compute derived values
        this.volumeTotal = calcVolumeTotal();
        this.volumeAvg = calcVolumeAvg();
        this.speedAvg = calcSpeedAvg();
    }

    // Suggested file format:
    // [roadVolume data],[roadSpeed data],volumeTotal,volumeAvg,speedAvg
    public String getFileData() {
        return null;
    }

    public RoadVolume getRoadVolume() {
        return roadVolume;
    }

    public void setRoadVolume(RoadVolume roadVolume) {
        this.roadVolume = roadVolume;
        // refresh derived values
        this.volumeTotal = calcVolumeTotal();
        this.volumeAvg = calcVolumeAvg();
    }

    public RoadSpeed getRoadSpeed() {
        return roadSpeed;
    }

    public void setRoadSpeed(RoadSpeed roadSpeed) {
        this.roadSpeed = roadSpeed;
        // refresh derived values
        this.speedAvg = calcSpeedAvg();
    }

    public int getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(int total) {
        this.volumeTotal = total;
    }

    public double getVolumeAvg() {
        return volumeAvg;
    }

    public void setVolumeAvg(double avg) {
        this.volumeAvg = avg;
    }

    public double getSpeedAvg() {
        return speedAvg;
    }

    public void setSpeedAvg(double avg) {
        this.speedAvg = avg;
    }

    // ---- private helpers from UML ----

    private int calcVolumeTotal() {
        if (roadVolume == null) return 0;

        return roadVolume.getVolumeSensor1()
                + roadVolume.getVolumeSensor2()
                + roadVolume.getVolumeSensor3()
                + roadVolume.getVolumeSensor4()
                + roadVolume.getVolumeSensor5();
    }

    private double calcVolumeAvg() {
        // 5 volume sensors
        return volumeTotal / 5.0;
    }

    private double calcSpeedAvg() {
        if (roadSpeed == null) return 0.0;

        return (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2()) / 2.0;
    }
}