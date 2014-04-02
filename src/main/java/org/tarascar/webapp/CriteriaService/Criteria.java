package org.tarascar.webapp.CriteriaService;

public interface Criteria <T> {

    boolean accept(T t);

}
