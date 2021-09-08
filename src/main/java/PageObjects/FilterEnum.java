package PageObjects;

public enum FilterEnum {

    NAME_A_Z("az"),
    NAME_Z_A("za"),
    PRICE_L_H("lohi"),
    PRICE_H_L("hilo");

    String option;

    FilterEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}
