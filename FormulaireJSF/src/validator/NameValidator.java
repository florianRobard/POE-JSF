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
		HtmlInputText htmlInputText = (HtmlInputText) uiComponent.getAttributes().get("nombind��valider");
		String pr�nom�valider = (String) htmlInputText.getValue();
		
		if (nameValue.length() < 2) {
			System.out.println("Le nom n'est pas compos� d'au moins 2 caract�res");
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le nom n'est pas compos� d'au moins 2 caract�res", "Le nom n'est pas compos� d'au moins 2 caract�res");
			throw new ValidatorException(fmsg);
		}
		
		if (pr�nom�valider.equals(nameValue)) {
			System.out.println("Le nom et le pr�nom sont identiques");
			FacesMessage fmsg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le nom et le pr�nom sont identiques", "Le nom et le pr�nom sont identiques");
			throw new ValidatorException(fmsg2);
			

			
		}
	} 
}