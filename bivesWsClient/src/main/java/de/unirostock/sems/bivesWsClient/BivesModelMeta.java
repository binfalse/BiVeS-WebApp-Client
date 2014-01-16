package de.unirostock.sems.bivesWsClient;

import java.io.Serializable;
import java.util.Map;

public class BivesModelMeta implements Serializable {
	
	private static final long serialVersionUID = -6854174713496628122L;

	private Map<String, Integer> nodeStats;
	
	private String modelId;
	private String modelName;
	
	// SBML stuff
	private int sbmlLevel;
	private int sbmlVersion;
	
	// CellML stuff
	//...
	
	public BivesModelMeta(Map<String, Integer> nodeStats, String modelId,
			String modelName, int sbmlLevel, int sbmlVersion) {
		super();
		this.nodeStats = nodeStats;
		this.modelId = modelId;
		this.modelName = modelName;
		this.sbmlLevel = sbmlLevel;
		this.sbmlVersion = sbmlVersion;
	}
	
	public BivesModelMeta() {
		this.nodeStats = null;
		this.modelId = null;
		this.modelName = null;
		this.sbmlLevel = 0;
		this.sbmlVersion = 0;
	}

	public Map<String, Integer> getNodeStats() {
		return nodeStats;
	}

	public void setNodeStats(Map<String, Integer> nodeStats) {
		this.nodeStats = nodeStats;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getSbmlLevel() {
		return sbmlLevel;
	}

	public void setSbmlLevel(int sbmlLevel) {
		this.sbmlLevel = sbmlLevel;
	}

	public int getSbmlVersion() {
		return sbmlVersion;
	}

	public void setSbmlVersion(int sbmlVersion) {
		this.sbmlVersion = sbmlVersion;
	}

}
