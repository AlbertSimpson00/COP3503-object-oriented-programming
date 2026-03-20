package unf.edu.cop3503;

import java.util.Date;
import java.text.SimpleDateFormat;


public class RoadVolume {
    private Date date;
    private String time;
    private int volumeSensor1;
    private int volumeSensor2;
    private int volumeSensor3;
    private int volumeSensor4;

    public RoadVolume(Date date, String time,
                      int volumeSensor1, int volumeSensor2,
                      int volumeSensor3, int volumeSensor4,
                      int volumeSensor5) {

        this.date = date;
        this.time = time;
        this.volumeSensor1 = volumeSensor1;
        this.volumeSensor2 = volumeSensor2;
        this.volumeSensor3 = volumeSensor3;
        this.volumeSensor4 = volumeSensor4;
    }

    // Suggested format:
    // date,time,v1,v2,v3,v4,v5
    public String getFileData() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        return outputDateFormat.format(date) + "," + time + "," + volumeSensor1 + "," + volumeSensor2 + "," + volumeSensor3 + "," + volumeSensor4;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getVolumeSensor1() {
        return volumeSensor1;
    }

    public void setVolumeSensor1(int volumeSensor1) {
        this.volumeSensor1 = volumeSensor1;
    }

    public int getVolumeSensor2() {
        return volumeSensor2;
    }

    public void setVolumeSensor2(int volumeSensor2) {
        this.volumeSensor2 = volumeSensor2;
    }

    public int getVolumeSensor3() {
        return volumeSensor3;
    }

    public void setVolumeSensor3(int volumeSensor3) {
        this.volumeSensor3 = volumeSensor3;
    }

    public int getVolumeSensor4() {
        return volumeSensor4;
    }

    public void setVolumeSensor4(int volumeSensor4) {
        this.volumeSensor4 = volumeSensor4;
    }
}