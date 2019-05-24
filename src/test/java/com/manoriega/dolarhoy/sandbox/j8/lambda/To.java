package com.manoriega.dolarhoy.sandbox.j8.lambda;

import java.util.ArrayList;
import java.util.List;

public interface To {
    void csv();

    default List<Object> listSorted(List<Object> o) {
        return o.subList(1, 3);
    }


}
