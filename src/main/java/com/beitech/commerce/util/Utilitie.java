package com.beitech.commerce.util;


import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Service
public class Utilitie<t> {

    public List<t> removeDuplicate(List<t> objectses) {
        Set<t> clear = new HashSet<t>(objectses);
        objectses.clear();
        objectses.addAll(clear);
        return objectses;
    }

}
