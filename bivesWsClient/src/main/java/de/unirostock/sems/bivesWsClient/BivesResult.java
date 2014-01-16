package de.unirostock.sems.bivesWsClient;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BivesResult implements Serializable {
	
	private static final long serialVersionUID = -2807954477215637789L;
	
	private Map<String, List<String>> documentType;
	private Map<String, BivesModelMeta> meta;
	
	private String crnGraphml;
	private String crnDot;
	private String reportMd;
	private String reportHtml;
	private String compHierarchyDot;
	private String compHierarchyGraphml;
	private String xmlDiff;
	
	public BivesResult(Map<String, List<String>> documentType,
			Map<String, BivesModelMeta> meta, String crnGraphml, String crnDot,
			String reportMd, String reportHtml, String compHierarchyDot,
			String compHierarchyGraphml, String xmlDiff) {
		super();
		this.documentType = documentType;
		this.meta = meta;
		this.crnGraphml = crnGraphml;
		this.crnDot = crnDot;
		this.reportMd = reportMd;
		this.reportHtml = reportHtml;
		this.compHierarchyDot = compHierarchyDot;
		this.compHierarchyGraphml = compHierarchyGraphml;
		this.xmlDiff = xmlDiff;
	}

	public BivesResult() {
		this.documentType = null;
		this.meta = null;
		this.crnGraphml = null;
		this.crnDot = null;
		this.reportMd = null;
		this.reportHtml = null;
		this.compHierarchyDot = null;
		this.compHierarchyGraphml = null;
		this.xmlDiff = null;
	}

	public Map<String, List<String>> getDocumentType() {
		return documentType;
	}

	public void setDocumentType(Map<String, List<String>> documentType) {
		this.documentType = documentType;
	}

	public Map<String, BivesModelMeta> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, BivesModelMeta> meta) {
		this.meta = meta;
	}

	public String getCrnGraphml() {
		return crnGraphml;
	}

	public void setCrnGraphml(String crnGraphml) {
		this.crnGraphml = crnGraphml;
	}

	public String getCrnDot() {
		return crnDot;
	}

	public void setCrnDot(String crnDot) {
		this.crnDot = crnDot;
	}

	public String getReportMd() {
		return reportMd;
	}

	public void setReportMd(String reportMd) {
		this.reportMd = reportMd;
	}

	public String getReportHtml() {
		return reportHtml;
	}

	public void setReportHtml(String reportHtml) {
		this.reportHtml = reportHtml;
	}

	public String getCompHierarchyDot() {
		return compHierarchyDot;
	}

	public void setCompHierarchyDot(String compHierarchyDot) {
		this.compHierarchyDot = compHierarchyDot;
	}

	public String getCompHierarchyGraphml() {
		return compHierarchyGraphml;
	}

	public void setCompHierarchyGraphml(String compHierarchyGraphml) {
		this.compHierarchyGraphml = compHierarchyGraphml;
	}

	public String getXmlDiff() {
		return xmlDiff;
	}

	public void setXmlDiff(String xmlDiff) {
		this.xmlDiff = xmlDiff;
	}

}
