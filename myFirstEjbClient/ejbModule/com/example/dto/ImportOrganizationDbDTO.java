package com.example.dto;

public class ImportOrganizationDbDTO {
	private String organizationName;
	private String dbUrl;
	private String action;
	private String awsAccessKeyId;
	private String nextToken;
	private String selectExpression;
	private String signature;
	
	public ImportOrganizationDbDTO() {
		super();
	}

	public ImportOrganizationDbDTO(String organizationName, String dbUrl, String action, String awsAccessKeyId,
			String nextToken, String selectExpression, String signature) {
		super();
		this.setOrganizationName(organizationName);
		this.setDbUrl(dbUrl);
		this.setAction(action);
		this.setAwsAccessKeyId(awsAccessKeyId);
		this.setNextToken(nextToken);
		this.setSelectExpression(selectExpression);
		this.setSignature(signature);
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAwsAccessKeyId() {
		return awsAccessKeyId;
	}

	public void setAwsAccessKeyId(String awsAccessKeyId) {
		this.awsAccessKeyId = awsAccessKeyId;
	}

	public String getNextToken() {
		return nextToken;
	}

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	public String getSelectExpression() {
		return selectExpression;
	}

	public void setSelectExpression(String selectExpression) {
		this.selectExpression = selectExpression;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "ImportOrganizationDbDTO [organizationName=" + organizationName + ", dbUrl=" + dbUrl + ", action="
				+ action + ", awsAccessKeyId=" + awsAccessKeyId + ", nextToken=" + nextToken + ", selectExpression="
				+ selectExpression + ", signature=" + signature + "]";
	}

}
