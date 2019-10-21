package models;

import org.openqa.selenium.By;

/**
* A class storing the identifier and element name of the Element.
* @version 1.0
* @author Hussein ElSherif
*/
public class BasicElement {

	private String elementName;
	private By identifier;
	
	public BasicElement(String elementName, By identifier) {
		super();
		this.elementName = elementName;
		this.identifier = identifier;
	}	
	
	/**
	 * Returns the element name as a String
	 * @return Returns Name of the Element as a String
	 */
	public String getElementName() {
		return elementName;
	}
	
	/**
	 * Sets the name of the element using the given string
	 * @param String - Target name of the element
	 */
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	
	/**
	 * Returns the identifier of the Element as a By Selenium identifier
	 * @return Returns the By object identifier of the element
	 */
	public By getIdentifier() {
		return identifier;
	}
	
	/**
	 * Sets the Identifier of the element object
	 * @param The Selenium By identifier to be set for the element.
	 */
	public void setIdentifier(By identifier) {
		this.identifier = identifier;
	}
	
}
