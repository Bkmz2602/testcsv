package ru.testcsv.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
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
public class Tablecsv {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    @CsvBindByName
    private String ssoid;
    @Column
    @CsvBindByName
    private Date ts;
    @Column
    @CsvBindByName
    private String grp;
    @Column
    @CsvBindByName
    private String type;
    @Column
    @CsvBindByName
    private String subtype;
    @Column
    @CsvBindByName
    private String url;
    @Column
    @CsvBindByName
    private String orgid;
    @Column
    @CsvBindByName
    private String formid;
    @Column
    @CsvBindByName
    private String code;
    @Column
    @CsvBindByName
    private String ltpa;
    @Column
    @CsvBindByName
    private String sudirresponse;
    @Column
    @CsvBindByName
    private Date ymdh;

    public Tablecsv(){}

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
