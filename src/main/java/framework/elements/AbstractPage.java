package framework.elements;

import framework.utils.WebElementUtils;

public class AbstractPage {

    private WebElementUtils webElementUtils;

    protected WebElementUtils webElementUtils() {
        return webElementUtils != null ? webElementUtils : (webElementUtils = WebElementUtils.getInstance());
    }
}
