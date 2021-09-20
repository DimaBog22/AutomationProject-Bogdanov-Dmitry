package PageObject.Herokuapp;

public enum HomePageLinksEnum {


    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    LOGIN_PAGE("Form Authentication");

    String link;

    HomePageLinksEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }

}