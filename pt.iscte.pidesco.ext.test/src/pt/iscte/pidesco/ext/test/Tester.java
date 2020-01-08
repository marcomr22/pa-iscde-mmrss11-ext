package pt.iscte.pidesco.ext.test;

import java.util.List;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import pt.iscte.pidesco.refactoring.ext.CodeGeneratorInt;

public class Tester implements CodeGeneratorInt{

	private List<FieldDeclaration> fields;
	private List<MethodDeclaration> methods;
	private String name;
	
	@Override
	public void inputValues(String name, List<FieldDeclaration> fields, List<MethodDeclaration> methods) {
		this.fields = fields;
		this.methods = methods;
		this.name = name;
	}

	@Override
	public String generateContent() {
		
		String s = "public class " + name + "\n" + "{";
		for (FieldDeclaration field : fields) {
			s = s + "\n" + field.toString();
		}
		for (MethodDeclaration method : methods) {
			s = s + "\n" + method.toString();
		}
		s = s + "}" + "\n";
		return s;
	}

}
