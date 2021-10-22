package com.aliergul.ekim.model.constants;

import java.io.Serializable;

public abstract class School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4911898806016193278L;
	public static final int WORKER = 100;
	public static final int LESSON = 300;
	public static final int CLASS_ROOM = 400;
	public static final int STUDENT = 200;
	public static final int SERVANT = 101;
	public static final int TEACHER = 102;
	public static final int OFFICER = 103;
	public static final int PERSON = 0;
	
	abstract public int getId();
	
}
