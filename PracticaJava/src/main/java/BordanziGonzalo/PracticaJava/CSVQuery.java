package BordanziGonzalo.PracticaJava;

public class CSVQuery {
	
	private CSVNode parametersC;
	private CSVNode parametersP;
	
	public CSVNode getParametersP() {
		return parametersP;
	}
	public void setParametersP(CSVNode parameters) {
		this.parametersP = parameters;
	}
	public CSVNode getParametersC() {
		return parametersC;
	}
	public void setParametersC(CSVNode parameters) {
		this.parametersC = parameters;
	}
	
	public CSVQuery (String[] arr){
		CSVNode queryKeyC = new CSVNode(arr);
		queryKeyC.setCop("C");
		this.setParametersC(queryKeyC);
		CSVNode queryKeyP = new CSVNode(arr);
		queryKeyP.setCop("P");
		this.setParametersP(queryKeyP);			
	}
	
}
