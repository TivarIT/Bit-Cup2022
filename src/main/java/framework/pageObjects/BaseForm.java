package framework.pageObjects;

import framework.elements.BaseElement;
import org.apache.log4j.Logger;

public abstract class BaseForm {
    private static final Logger LOG = Logger.getLogger(BaseForm.class);
    private BaseElement element;
    private String name;

    protected BaseForm(BaseElement element, String name) {
        LOG.info(name + " page is open");
        this.element = element;
        this.name = name;
    }
}