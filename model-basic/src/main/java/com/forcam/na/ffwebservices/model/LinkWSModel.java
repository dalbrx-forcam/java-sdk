package com.forcam.na.ffwebservices.model;

import io.swagger.models.HttpMethod;

public class LinkWSModel {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** The title. */
	private String mTitle;

	/** A hyper reference. */
	private String mHref;

	/** The HTTP method. */
	private HttpMethod mMethod;

	/** Is this link model templated? */
	private boolean mTemplated;

	/** Is this link model embeddable? */
	private boolean mEmbeddable;

	public boolean isEmbeddable() {
		return mEmbeddable;
	}

	public void setEmbeddable(boolean mEmbeddable) {
		this.mEmbeddable = mEmbeddable;
	}
// ------------------------------------------------------------------------
	// getters/setters
	// ------------------------------------------------------------------------

	public String getHref() {
		return mHref;
	}

	public void setHref(String href) {
		this.mHref = href;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		this.mTitle = title;
	}

	public HttpMethod getMethod() {
		return mMethod;
	}

	public void setMethod(HttpMethod method) {
		mMethod = method;
	}

	public boolean isTemplated() {
		return mTemplated;
	}

	public void setTemplated(boolean templated) {
		mTemplated = templated;
	}
}