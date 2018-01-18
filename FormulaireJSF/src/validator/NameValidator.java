package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class NameValidator implements Validator {


	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object name) throws ValidatorException {
		
		System.out.println("validation de Name");
		String nameValue = (String) name;
		HtmlInputText htmlInputText = (HtmlInputText) uiComponent.getAttributes().get("nombindéàvalider");
		String prénomàvalider = (String) htmlInputText.getValue();
		
		if (nameValue.length() < 2) {
			System.out.println("Le nom n'est pas composé d'au moins 2 caractères");
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le nom n'est pas composé d'au moins 2 caractères", "Le nom n'est pas composé d'au moins 2 caractères");
			throw new ValidatorException(fmsg);
		}
		
		if (prénomàvalider.equals(nameValue)) {
			System.out.println("Le nom et le prénom sont identiques");
			FacesMessage fmsg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le nom et le prénom sont identiques", "Le nom et le prénom sont identiques");
			throw new ValidatorException(fmsg2);
			

			
		}
	} 
}