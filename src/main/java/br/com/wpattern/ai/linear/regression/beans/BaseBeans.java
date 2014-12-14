package br.com.wpattern.ai.linear.regression.beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Base of all beans. Print all attributes of bean.
 * 
 * @author Branquinho
 * @since December 4, 2012
 */
public abstract class BaseBeans implements Serializable {

	private static final long serialVersionUID = 5428492291006336745L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
