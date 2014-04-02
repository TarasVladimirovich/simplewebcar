package org.tarascar.webapp.CriteriaService;

/**
 * Created by iAmater on 21.03.14.
 */
public class OrCriteria<T> implements Criteria<T> {

    private Criteria<T> criteria;
    private Criteria<T> criteria1;

    public OrCriteria(Criteria criteria, Criteria criteria1) {
        this.criteria = criteria;
        this.criteria1 = criteria1;
    }

    public boolean accept(T t) {
        return criteria.accept(t) || criteria1.accept(t);
    }

}
