package core.actions;

/**
 * Action definitions for webdriver
 * <p>
 * Checks such as element present, visible, clickable etc are performed prior to running actions.
 * These actions also highlights elements prior to making any actions
 * <p>
 * Also we expect the user of the actions to send elementDescription as
 * id=<>YOUR ELEMENT ID>
 * css=<YOUR CSS>
 * xpath=<YOUR XPATH>
 * <p>
 * Currently we support id, css and xpath.
 */
public interface GenericActions {
    /**
     * Clicks an element by object description
     *
     * @param elementDescription
     * @throws Exception
     */
    void click(String elementDescription) throws Exception;

    /**
     * Writes to an element
     *
     * @param elementDescription
     * @param content
     * @throws Exception
     */
    void write(String elementDescription, String content) throws Exception;

    /**
     * Hover over an element
     *
     * @param elementDescription
     * @throws Exception
     */
    void hoverOverElement(String elementDescription) throws Exception;

    /**
     * Select item from drop down
     *
     * @param elementDescription provide the root of the select identifier
     * @param itemValueToSelect
     * @throws Exception
     */
    void selectItemFromDropDown(String elementDescription, String itemValueToSelect) throws Exception;

    /**
     * Ensures element is present
     *
     * @param elementDescription
     * @return
     */
    boolean ensureElementIsPresent(String elementDescription);

    /**
     * Ensures text is changed to required text for an element
     *
     * @param elementDescription
     * @param requiredText
     * @return
     * @throws Exception
     */
    boolean ensureTextChanged(String elementDescription, String requiredText) throws Exception;

    /**
     * Gets the text of an element
     *
     * @param elementDescription
     * @return elementText
     * @throws Exception
     */
    String getText(String elementDescription) throws Exception;

    /**
     * Retrieves an attribute of an element
     *
     * @param elementDescription
     * @param attribute
     * @return
     * @throws Exception
     */
    String getAttribute(String elementDescription, String attribute) throws Exception;

}
