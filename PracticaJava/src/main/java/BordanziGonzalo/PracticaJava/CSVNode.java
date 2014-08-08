package BordanziGonzalo.PracticaJava;


public class CSVNode {
	
	private String ad_placement;
	private String format_iab;
	private String gender;
	private String age;
	private String scholarity;
	private String marital;
	private String income;
	private String connection;
	private String browser;
	private String so;
	private String interest_id;
	private String cop;
	
	public String getCop() {
		return cop;
	}
	public void setCop(String cop) {
		this.cop = cop;
	}
	public String getAd_placement() {
		return ad_placement;
	}
	public void setAd_placement(String ad_placement) {
		this.ad_placement = ad_placement;
	}
	public String getFormat_iab() {
		return format_iab;
	}
	public void setFormat_iab(String format_iab) {
		this.format_iab = format_iab;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getScholarity() {
		return scholarity;
	}
	public void setScholarity(String scholarity) {
		this.scholarity = scholarity;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public String getInterest_id() {
		return interest_id;
	}
	public void setInterest_id(String interest_id) {
		this.interest_id = interest_id;
	}
	
	public String deconstruct(String delimiter, Integer valueC, Integer valueP){
		StringBuilder builder = new StringBuilder();
		
		builder.append(ad_placement).append(delimiter);
		builder.append(format_iab).append(delimiter);
		builder.append(gender).append(delimiter);
		builder.append(age).append(delimiter);
		builder.append(scholarity).append(delimiter);
		builder.append(marital).append(delimiter);
		builder.append(income).append(delimiter);
		builder.append(connection).append(delimiter);
		builder.append(browser).append(delimiter);
		builder.append(so).append(delimiter);
		builder.append(interest_id).append(delimiter);
		builder.append(valueC).append(delimiter);
		builder.append(valueP);
		return builder.toString();
	}

	public CSVNode(String[] arr){
		
		this.setAd_placement(arr[0]);
		this.setFormat_iab(arr[1]);
		this.setGender(arr[2]);
		this.setAge(arr[3]);
		this.setScholarity(arr[4]);
		this.setMarital(arr[5]);
		this.setIncome(arr[6]);
		this.setConnection(arr[7]);
		this.setBrowser(arr[8]);
		this.setSo(arr[9]);
		this.setInterest_id(arr[10]);
		
		
		if (arr.length == 12){
			this.setCop(arr[11]);
		}
	}
	
	
	public CSVNode(CSVNode node) {
		this.setAd_placement(node.getAd_placement());
		this.setFormat_iab(node.getFormat_iab());
		this.setGender(node.getGender());
		this.setAge(node.getAge());
		this.setScholarity(node.getScholarity());
		this.setMarital(node.getMarital());
		this.setIncome(node.getIncome());
		this.setConnection(node.getConnection());
		this.setBrowser(node.getBrowser());
		this.setSo(node.getSo());
		this.setInterest_id(node.getInterest_id());
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ad_placement == null) ? 0 : ad_placement.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result
				+ ((connection == null) ? 0 : connection.hashCode());
		result = prime * result + ((cop == null) ? 0 : cop.hashCode());
		result = prime * result
				+ ((format_iab == null) ? 0 : format_iab.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result
				+ ((interest_id == null) ? 0 : interest_id.hashCode());
		result = prime * result + ((marital == null) ? 0 : marital.hashCode());
		result = prime * result
				+ ((scholarity == null) ? 0 : scholarity.hashCode());
		result = prime * result + ((so == null) ? 0 : so.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSVNode other = (CSVNode) obj;
		if (ad_placement == null) {
			if (other.ad_placement != null)
				return false;
		} else if (!ad_placement.equals(other.ad_placement))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (connection == null) {
			if (other.connection != null)
				return false;
		} else if (!connection.equals(other.connection))
			return false;
		if (cop == null) {
			if (other.cop != null)
				return false;
		} else if (!cop.equals(other.cop))
			return false;
		if (format_iab == null) {
			if (other.format_iab != null)
				return false;
		} else if (!format_iab.equals(other.format_iab))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (income == null) {
			if (other.income != null)
				return false;
		} else if (!income.equals(other.income))
			return false;
		if (interest_id == null) {
			if (other.interest_id != null)
				return false;
		} else if (!interest_id.equals(other.interest_id))
			return false;
		if (marital == null) {
			if (other.marital != null)
				return false;
		} else if (!marital.equals(other.marital))
			return false;
		if (scholarity == null) {
			if (other.scholarity != null)
				return false;
		} else if (!scholarity.equals(other.scholarity))
			return false;
		if (so == null) {
			if (other.so != null)
				return false;
		} else if (!so.equals(other.so))
			return false;
		return true;
	}

	
}
