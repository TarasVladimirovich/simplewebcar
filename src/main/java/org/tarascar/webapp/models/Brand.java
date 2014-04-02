package org.tarascar.webapp.models;

public enum Brand {

 AUDI,BMW,MERSEDES,ZAZ,OPEL,VW,PORSHE,CADILLAC;

    public static int size(){
        int i=0;
       for(Brand b:Brand.values()){
          i++;
       }
        return i;
    }

}

