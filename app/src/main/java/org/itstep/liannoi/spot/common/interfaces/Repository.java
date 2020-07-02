package org.itstep.liannoi.spot.common.interfaces;

import java.util.List;

public interface Repository<TEntity> {
    List<TEntity> getAll();
}
