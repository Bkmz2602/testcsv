package ru.testcsv.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.testcsv.pojo.PojoTableCsv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Tablecsv {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String ssoid;
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
    private String orgid;
    @Column
    private String formid;
    @Column
    private String code;
    @Column
    private String ltpa;
    @Column
    private String sudirresponse;
    @Column
    private Date ymdh;

    public Tablecsv(PojoTableCsv pojoTableCsv) throws ParseException {
        this.ssoid = pojoTableCsv.getSsoid();
        this.ts = new Time(pojoTableCsv.getTs());
        this.grp = pojoTableCsv.getGrp();
        this.type = pojoTableCsv.getType();
        this.subtype = pojoTableCsv.getSubtype();
        this.url = pojoTableCsv.getUrl();
        this.orgid = pojoTableCsv.getOrgid();
        this.formid = pojoTableCsv.getFormid();
        this.code = pojoTableCsv.getCode();
        this.ltpa = pojoTableCsv.getLtpa();
        this.sudirresponse = pojoTableCsv.getSudirresponse();
        this.ymdh = stringToDate(pojoTableCsv.getYmdh());
    }

    private Date stringToDate(String ymdh) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD HH:MM");
        ymdh = ymdh.substring(0,9)+" "+ymdh.substring(11)+":00";
        return date.parse(ymdh);
    }
}
