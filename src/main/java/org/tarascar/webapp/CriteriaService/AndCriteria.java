package org.tarascar.webapp.CriteriaService;

import java.util.Arrays;
import java.util.List;

public class AndCriteria<T> implements Criteria<T> {

    private List<Criteria<T>> criterias;

    public AndCriteria(List<Criteria<T>> criterias) {
        this.criterias = criterias;
    }

    public boolean accept(T t) {
        for (Criteria criteria : criterias){
            if (!criteria.accept(t)){
                return  false;
            }
        }
        return true;
    }
}
