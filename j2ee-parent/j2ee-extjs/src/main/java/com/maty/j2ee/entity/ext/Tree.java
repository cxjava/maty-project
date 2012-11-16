package com.maty.j2ee.entity.ext;

import java.io.Serializable;
import java.util.List;

/**
 * ext tree
 * 
 * @author Maty Chen
 * @date 2011-10-19 下午10:04:45
 */
public class Tree implements Serializable {
	private static final long serialVersionUID = 4792916461618476974L;
	private String id;
	private String text;
	private String iconCls;
	private boolean expanded;
	private boolean leaf;
	private String url;
	private List<Tree> children;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return iconCls;
	}

	/**
	 * @param iconCls
	 *            the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * @return the expanded
	 */
	public boolean isExpanded() {
		return expanded;
	}

	/**
	 * @param expanded
	 *            the expanded to set
	 */
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	/**
	 * @return the leaf
	 */
	public boolean isLeaf() {
		return leaf;
	}

	/**
	 * @param leaf
	 *            the leaf to set
	 */
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the children
	 */
	public List<Tree> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<Tree> children) {
		this.children = children;
	}

}
