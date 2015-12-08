/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann.obj;

/**
 *
 * @author P056913
 */
public class DatasetProperties {

    private boolean includeGeneralVariables;
    private boolean includeCycleVariables;
    private boolean includeFRVariables;
    private boolean includeQLTVariables;
    private boolean includeH2HVariables;

    public DatasetProperties() {
	this.includeCycleVariables = false;
	this.includeCycleVariables = false;
	this.includeFRVariables = false;
	this.includeQLTVariables = false;
	this.includeH2HVariables = false;
    }

    public boolean isIncludeGeneralVariables() {
	return includeGeneralVariables;
    }

    public void setIncludeGeneralVariables(boolean includeGeneralVariables) {
	this.includeGeneralVariables = includeGeneralVariables;
    }

    public boolean isIncludeCycleVariables() {
	return includeCycleVariables;
    }

    public void setIncludeCycleVariables(boolean includeCycleVariables) {
	this.includeCycleVariables = includeCycleVariables;
    }

    public boolean isIncludeFRVariables() {
	return includeFRVariables;
    }

    public void setIncludeFRVariables(boolean includeFRVariables) {
	this.includeFRVariables = includeFRVariables;
    }

    public boolean isIncludeQLTVariables() {
	return includeQLTVariables;
    }

    public void setIncludeQLTVariables(boolean includeQLTVariables) {
	this.includeQLTVariables = includeQLTVariables;
    }

    public boolean isIncludeH2HVariables() {
	return includeH2HVariables;
    }

    public void setIncludeH2HVariables(boolean includeH2HVariables) {
	this.includeH2HVariables = includeH2HVariables;
    }

}
