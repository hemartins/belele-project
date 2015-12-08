/**
 * Copyright (C) Portugal Telecom Inovacao S.A., All Rights Reserved.
 *
 * This software is the proprietary information of Portugal Telecom Inovacao S.A.
 * Use is subject to license terms.
 */
package pt.belele.project.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanLocator {

    //avoid instantiation
    private BeanLocator() {

    }

    public static <T> T getBean(String jndiName) throws NamingException {
	Context ctx = new InitialContext();
	return (T) ctx.lookup(jndiName);
    }
}
