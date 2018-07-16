package ru.testcsv.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Entity
@Data
@ToString
public class Tablecsv {

    @Id
    @GeneratedValue
    private Long ssoid;
    @Column
    private Date ts;
    @Column
    private String grp;
    @Column
    private String type;
    @Column
    private String subtype;
    @Column
    private String url;
    @Column
    private Long orgid;
    @Column
    private Long formid;
    @Column
    private String ltpa;
    @Column
    private String sudirresponse;
    @Column
    private Date ymdh;

    public Tablecsv(){}

    public Tablecsv(String[] line) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("HH:MM");
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD HH:MM");
        ssoid = Long.parseLong(line[0]);
        ts = time.parse(line[1]);
        grp = line[2];
        type = line[3];
        subtype = line[4];
        url = line[5];
        orgid = Long.parseLong(line[6]);
        formid = Long.parseLong(line[7]);
        ltpa = line[8];
        sudirresponse = line[9];
        ymdh = date.parse(line[10]);
    }
}
