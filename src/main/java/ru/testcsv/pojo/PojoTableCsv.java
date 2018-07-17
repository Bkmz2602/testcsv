package ru.testcsv.pojo;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PojoTableCsv {

    @CsvBindByName
    private String ssoid;

    @CsvBindByName
    private Long ts;

    @CsvBindByName
    private String grp;

    @CsvBindByName
    private String type;

    @CsvBindByName
    private String subtype;

    @CsvBindByName
    private String url;

    @CsvBindByName
    private String orgid;

    @CsvBindByName
    private String formid;

    @CsvBindByName
    private String code;

    @CsvBindByName
    private String ltpa;

    @CsvBindByName
    private String sudirresponse;

    @CsvBindByName
    private String ymdh;
}
